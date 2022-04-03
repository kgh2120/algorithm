package Inflearn.twoPointerslidewindow;

import java.util.Scanner;

public class inflearn3_3_MaxSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int chain = sc.nextInt();
        int[] arr = new int[days];

        for (int i = 0; i < days; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;


        for (int i = 0; i < chain; i++) {
            sum += arr[i];
        }
        int max = sum;
        int s = 0;
        int e = chain-1;

        while (e < days-1) {
            sum = sum - arr[s++] + arr[++e];
            if (sum > max)
                max = sum;
        }

        System.out.println(max);

    }
}
