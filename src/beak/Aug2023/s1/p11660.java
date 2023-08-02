package beak.Aug2023.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/**

@author 규현
@since 2023-08-02
@url https://www.acmicpc.net/problem/11660
@level s1
@try ?
@performance 126444 / 728
@category #dp
@note
 누적합 문제임. 처음에 풀었을 때에는 사각형으로 쪼갤 생각은 했지만, 그 이후에 어떻게 구간을 구할 지 생각을 못했음.
 그래서 각 row별로 누적합을 구했는데, 사각형으로 누적합을 구하는 것이 맞았다.
*/
public class p11660 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n,m;
    static int[][]dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] + Integer.parseInt(st.nextToken()) - dp[i-1][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int result = dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);




    }



}
