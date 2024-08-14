import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    static long[][]dp;
    static int[] arr;
    static int[] acc;
    static int n;

    public static void main(String[] args) throws Exception {

        int t = Integer.parseInt(input.readLine());


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(input.readLine());
            st = new StringTokenizer(input.readLine());
            arr = new int[n];
            acc = new int[n+1];
            dp = new long[n][n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                acc[j+1] = arr[j] + acc[j];
                Arrays.fill(dp[j], -1);
            }

            output.append(findMin(0,n-1)).append("\n");
        }
        System.out.println(output);
    }

// dp는 총 비용을 기록한다.
    static long findMin(int left, int right) {

        if(dp[left][right] != -1) return dp[left][right];

        if(left == right) return 0;

        long min = Long.MAX_VALUE;
        for (int i = left; i < right ; i++) {
             min = Math.min(min, findMin(left, i) + findMin(i + 1, right) + acc[right+1] - acc[left]) ;
        }
        return dp[left][right] = min;
    }


}