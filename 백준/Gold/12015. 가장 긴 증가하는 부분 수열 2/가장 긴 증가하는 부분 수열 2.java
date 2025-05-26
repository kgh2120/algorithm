import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[] arr;
    static int[]dp;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        st = new StringTokenizer(br.readLine());
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int idx = Arrays.binarySearch(dp, arr[i]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            dp[idx] = arr[i];
            maxIndex = Math.max(maxIndex, idx);
        }
        
        System.out.println(maxIndex+1);
       
        



    }




}
