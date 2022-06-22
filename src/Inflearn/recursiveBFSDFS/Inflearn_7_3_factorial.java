package Inflearn.recursiveBFSDFS;

import java.util.Scanner;

public class Inflearn_7_3_factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recur(n);
    }

    public static void recur(int n) {
        System.out.println(recur(n,1));

    }
    public static int recur(int n, int r) {
        if(n==0) return r;
        r *=n;
        return recur(n-1,r);
    }
}
