package beak.dp;/* Java(자바) Hello, World! 예제 */

import java.io.*;

/**
 *  피보나치 수열을 DP를 사용해서 적용시키는 문제
 *  딱히 DP를 이상하게 사용하지는 않은 거 같았는데
 *  count를 배치하는 게 이해가 안갔음.
 */
public class p24416 {

    int c;
    int mc;
    int[]memo;
    public static void main(String []args) throws Exception {
        new p24416().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];

        fibo(n);
        fiboDP(n);
        System.out.println(c);
        System.out.println(mc);

//        System.out.println(sb.toString());

    }


    public int fibo(int n) {

        if (n == 2 || n == 1) {
            c++;
            return 1;
        }

        return fibo(n-1) + fibo(n-2);
    }

    public int fiboDP(int n) {


        for (int i = 3; i <=n; i++) {
            mc++;
            memo[i] = memo[i-1]+memo[i-2];
        }
            return memo[n];
        }

}