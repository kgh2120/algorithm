package beak.prev.integer;

import java.util.Scanner;

public class p1679 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        int r = 0;
        while (i!= 0) {
            i = i/5;
            r +=i;
        }
        System.out.println(r);

    }



}