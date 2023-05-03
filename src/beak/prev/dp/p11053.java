package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11053 {

    int []arr;
    int[]dp;
    int end;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        end = Integer.parseInt(br.readLine());
        arr = new int[end];
        dp = new int[end];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,-1);

        for (int i = 0; i < end; i++) {
            r(i);
        }
        int max = dp[0];
        for (int i = 1; i < end; i++) {
            max = Math.max(max, dp[i]);
        }


        System.out.println(max);
    }



    public int r(int n) {

        if (dp[n] == -1) {
            dp[n]=1;
            for (int i = n-1; i >=0 ; i--) {

                if(arr[n]>arr[i])
                    dp[n] = Math.max(dp[n],r(i)+1);
            }
        }
        return dp[n];
    }


    public static void main(String []args) throws Exception {
        new p11053().solution();
    }
}





