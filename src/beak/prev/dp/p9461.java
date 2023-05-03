package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 삼각형 변의 길이 구하기 문제
 * 패턴이 피보나치 수열하고 유사했음.
 * 한계치인 100에서의 값이 int형을 넘어서서 -가 나오게 됐음.
 * long 타입으로 변환해서 해결.
 */
public class p9461 {

    long[]m;
    public static void main(String []args) throws Exception {
        new p9461().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        m = new long[101];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(r(k)).append("\n");
        }
        System.out.println(sb.toString());


    }


    public long r(int n) {

        if(m[n]!=0)
            return m[n];

        m[1]=1;
        m[2]=1;
        m[3]=1;
        for (int i = 4; i <=n ; i++) {
            m[i]=m[i-3]+m[i-2];
        }
        return m[n];
    }





}