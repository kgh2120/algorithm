import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int[] dp;
    static int[] arr;

    static final int INIT = -1;
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        int n = Integer.parseInt(input.readLine());
        arr = new int[n];
        dp = new int[n];

        for(int i = 0; i<n; i++)
            arr[i] = Integer.parseInt(input.readLine());
        Arrays.fill(dp,1);


        dp[0] = 1;
        int max = -1;
        for (int i = 1; i <n ; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }

        System.out.println(n - max);

    }


}