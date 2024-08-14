import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();


    static int[][] dp;
    static int[][] matrix;

    static int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int [n][m];
        dp = new int[n][m];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0));
        // 막히는 길 처리하기..
        
    }

    static int dfs(int row, int col){

        if(row == n-1 && col == m-1)
            return 1;
        if(dp[row][col] >= 0)
            return dp[row][col];

        dp[row][col] = 0;
        for (int[] delta : deltas) {
            int nr = row + delta[0];
            int nc = col + delta[1];

            if (isIn(nr, nc) && matrix[row][col] > matrix[nr][nc]) {
                dp[row][col] += dfs(nr, nc);
            }
        }

        return dp[row][col];
    }

    static boolean isIn(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

}