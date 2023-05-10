package beak.May2023.b15829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = 31;
        int M = 1234567891;
        int n = Integer.parseInt(br.readLine());
        long total = 0;
        char[] chars = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            int k = chars[i] - 'a' + 1;

            total += (k * pow(r,i,M)) % M;
            total = total%M;
        }
        System.out.println(total%M);

    }
    private static long pow(int r, int i, int M){
        if(i == 0)
            return 1;
        long rV = r;
        for (int j = 1; j < i; j++) {
            rV *= r % M;
            rV = rV % M;
        }
        return rV;
    }
}