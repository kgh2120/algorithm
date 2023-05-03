package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10844_2 {



    Long memo[][];
    int n;
    final int m = 1000000000;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new Long[n][10];
        for (int i = 0; i < 10; i++) {
            memo[0][i] = 1L;
        }
        memo[0][0] = 0L;
        getCount();

    }

    public void getCount(){
        long c = 0;
        for (int i = 0; i < 10; i++) {
            c+=dp(n-1,i);
        }
        System.out.println(c % m);
    }

    private long dp(int n, int i) {

        if(memo[n][i]!= null)
            return memo[n][i] % m;
        if(i == 0)
            memo[n][i] = dp(n-1,i+1);
        else if (i==9)
            memo[n][i] = dp(n-1,i-1);
        else
            memo[n][i] = (dp(n-1,i-1) + dp(n-1,i+1));

        return memo[n][i]  % m;

    }


    public static void main(String[] args) throws Exception {
        new P10844_2().solution();
    }

}
