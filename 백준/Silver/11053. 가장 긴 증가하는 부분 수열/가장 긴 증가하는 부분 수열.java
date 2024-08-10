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
        int[] dp = new int[n+1];

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 10_0000_0000);

        int maxIndex = -1;
        for (int i = 0; i <n ; i++) {
            int cur = arr[i];

            int index = Arrays.binarySearch(dp, cur);
            if (index < 0) {
                index = -index - 1;
            }
            dp[index] = cur;
            maxIndex = Math.max(maxIndex, index);
        }
        System.out.println(maxIndex+1);




    }


}