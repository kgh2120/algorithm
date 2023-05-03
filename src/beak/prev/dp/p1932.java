package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정수 삼각형.
 * 솔직히 문제 자체가 어렵지는 않았던거 같은데 이해를 너무 늦게했다.
 * matrix문제 처럼 사전 준비를 할 수 있는 상황 (한 방향으로만 가는 경우)가 있어서
 * 실제 로직은 간단했음.
 * 다만 삼각형을 matrix로 옮기는 과정에서 대각선 이동을 row,col 이동으로 표현함에 있어서
 * 헷갈려서 오래걸렸다.
 */
public class p1932 {

    long[][]m;
    long[][]dp;
    int n;
    public static void main(String []args) throws Exception {
        new p1932().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new long[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()) {
                m[i][index++] = Integer.parseInt(st.nextToken());
            }
        }
        set();
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(r(n-1,i),max);
        }
        System.out.println(max);

    }

    public long r(int row, int col) {

        if(dp[row][col]!=-1)
            return dp[row][col];

        return dp[row][col] = m[row][col] + Math.max(r(row-1,col-1),r(row-1,col));
    }

    public void set() {
        dp[0][0] = m[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = m[i][0] + dp[i-1][0];
            dp[i][i] = m[i][i] + dp[i-1][i-1];
        }
    }





}