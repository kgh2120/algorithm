import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int limit;

    static int[][] matrix;

    static int gR, gC;

    static int[][] deltas = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 2) {
                    gR = i;
                    gC = j;
                }
            }
        }

        int apple = bfs(n - 1, m - 1);
        int lgGram = bfs(gR, gC);
        if(lgGram != -1)
        lgGram = lgGram + (n - 1 - gR) + (m - 1 - gC) > limit ? -1
                : lgGram + (n - 1 - gR) + (m - 1 - gC);

        if (apple == -1 && lgGram == -1) {
            System.out.println("Fail");
        } else if (lgGram == -1) {
            System.out.println(apple);
        } else if (apple == -1) {
            System.out.println(lgGram);
        } else {
            System.out.println(Math.min(apple, lgGram));
        }
    }


    private static int bfs(int endRow, int endCol) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int time = 0;
        while (!q.isEmpty() && time <= limit) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                int[] poll = q.poll();
                for (int[] delta : deltas) {

                    int nr = poll[0] + delta[0];
                    int nc = poll[1] + delta[1];

                    if (canMove(nr, nc) && !visited[nr][nc]) {
                        if (nr == endRow && nc == endCol) {
                            return time;
                        }
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});

                    }
                }
            }
        }
        return -1;

    }

    private static boolean canMove(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] != 1;
    }
}