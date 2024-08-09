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

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {

            min = Math.min(min, dp(n-1, i));
        }
        System.out.println(min);




    }
    static int dp(int depth, int selected){

        if(depth == 0){
            return cost[depth][selected];
        }

        if(dp[depth][selected] != 10_0000_0000){
            return dp[depth][selected];
        }

        for (int i = 0; i < 3; i++) {
            if (i == selected) continue;

            dp[depth][selected] = Math.min(dp[depth][selected], dp(depth-1, i) + cost[depth][selected]);
        }

        return dp[depth][selected];
    }


}