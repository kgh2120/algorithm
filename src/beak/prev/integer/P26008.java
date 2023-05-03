package beak.prev.integer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/26008
    해시 해킹 골드 4
    해시 테이블 문제라는데 잘 모르겠음. 아닌거같음.
 */

public class P26008 {

    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(br.readLine());
        long mod = 1000000007;

        long r = 1;
        for (int i = 0; i < a-1; i++) {
            r *= (b % mod);
            r = r % mod;
        }
        System.out.println(r);
    }



    public static void main(String[] args) throws Exception {
        new P26008().solution();
    }

}
