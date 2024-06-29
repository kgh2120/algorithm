/* Java(자바) Hello, World! 예제 */
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;

    static int [][] matrix;
    static int [][][]dp;

    static int[] deltas =
            {-1,0,1};
    static public void main(String []args) throws Exception {

        setVariables();

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<3; j++){
                int  delta = deltas[j];
                int nr = 1;
                int nc = i + delta;
                if(isIn(nc))
                    continue;

                minValue = Math.min(minValue, matrix[0][i] + findMin(j, nr, nc));
            }

        }

        System.out.println(minValue);

    }

    static int findMin(int k, int row, int col){
        if(row == n)
            return 0;
        if(dp[k][row][col] != -1) return dp[k][row][col];
        // 반복문 돌기
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            int delta = deltas[i];
            int nr = row +1;
            int nc = col + delta;
            if(isIn(nc) || i == k)
                continue;
            minValue = Math.min(minValue, findMin(i, nr, nc));
        }

        return dp[k][row][col] = minValue + matrix[row][col];

    }

    static void setVariables() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        dp = new int[3][n][m];

        for(int[][] dd : dp)
            for(int[] d : dd)
                Arrays.fill(d,-1);

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

    }

    static boolean isIn( int col){
        return col < 0 || col >= m;
    }
}