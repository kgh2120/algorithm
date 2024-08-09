import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    static int[][] cost;
    static int [][] dp;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(input.readLine());

        cost = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, 10_0000_0000);
        }


        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + cost[i][j]);
                }
                if (i == n - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        System.out.println(min);








    }


}