package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1904 {


    int[]m;
    public static void main(String []args) throws Exception {
        new p1904().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        m = new int[n+2];


        System.out.println(fibo(n+1));


    }


    public int fibo(int n) {

        m[1]=1;
        m[2]=1;
        for (int i = 3; i <=n ; i++) {
            m[i] = (m[i-1]+m[i-2])%15746;
        }
        return m[n];
    }





}