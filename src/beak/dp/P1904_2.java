package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1904_2 {


    long[]memo;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new long[n+1];
        memo[1] = 1;
        if(n>1)
            memo[2] = 2;
        System.out.println(dp(n));
    }

    public long dp(int n){

        if(memo[n] == 0)
            memo[n] = (dp(n-1) + dp(n-2)) % 15746;

        return memo[n];
    }
    public static void main(String[] args) throws Exception {
        new P1904_2().solution();
    }

}
