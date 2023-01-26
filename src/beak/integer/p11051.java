package beak.integer;

import java.io.*;
import java.util.Scanner;

public class p11051 {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] matrix= new int[n+1][n+1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    matrix[i][j] = 1;
                } else {
                    int num = matrix[i - 1][j - 1] + matrix[i - 1][j];
                    matrix[i][j] = num%10007;
                }
            }
        }

        System.out.println(matrix[n][k]);


    }






}