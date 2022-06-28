package Inflearn.bfsdfs;

import java.util.Scanner;

public class Inflearn_8_6_CombinationMemo {
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        memo = new int[n+1][r+1];

        System.out.println(combinationMemo(n, r));

    }

    public static int combination(int n, int r) {
        if(n==r) return 1;
        if(r==0) return 1;

        return combination(n-1,r-1) + combination(n-1,r);
    }

    public static int combinationMemo(int n, int r) {
        if (n == r || r==0) {
            if(memo[n][r]==0)
                memo[n][r] = 1;
            return memo[n][r];
        }

        if(memo[n-1][r-1] == 0)
            memo[n-1][r-1] = combinationMemo(n-1,r-1);
        if (memo[n-1][r]==0)
            memo[n-1][r] = combinationMemo(n-1,r);

        return memo[n-1][r-1] + memo[n-1][r];
    }
}