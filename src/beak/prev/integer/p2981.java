package beak.prev.integer;

import java.io.*;
import java.util.Arrays;

/**
 *  검문
 *  N개의 수를 M으로 나눴을 때 나머지가 같도록 만들어야 하는 문제
 *  가장 작은수로 전부 뺀 후, 최대공약수를 찾고, 최대 공약수의 약수들을 입력했음.
 */

public class p2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[]arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] - min;
        }
        int gcd = arr[1];
        if (n >= 3) {

            gcd = gcd(arr[2], arr[1]);
            for (int i = 2; i < n-1; i++) {
                gcd = gcd(arr[i+1],gcd);
            }

            for (int i = 2; i <=gcd; i++) {
                if(gcd % i ==0)
                    bw.write(i + " ");
            }
        }else{
            for (int i = 2; i <=min; i++) {
                if (gcd % i == 0)
                    bw.write(i + " ");
            }
        }



        bw.flush();
        bw.close();
        br.close();
    }



    public static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a % b);
    }

}