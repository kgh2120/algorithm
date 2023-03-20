package zerobase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class P2830 {

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[20];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(Integer.parseInt(br.readLine())));
            String s = sb.reverse().toString();
            for (int j = 0; j < s.length(); j++) {
                int k = s.charAt(j) - 48;
                arr[j] +=k;
            }
        }

        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            total+= ((long) arr[i] * (n-arr[i]) *  pow(i));
        }
        System.out.println(total);


    }

    private static int pow(int i) {

        int c = 0;
        int t = 1;
        while (c != i) {
            t *=2;
            c++;
        }
        return t;
    }





}