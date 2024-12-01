import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] matrix;
    static final int BLOCK = '1';

    static int [][][] dp;
    static int n;
    static int m;

    static int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        init();

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0, 0});
        dp[0][0][0] = 1;
        int turn = 1;
        while (!q.isEmpty()) {
            turn++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();

                for (int[] delta : deltas) {
                    int nr = cur[1] + delta[0];
                    int nc = cur[2] + delta[1];

                    if (isIn(nr, nc)) {
                        int nextBlock = matrix[nr][nc];
                        // 여기가 0이라면, 그리고 내가 더 짧다면 ㄱ
                        if (nextBlock == '0' && dp[cur[0]][nr][nc] > turn) {
                            dp[cur[0]][nr][nc] = turn;
                            q.add(new int[]{cur[0], nr,nc});
                        }
                        // 여기가 1이라면 그리고 내가 0이라면, 그리고내가 더 짧다면
                        if (nextBlock == '1' && cur[0] == 0 && dp[1][nr][nc] > turn) {
                            dp[1][nr][nc] = turn;
                            q.add(new int[]{1, nr,nc});
                        }


                    }
                }
            }

        }

        int result = Math.min(dp[1][n - 1][m - 1], dp[0][n - 1][m - 1]);
        if(result == Integer.MAX_VALUE)
            result = -1;

        System.out.println(result);

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[2][n][m];
        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] =  br.readLine().toCharArray();
            Arrays.fill(dp[0][i], Integer.MAX_VALUE);
            Arrays.fill(dp[1][i], Integer.MAX_VALUE);
        }
    }

    static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
