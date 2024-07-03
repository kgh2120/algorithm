import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        dp[6] = 6;

        for (int i = 7; i <= 100 ; i++) {
            for (int j = 1; j < i-2 ; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i-1]+1, dp[ i - (j+2)] * (j+1)));
            }
        }


        System.out.println(dp[n]);

    }


}