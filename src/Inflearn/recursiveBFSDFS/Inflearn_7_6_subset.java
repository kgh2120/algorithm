package Inflearn.recursiveBFSDFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Inflearn_7_6_subset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lim = sc.nextInt();

        D(1, lim, "");


    }

    public static void D(int now, int lim, String result) {
        if (now > lim) {
            System.out.println(result);
            return;
        }
        D(now+1,lim,result+" "+now);
        D(now+1,lim,result);
    }
}
