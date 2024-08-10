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
        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);

        for (int i = 0; i <n ; i++) {
            int cur = arr[i];
            for (int j = i; j >= 0 ; j--) {
                int target = arr[j];

                if (cur > target) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }

        int max = -1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);


    }


}