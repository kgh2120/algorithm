import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int [][] matrix;

    static int[][] answer;
    static int[] counts;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        matrix = new int[10][10];
        answer = new int[10][10];


        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        counts = new int[6];
        Arrays.fill(counts,5);

        bf(0,0,matrix,0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void bf(int row, int col, int[][] matrix, int cnt){
        if(cnt >= min)
            return;

        if (row == 10) {
            // check answer
            if (isAnswer(matrix)) {
                min = Math.min(min, cnt);
            }
            return;
        }

        if (matrix[row][col] == 0) {
            int[] cord = nextCord(row, col);
            bf(cord[0],cord[1],matrix, cnt);
            return;
        }

        for (int i = 5; i >=1 ; i--) {
            // 그 만큼 돌면서 가능한지 체크하고, 가능하면 박아넣고 bf 진행하기.
            if(counts[i] <= 0) continue;
            counts[i]--;
            int[][] temp = copyOf(matrix);
            if (mapping(temp, i, row, col)) {
                int[] cord = nextCord(row, col);
                bf(cord[0], cord[1], temp, cnt+1);
            }
            counts[i]++;
        }
    }

    private static boolean isAnswer(int[][] matrix){
        for (int i = 0; i < 10; i++) {
            if(!Arrays.equals(matrix[i], answer[i]))
                return false;
        }
        return true;
    }

    private static int[] nextCord(int row, int col){
        if (++col == 10) {
            col = 0;
            row += 1;
        }
        return new int[]{row,col};
    }

    private static boolean mapping(int[][] temp, int count, int row, int col){
        for (int j = 0; j < count; j++) {
            for (int k = 0; k < count; k++) {
                int nr = row + j;
                int nc = col + k;
                if (isIn(nr, nc) && temp[nr][nc] == 1) {
                    temp[nr][nc] = 0;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    private static int[][] copyOf(int[][] origin){
        int[][] copy = new int[10][10];
        for (int i = 0; i < 10; i++) {
            System.arraycopy(origin[i],0,copy[i],0,10);
        }
        return copy;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }





}