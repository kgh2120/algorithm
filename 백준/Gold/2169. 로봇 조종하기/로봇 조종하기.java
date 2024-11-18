import java.util.*;
import java.io.*;

/*
    (0,0) 부터 (n-1,m-1)까지 이동하며 최대한 많은 값을 가져가는 것이 목표.
    하지만 왼, 아래, 오른쪽으로만 이동이 가능함. 그리고 이미 지나친 곳은 안가는 것이 이득임.
    BFS + DP를 이용하고, BFS 큐에 들어갈 값에 마지막 이동 방향을 적어주어서 왼쪽이면 오른쪽으로 못가고,
    오른쪽이면, 왼쪽으로 못가게 해주면 되지않을까 싶다.

    입력값 N,M은 1000으로 전체 2차원 배열은 10만, 배열의 각 값은 |100|를 넘지 않으니,
    최대치는 1000만정도 될 것으로 int를 사용해도 좋아보임.



    추가 테케
    다 음수인 경우
    3 3
    -1 -1 -1
    -1 -1 -1
    -1 -1 -1

    -5

    음수를 뚫어야 정답인 경우
    4 4
    1 -10 -10 100
    1 -10 -10 100
    1 -10 -10 100
    1 1 1 1

    282

    지그재그로 잘 돌아야 되는 경우

    3 3
    1 1 1
    1 1 1
    1 1 1

    9

*/
public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] matrix;
    static int[][][] dp;

    static int[][] deltas = {{1,0}, {0,-1}, {0,1}}; // 1,2는 좌,우 합이 3이 되면 못가게 하는 식으로 하자.

    static int maxRow;
    static int maxCol;

    static final int INIT = -100_000_000;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        init();
        int result = findMostValuablePath(0,0,0);
        
        System.out.println(result);
    }

    static int findMostValuablePath(int row, int col, int direction){

        if(row == maxRow -1 && col == maxCol-1)
            return matrix[row][col];

        if(dp[direction][row][col] != INIT)
            return dp[direction][row][col];

        dp[direction][row][col] = matrix[row][col];
        int max = INIT;
        for (int i = 0; i < 3; i++) {
            if(direction + i == 3) continue;

            int nr = row + deltas[i][0];
            int nc = col + deltas[i][1];

            if (isIn(nr, nc)) {
                 max = Math.max(max, findMostValuablePath(nr,nc,i));
            }
        }

        return dp[direction][row][col] += max;

    }

    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    static void init() throws Exception{
        st= new StringTokenizer(input.readLine());
        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());

        matrix = new int[maxRow][maxCol];
        dp = new int[3][maxRow][maxCol]; // 근데, 다 음수일 수 있으니, init을 음수로 해줘야 할 듯.

        for(int[][] dd : dp)
            for(int[] d : dd)
                Arrays.fill(d,INIT);

        for(int row = 0; row < maxRow; row++){
            st = new StringTokenizer(input.readLine());
            for(int col = 0; col < maxCol; col++){
                matrix[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
