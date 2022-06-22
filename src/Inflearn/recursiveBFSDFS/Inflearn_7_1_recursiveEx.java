package Inflearn.recursiveBFSDFS;

import java.util.Scanner;

public class Inflearn_7_1_recursiveEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        recur(1,n);
        recur(n);
    }


    public static void recur(int i ,int n) {
        if(i>n) return;
        System.out.print(i+" ");
        recur(i+1,n);
    }

    public static void recur(int n) {
        if(n<=0) return;
        recur(n-1);
        System.out.print(n+" ");
    }
}
