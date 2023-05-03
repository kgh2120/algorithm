package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9461_2 {


    long[]memo;
    final long[]p = {0,1,1,1,2,2,3,4,5,7,9};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            memo = new long[k+1];
            long r = 0;
            if (k <= 10) {
                r = p[k];
            }else{
                System.arraycopy(p,0,memo,0,11);
                r = dp(k);
            }
           sb.append(r).append("\n");
        }
        System.out.println(sb);
    }

    public long dp(int k) {
        if(memo[k]!=0)
            return memo[k];

        return memo[k] = dp(k-1) +dp(k-5);
    }


    public static void main(String[] args) throws Exception {
        new P9461_2().solution();
    }

}
