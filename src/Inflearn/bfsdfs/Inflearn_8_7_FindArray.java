package Inflearn.bfsdfs;

import java.util.Scanner;

public class Inflearn_8_7_FindArray {

    static int[][] memo;
    static int [] comb;
    static int[] prev;
    static boolean find;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = sc.nextInt();

        memo = new int[n+1][n+1];
        comb = new int[n];
        prev = new int[n];
        for (int i = 0; i <n; i++) {
            comb[i] = combination(n-1, i);
        }

        findNum(n, 0, ans);

        if(find)
            for (int i : prev) {
                System.out.print(i+" ");
            }

    }

    public static void findNum(int n, int level, int ans) {
        if(find) return;

        if (n <= level) {
            if (total() == ans) {

                find = true;
            }

        }else{
            for (int i = 1; i <=n ; i++) {
                if (!contains(i)) {
                    prev[level] = i;
                    findNum(n,level+1,ans);
                    if(find) return;
                    prev[level] = 0;
                }

            }
        }
    }

    public static int total() {
        int total = 0;
        for (int i = 0; i < prev.length; i++) {
            total += prev[i] * comb[i];
        }
        return total;
    }

    public static boolean contains(int i) {
        for (int i1 : prev) {
            if(i == i1)
                return true;
        }
        return false;
    }


    public static int combination(int n, int r) {
        if(memo[n][r] != 0)
            return memo[n][r];
        else{
            if (n == r || r == 0) {
                if(memo[n][r]==0)
                    memo[n][r] = 1;
                return memo[n][r];
            }

            if(memo[n-1][r-1] == 0)
                memo[n-1][r-1] = combination(n-1,r-1);
            if(memo[n-1][r] == 0)
                memo[n-1][r] = combination(n-1,r);
            return memo[n-1][r-1] + memo[n-1][r];
        }



    }

}