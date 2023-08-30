import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static int[][] acc;

    static int n, m;
    static final int INF = -1;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n+1][m+1];
        acc = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(acc[i], INF);
        }
        for (int i = 0; i <= n; i++) {
            acc[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            acc[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        acc[1][1] = matrix[1][1];




        System.out.println(dp(n,m));

        

    }

    private static int dp(int r, int c) {


        if(acc[r][c] != INF) return acc[r][c];
        if(isIn(r-1,c))
            acc[r][c] = Math.max(acc[r][c], dp(r-1,c) + matrix[r][c]);
        if(isIn(r,c-1))
            acc[r][c] = Math.max(acc[r][c], dp(r,c-1) + matrix[r][c]);

        return acc[r][c];

    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row <= n && col >= 0 && col <= m;
    }
}