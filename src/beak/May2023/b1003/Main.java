package beak.May2023.b1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static StringBuilder sb;

    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {

            int k = Integer.parseInt(br.readLine());
            memo = new int[k+1][2];
            for (int[] ints : memo) {

                Arrays.fill(ints,-1);
            }
            fibo(k);
            sb.append(memo[k][1])
                    .append(" ")
                    .append(memo[k][0])
                    .append("\n");
        }
        System.out.println(sb);

    }

    private static int[] fibo(int n) {
        if(memo[n][0] != -1 && memo[n][1] != -1){
            return memo[n];
        }

        if (n == 0) {
            memo[0][0] = 0;
            memo[0][1] = 1;
            return memo[0];
        }
        if (n == 1) {
            memo[1][0] = 1;
            memo[1][1] = 0;
            return memo[1];
        }

        int[] n1 = fibo(n - 1);
        int[] n2 = fibo(n - 2);
        memo[n][0] = n1[0] + n2[0];
        memo[n][1] = n1[1] + n2[1];
        return memo[n];
    }


}