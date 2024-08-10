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
        int[][] dp = new int[n][2];


        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int[] ints : dp) {
            Arrays.fill(ints,1);
        }


        for (int i = 0; i <n; i++) {
            int cur = arr[i];
            for (int j = i-1; j >= 0; j--) {
                int target = arr[j];

                if (target > cur) {
                    dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0], dp[j][1] ) +1);
                } else if (target < cur) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }

        int max = -1;
        for (int[] ints : dp) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }

        System.out.println(max);



    }


}