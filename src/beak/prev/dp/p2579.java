package beak.prev.dp;

import java.util.Arrays;
import java.util.Scanner;

public class p2579 {

    int[]m;
    int[]dp;
    int n;
    public static void main(String []args) throws Exception {
        new p2579().solution();
    }

    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = new int[n+1];
        dp=new int[n+1];
        Arrays.fill(dp,-1);

        for (int i = 1; i <= n; i++) {
            m[i] = sc.nextInt();
        }
        dp[0]=m[0];
        dp[1]=m[1];
        if(n>=2)
            dp[2] = m[1] + m[2];

        int r = r(n);
        System.out.println(r);

    }

    public int r(int level) {

        if(dp[level]==-1)
            dp[level] = m[level] + Math.max(r(level-2), r(level-3)+m[level-1]);


        return dp[level];
    }

    }





