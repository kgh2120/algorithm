import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] value;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        value = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());
            value[i+1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n+1][n+1];

        for (int[] ints : dp) {
            Arrays.fill(ints,-1);

        }
        
        dp(1,n);

        System.out.println(dp[1][n]);
    }

    static int dp(int i, int j){
        if(i == j)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j ; k++) {
            min = Math.min(min, dp(i,k) + dp(k+1,j) + value[i-1] * value[k] * value[j]);
        }
        return dp[i][j] = min;
    }


}