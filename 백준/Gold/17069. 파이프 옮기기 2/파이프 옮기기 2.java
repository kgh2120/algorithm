import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long[][][] dp;
    static int[][] matrix;

    static final int R = 0;
    static final int C = 1;
    static int n;
    static final int LEFT = 0, CROSS = 1, UP = 2;
    static final int CANNOT = 2;

    static int[][][] deltas = {
            {
                    {0, -1},
                    {-1, -1}
            },
            {
                    {-1, 0},
                    {-1,-1},
                    {0, -1}
            },
            {
                    {-1,0},
                    {-1,-1}
            }
    };

    public static void main(String[] args) throws Exception {
        setVariables();

        if (matrix[n - 1][n - 1] == 1) {
            System.out.println(0);
            return;
        }

        long result = 0;
        boolean up = matrix[n-2][n-1] != 1;
        boolean left = matrix[n-1][n-2] != 1;
        if (matrix[n - 1][n - 2] == 0) {
            result += dp(LEFT, n - 1, n - 2);
        }
        if (matrix[n - 2][n - 1] == 0) {
            result += dp(UP, n - 2, n - 1);
        }
        if(matrix[n-2][n-2]  == 0 && (up & left))
            result+=dp(CROSS,n-2,n-2);
        System.out.println(result);
    }

    private static long dp(int d, int r, int c){
        if(r == R && c == C) return 1;
        if(dp[d][r][c] != -1) return dp[d][r][c];

        // 현재 위치에서 갈 수 있는 거 체크해서 뿌리기.
        int[][] delta = deltas[d];
        long result = 0;

        for (int i = 0; i<delta.length; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if(!isIn(nr,nc) ||  matrix[nr][nc] != 0) continue;

            if (d == LEFT) {
                if (i == 0 && leftCheck(r,c)) {
                    result += dp(LEFT,nr,nc);
                }else if(i == 1 &&moveCrossCheck(r,c))
                    result += dp(CROSS,nr,nc);
            } else if (d == CROSS) {
                if(i == 0 && upCheck(r,c))
                    result += dp(UP,nr,nc);
                else if(i == 2 && leftCheck(r,c))
                    result += dp(LEFT,nr,nc);
                else if(i == 1 && moveCrossCheck(r,c))
                    result += dp(CROSS,nr,nc);
            }else{
                if(i == 0 && upCheck(r,c))
                    result += dp(UP,nr,nc);
                else if(i == 1 && moveCrossCheck(r,c))
                    result += dp(CROSS,nr,nc);
            }
        }
        return   dp[d][r][c] = result;
    }

    private static void setVariables() throws IOException {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        dp = new long[3][n][n];

        for (long[][] longs : dp) {
            for (long[] aLong : longs) {
                Arrays.fill(aLong,-1);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        matrix[0][0] = CANNOT;
        for (int i = 1; i < n; i++) {
            if(matrix[i][0] != 1)
                matrix[i][0] = CANNOT;
            if(matrix[i][1] != 1)
                matrix[i][1] = CANNOT;

        }
        if(matrix[n-1][1] == 0)
            matrix[n-1][1] = CANNOT;
        if(matrix[0][n-1] == 0)
            matrix[0][n-1] = CANNOT;
        if(matrix[n-1][2] == 0)
        matrix[n-1][2] = CANNOT;
    }

    private static boolean moveCheck(int d, int r, int c){
        if(d == 0)
            return leftCheck(r,c);
        return upCheck(r,c);
    }

    private static boolean upCheck(int row, int col){
        return isIn(row-1,col) &&  matrix[row - 1][col] != 1;
    }
    private static boolean leftCheck(int row, int col){
        return isIn(row,col-1)&& matrix[row][col-1] != 1;
    }
    private static boolean moveCrossCheck(int row, int col){
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        if(isIn(row-1,col) && matrix[row-1][col] != 1)
            f1 = true;
        if(isIn(row-1,col-1) && matrix[row-1][col-1] != 1)
            f2 = true;
        if(isIn(row,col-1) && matrix[row][col-1] != 1)
            f3 = true;
        return (f1 & f2 & f3);
    }
    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n ;
    }
}