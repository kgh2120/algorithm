import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(input.readLine());
        int [] dp = new int[n+1];
        Arrays.fill(dp, 10_0000_0000);
        dp[n] = 0;

        for (int i = n; i > 1 ; i--) {

            if (i % 3 == 0) {
                dp[i/3] = Math.min(dp[i/3] , dp[i] + 1);
            }
            if (i % 2 == 0) {
                dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
            }
            dp[i-1] = Math.min(dp[i-1], dp[i]+1);
        }
      
        System.out.println(dp[1]);
    }



}