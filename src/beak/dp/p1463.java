package beak.dp;

import java.util.Arrays;
import java.util.Scanner;

public class p1463 {

    int[]m;
    int[]dp;
    int n;
    public static void main(String []args) throws Exception {
        new p1463().solution();
    }

    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);


        r(n,0);
        System.out.println(dp[1]);
    }

    public void r(int num, int count) {


            if(dp[num]<count)
                return;
            dp[num] = Math.min(count,dp[num]);

        if(num==1)
            return;


        if(num%3 == 0)
            r(num/3,count+1);
        if(num%2 == 0)
            r(num/2, count+1);
        r(num-1,count+1);


    }
    }





