import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    static int[][] tri;
    static int [][] dp;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(input.readLine());
        tri = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
            }
        }

        int max = -1;
        for (int value : dp[n]) {
            max = Math.max(max, value);
        }
        System.out.println(max);

    }


}