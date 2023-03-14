package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9095 {

    int[] memo;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        for (int i = 0; i < loop; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[n+1];
            System.out.println(dp(n));
        }
    }

    public int dp(int n){
        if (n == 1) {
            if(memo[1] == 0)
                memo[1] = 1;
            return memo[1];
        }
        if (n == 2) {
            if (memo[2] == 0)
                memo[2] = 2;
            return memo[2];
        }

        if (n == 3) {
            if (memo[3] == 0)
                memo[3] = 4;
            return memo[3];
        }

        if(memo[n-1] == 0)
            memo[n-1] = dp(n-1);
        if(memo[n-2]==0)
            memo[n-2] = dp(n-2);
        if(memo[n-3]==0)
            memo[n-3] = dp(n-3);


        return memo[n-1] + memo[n-2] + memo[n-3];
    }




    public static void main(String[] args) throws Exception {
        new P9095().solution();
    }

}
