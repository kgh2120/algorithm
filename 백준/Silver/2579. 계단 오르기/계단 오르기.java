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
        int [] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i <= n+1 ; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        int [] dp = new int[n+2];
        for (int i = 0; i < n + 2; i++) {

            int v = i+2;
            if (v < n + 2) {
                dp[v] = Math.max(dp[v], dp[i] + arr[v]);
            }
            int vv = i+3;
            if (vv < n + 2) {
                dp[vv] = Math.max(dp[vv], dp[i] + arr[vv] + arr[i+1]);
            }
        }
        dp[n+1] = Math.max(dp[n+1], dp[n] + arr[n+1]);
        
        System.out.println(dp[n+1]);
    }



}