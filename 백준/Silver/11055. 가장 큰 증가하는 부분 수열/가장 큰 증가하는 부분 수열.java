import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
       int n = Integer.parseInt(br.readLine());
       int [] arr = new int[n];
       int[] dp = new int[n];
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
           dp[i] = arr[i];
       }

       int max = dp[0];
       for (int i = 1; i < n; i++) {
           for (int j = i - 1; j >= 0; j--) {
               if (arr[i] > arr[j]) {
                   dp[i] = Math.max(dp[i], dp[j] + arr[i]);
               }
           }
           max = Math.max(max, dp[i]);
       }

        System.out.println(max);



    }



}
