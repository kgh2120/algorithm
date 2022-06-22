package Inflearn.recursiveBFSDFS;

import java.util.Scanner;

public class Inflearn_7_2_binaryNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recur(n);
    }

    public static void recur(int n) {
        if(n==0) return;
        int m = n%2;
        recur(n/2);
        System.out.print(m);

    }
}
