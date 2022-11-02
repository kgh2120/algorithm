
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    long[][]m;
    long[][]dp;
    int n;
    public static void main(String []args) throws Exception {
        new Main().solution();
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