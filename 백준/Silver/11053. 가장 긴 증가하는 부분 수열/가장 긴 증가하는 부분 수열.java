import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] dp;
    static int[]arr;
    static final int INIT = -1;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        arr = new int[n];
        Arrays.fill(dp,INIT);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,LIS(i));
        }
        System.out.println(max);
//        System.out.println(Arrays.toString(dp));
    }
    private static int LIS(int index) {
        if(dp[index] != INIT) return dp[index];

        dp[index] = 1;
        for (int i = 0; i < index ; i++) {
            if (arr[i] < arr[index]) {
                dp[index] = Math.max(dp[index], LIS(i) +1);
            }
        }
        return dp[index];
    }
}