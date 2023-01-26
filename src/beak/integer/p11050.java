package beak.integer;

import java.io.*;

public class p11050 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);

        int nf = factorial(n);
        int kf = factorial(k);
        int nkf = factorial(n - k);

        bw.write(String.valueOf(nf / (kf * nkf)));
        bw.flush();


    }

    public static int factorial(int n) {
        if(n == 0)
            return 1;
        int fac = 1;
        for (int i = n; i >= 1; i--) {
            fac *= i;
        }
        return fac;
    }




}