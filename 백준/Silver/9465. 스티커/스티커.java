import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st1;
    static StringTokenizer st2;
    static int n;
    static int[][] dp;
    static int answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws Exception {

      

        T = Integer.parseInt(br.readLine());
     
        for (int t = 0; t < T; t++) {
             n = Integer.parseInt(br.readLine());
             dp = new int[2][n+1];

             st1 = new StringTokenizer(br.readLine());
             st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int upper = Integer.parseInt(st1.nextToken());
                int lower = Integer.parseInt(st2.nextToken());

                dp[0][i + 1] = Math.max(dp[1][i] +lower, dp[0][i]);
                dp[1][i + 1] = Math.max(dp[1][i], dp[0][i] + upper);
            }

            answer = Math.max(dp[0][n], dp[1][n]);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }


}