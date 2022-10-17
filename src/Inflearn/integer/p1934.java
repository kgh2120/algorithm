package Inflearn.integer;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  최소공배수
 *  최소 공배수를 구하는 문제, 유클리드 호제법을 통해 최대공약수를 구한다면
 *  쉽게 풀 수 있음.
 */

public class p1934 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1= Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            bw.write(lcm(n1,n2) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }

    public static int lcm(int a, int b) {
        int gcd = gcd(Math.max(a,b), Math.min(a,b));
        return a * b / gcd;
    }

}