import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        dp = new int[max + 1][3];

        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[3][2] = 1;


        jump(1, max + 1);

        for (int i : arr) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += dp[i][j];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static void jump(int depth, int max) {
        if (depth == max) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                if (depth - (i+1) > 0) {
                    dp[depth][i] += dp[depth - (i+1)][j - 1];
                }
            }
        }
        jump(depth+1, max);
    }


}