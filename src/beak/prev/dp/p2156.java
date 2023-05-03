package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * DP문제. 기존에 알 던 선택 식에서
 * 선택하지 않는 식을 추가로 넣어서 해결해 보았다.
 *
 */
public class p2156 {

    int[] dp;
    int[]arr;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr= new int[n+2];
        dp= new int[n+2];
        Arrays.fill(dp,-1);


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        r(n+1);
        System.out.println(dp[n+1]);
    }


    public int r(int n) {
        if(n<0)
            return 0;
        if (dp[n] != -1) {
            return dp[n];
        }

        int eat = arr[n] + Math.max((arr[n - 1] + r(n - 3)), r(n - 2));

        return dp[n] = Math.max(eat,r(n-1));

    }




    public static void main(String []args) throws Exception {
        new p2156().solution();
    }
}





