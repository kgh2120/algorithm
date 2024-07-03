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
        int[] costs = new int[n];
        int[] values = new int[n];
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
           int cost = costs[i];
            if (i + cost  <= n) {
                dp[i + cost ] = Math.max(dp[i+cost  ], dp[i] + values[i]);
            }

                dp[i+1] = Math.max(dp[i+1], dp[i]);



        }
        System.out.println(dp[n]);


    }


}