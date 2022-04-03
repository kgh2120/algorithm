package beak.math2;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
    문제 : 택시기하학
    난이도 : 브론즈 3
 */
public class p3053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();

        double u = r*r*Math.PI;
        double taxi = r*r*2;

        DecimalFormat df = new DecimalFormat(".000000");

        System.out.println(df.format(u) + " "+df.format(taxi));


    }
}
