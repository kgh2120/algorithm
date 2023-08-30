import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, k;
    static int[][] normalDeltas = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int[][] horseDeltas = {
            {-2, -1}, {-2, 1},
            {-1, 2}, {1, 2},
            {2, -1}, {2, 1},
            {-1, -2}, {1, -2}
    };
    static int[][][] memo;
    static int[][] matrix;
    static final int INF = 1000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        memo = new int[k + 1][n][m];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], INF);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        matrix[n - 1][m - 1] = 1;
        System.out.println(findRoute(n - 1, m - 1, k));
    }

    private static int findRoute(int r, int c, int k) {


        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(r,c,k,0));
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if(pos.r == 0 &&  pos.c == 0)
                return pos.index;

            if (pos.k > 0) {
                for (int [] del : horseDeltas) {
                    int nr = pos.r + del[0];
                    int nc = pos.c + del[1];
                    if (canMove(nr, nc) && memo[pos.k-1][nr][nc] == INF) {
                        memo[pos.k-1][nr][nc] = pos.index+1;
                        q.add(new Pos(nr,nc,pos.k-1,pos.index+1));
                    }
                }
            }
            for (int [] del : normalDeltas) {
                int nr = pos.r + del[0];
                int nc = pos.c + del[1];
                if (canMove(nr, nc) && memo[pos.k][nr][nc] == INF) {
                    memo[pos.k][nr][nc] = pos.index+1;
                    q.add(new Pos(nr,nc,pos.k,pos.index+1));
                }
            }
        }
        return -1;

    }

    private static boolean canMove(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 0;
    }

    static class Pos{
        int r;
        int c;
        int index;

        int k;
        public Pos(int r, int c, int k, int index) {
            this.r = r;
            this.c = c;
            this.index = index;
            this.k = k;
        }
    }

}