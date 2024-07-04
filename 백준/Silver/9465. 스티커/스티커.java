import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[2][n];
            int[][] dp = new int[2][n+1];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                matrix[0][i] = Integer.parseInt(st1.nextToken());
                matrix[1][i] = Integer.parseInt(st2.nextToken());
            }


            for (int i = 0; i < n; i++) {
                dp[0][i + 1] = Math.max(dp[1][i] + matrix[1][i], dp[0][i]); // 셀렉트 안하고 같은 라인 이동하기
                dp[1][i + 1] = Math.max(dp[1][i], dp[0][i] + matrix[0][i]); // 셀렉트 하고 반대 라인 이동하기
            }

            int answer = Math.max(dp[0][n], dp[1][n]);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }


}