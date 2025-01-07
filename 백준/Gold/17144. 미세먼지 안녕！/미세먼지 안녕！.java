import java.util.*;
import java.io.*;

/**

 미세먼지 확산 로직
 미세먼지가 있는 곳에서 사방으로(칸이 없는곳, 공청기 위치는 제외) a/5 만큼 퍼뜨리기.
 자기 칸은 퍼뜨린 만큼을 빼주면 된다.

 이 과정에 모든 칸에서 동시에 발생하니까, 순서에 의해서 로직이 꼬이지 않게 주의해줘야 함.

 임시 배열을 하나 만들어두고, 거기에 있는 값을 이후에 본래 값과 추가하면 될듯
 ex) 아래처럼 배열을 만들고, 나중에 합하는 식으로 사용하기.
 0 0 0       0 9 0
 0 46 0  ->  9 -36 9
 0 0 0       0 9 0

 순환 방법은 가장자리에서만 발생하는 듯 하니까, 해당 부분만 반복문을 적용해서 없애주면 될 것 같다.

 **/

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] matrix;
    static int[][] calculateMatrix;

    static int maxRow;
    static int maxCol;
    static int time;

    static int upperCleanerRow = -1;
    static int lowerCleanerRow = -1;

    static int[][] deltas = {
            {-1,0}, {0,-1}, {0,1}, {1,0}
    };

    static final int CLEANER_BLOCK = -1;
    static final int INIT = -1;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        init();
        clean();
        int answer = calculateRemainDirt();
        System.out.println(answer);
    }

    static int calculateRemainDirt(){
        int totalDirt = 0;
        for(int i = 0; i<maxRow;i++){
            for(int j = 0; j < maxCol; j++){
                if(isCleanerBlock(i,j)) continue;
                totalDirt += matrix[i][j];
            }
        }
        return totalDirt;
    }


    // 공청기 동작하기
    static void clean(){

        // 주어진 시간만큼 돌리기
        while(time-->0){

            // 확산시키기
            spreadDirt();
   
            // 회전시키기
            rotateDirt();
      
        }

    }

    static void printMatrix(){
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }


    static void rotateDirt(){
        // 위쪽
        rotateUpper();
        // 아래쪽
        rotateLower();
    }

    static void rotateUpper(){

        // 공청기 위부터 시계방향으로 빨아주기

        for(int i = upperCleanerRow-1; i > 0; i--){
            matrix[i][0] = matrix[i-1][0];
        }

        // 맨 위쪽에 왼쪽으로 이동시키기
        for(int j = 0; j<maxCol-1; j++){
            matrix[0][j] = matrix[0][j+1];
        }

        // 가장 오른쪽 위로 올리기
        for(int i = 0; i<upperCleanerRow; i++ ){
            matrix[i][maxCol-1] = matrix[i+1][maxCol-1];
        }

        // 가장 아래쪽 오른쪽으로 밀기
        for(int j = maxCol-1; j>0; j--){
            matrix[upperCleanerRow][j] = matrix[upperCleanerRow][j-1];
        }

        matrix[upperCleanerRow][1] = 0;

    }

    static void rotateLower(){

        // 공청기 위부터 시계방향으로 빨아주기

        for(int i = lowerCleanerRow+1; i < maxRow-1; i++){
            matrix[i][0] = matrix[i+1][0];
        }


        for(int j = 0; j<maxCol-1; j++){
            matrix[maxRow-1][j] = matrix[maxRow-1][j+1];
        }


        for(int i = maxRow-1; i>lowerCleanerRow; i-- ){
            matrix[i][maxCol-1] = matrix[i-1][maxCol-1];
        }

        // 가장 아래쪽 오른쪽으로 밀기
        for(int j = maxCol-1; j>0; j--){
            matrix[lowerCleanerRow][j] = matrix[lowerCleanerRow][j-1];
        }

        matrix[lowerCleanerRow][1] = 0;

    }


    static void spreadDirt(){


        // 번지게하기
        spread();
        // 적용시키기
        applySpreadResult();

    }

    static void applySpreadResult(){
        for(int i = 0; i<maxRow; i++){
            for(int j = 0; j<maxCol; j++){
                if(isCleanerBlock(i,j)) continue;

                matrix[i][j] += calculateMatrix[i][j];
                matrix[i][j] = Math.max(0, matrix[i][j]);
            }
        }
    }

    static void spread(){
        calculateMatrix = new int[maxRow][maxCol];

        for(int i = 0; i<maxRow; i++){
            for(int j = 0; j<maxCol; j++){

                if(isCleanerBlock(i,j)) continue;

                int spreadDirtAmount = matrix[i][j] / 5;
                int spreadCount = 0;
                for(int [] delta : deltas){
                    int nextRow = i + delta[0];
                    int nextCol = j + delta[1];

                    if(canSpread(nextRow, nextCol)){
                        spreadCount++;
                        calculateMatrix[nextRow][nextCol] += spreadDirtAmount;
                    }
                }
                calculateMatrix[i][j] -= spreadDirtAmount * spreadCount;
            }
        }

    }

    static boolean isCleanerBlock(int row, int col){
        return matrix[row][col] == CLEANER_BLOCK;
    }

    static boolean canSpread(int row, int col){
        return isIn(row, col) && matrix[row][col] != CLEANER_BLOCK;
    }

    // 2차원 배열의 경계 안에 있는지 체크
    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    // input을 받아 변수에 설정해주기
    static void init() throws Exception{
        st = new StringTokenizer(input.readLine());

        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        matrix = new int[maxRow][maxCol];



        for(int i = 0; i<maxRow; i++){

            st = new StringTokenizer(input.readLine());

            for(int j = 0; j<maxCol; j++){

                int block = Integer.parseInt(st.nextToken());

                matrix[i][j] = block;

                if(block == CLEANER_BLOCK){
                    if(upperCleanerRow == INIT){
                        upperCleanerRow  = i;
                    } else {
                        lowerCleanerRow  = i;
                    }
                }
            }


        }
    }
}
