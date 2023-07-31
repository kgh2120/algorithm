package beak.Jul2023.p11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int mod = 10_007;

    static int[][] matrix;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n+1][n+1];

        long result = 0;
        for(int i = 0; i<=n/2; i++){
            result += comb(n-i,i) % mod;
        }
        System.out.println(result % mod);
    }

    private static int comb(int n, int r){

        if(r == 0 || n == r)
            return matrix[n][r] = 1;
        if(r == 1)
            return matrix[n][r] = n;

        if(matrix[n][r] != 0)
            return matrix[n][r] % mod;
        return matrix[n][r] = (comb(n-1,r) % mod + comb(n-1,r-1) % mod) % mod;
    }



}