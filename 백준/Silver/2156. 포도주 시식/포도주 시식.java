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
        int[] value = new int[n+3];
        int[] dp = new int[n + 3];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(input.readLine());
        }

      for (int i = 0; i < n; i++) {

          dp[i+1] = Math.max(dp[i+1], dp[i]);
          dp[i+2] = Math.max(dp[i+2], dp[i] + value[i]);
          dp[i+3] = Math.max(dp[i+3], dp[i] + value[i] + value[i+1]);
      }

        int max = -1;
        for (int i : dp) {
            max = Math.max(max, i);
        }


//        System.out.println(Arrays.toString(dp));
        System.out.println(max);

    }


}