package Inflearn.recursiveBFSDFS;

import java.util.Scanner;

public class Inflearn_7_4_fibonacci {
    static int [] memo;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n+1];
        long start = System.currentTimeMillis();
        for (int i = 0; i <n; i++) {
            System.out.print(fibo(i) + " ");
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("[피보나치 종료]" + (end-start));

        long start2 = System.currentTimeMillis();
        fiboMemo(n);

        System.out.println();
        for (int i = 1; i < n+1; i++) {
            System.out.print(memo[i] + " ");
        }
        long end2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("[피보나치 Memoization 종료]" +(end2-start2));
    }

    public static int fibo(int n) {
        if (n < 0) return -1;
        if (n <= 1) {
            return 1;
        } else {
            int r = fibo(n - 2) + fibo(n - 1);
            return r;
        }
    }


    public static int fiboMemo(int n) {
        if (n <= 0) return -1;
        if (n <= 2) {
            if(memo[n] == 0)
                memo[n] = 1;

            return  memo[n];
        } else {
            if(memo[n] == 0)
                memo[n] = fiboMemo(n - 2) + fiboMemo(n - 1);

            return memo[n];
        }
    }
}
