package beak.math2;

import java.util.Scanner;
/*
    문제 : 직사각형에서 탈출
    난이도 : 브론즈 3
 */
public class p1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        distanceOfBorder(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

    }

    private static void distanceOfBorder(int x, int y, int w, int h) {
        int min = x;
        if(min > y)
            min =y;
        if(min > w-x)
            min = w-x;
        if(min > h-y)
            min = h-y;

        System.out.println(min);
    }
}
