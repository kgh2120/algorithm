import java.util.*;
import java.io.*;

/*
    이동할 때, 빈칸 체크해줘야 함!
    빈칸 체크는,, 가로는 (0,1) 체크, 세로이동은 (1,0)체크, 대각 이동은 (0,1) (1,1), (1,0)체크
    바깥을 넘는지 그리고 1이 아닌지.
 */
public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] matrix;
    static long[][][] dp;


    public static void main(String[] args)  throws Exception {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n+1][n+1];
        dp = new long[3][n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][2] = 1;
        for(int i = 1; i<= n; i++){
            for(int j = 2; j<= n; j++){
                if(i==1 && j ==2) continue;
                if(matrix[i][j] == 1) continue;

                boolean upCheck = true;
                boolean leftCheck = true;
                boolean sideCheck = true;
                // 가로 췤,
                if(!isIn(i,j-1) || matrix[i][j-1] == 1)
                    leftCheck = false;
                if(!isIn(i-1,j) ||matrix[i-1][j] ==1)
                    upCheck = false;
                if(!isIn(i-1,j-1) ||matrix[i-1][j-1] == 1)
                    sideCheck = false;
                // 세로 췤
                // 대각 췤

                // 가로 더하기
                if(leftCheck)
                    dp[0][i][j] += dp[0][i][j-1] + dp[1][i][j-1];
                // 세로 더하기
                if(upCheck)
                    dp[2][i][j] += dp[2][i-1][j]+ dp[1][i-1][j];
                if(leftCheck && sideCheck && upCheck)
                    dp[1][i][j] += dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
                // 대각 더하기
            }
        }
        long answer = dp[0][n][n] + dp[2][n][n] + dp[1][n][n];
        System.out.println(answer);


    }

    static boolean isIn(int row, int col){
        return row >= 1 && row <=n && col >= 1 && col <=n;
    }
}