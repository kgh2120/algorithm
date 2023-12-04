import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int[][] matrix;
    static int[][] temp;
    static boolean[][] visited;

    static Queue<Coord> queue;

    static Coord[] deltas = {
            new Coord(-1, 0),
            new Coord(1, 0),
            new Coord(0, -1),
            new Coord(0, 1)
    };

    static int n, m;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            // forloop
            temp = new int[n][m];
            visited = new boolean[n][m];
            boolean isBfs = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] || matrix[i][j] == 0) {
                        continue;
                    }

                    if (isBfs) { // 2번 이상 bfs가 돈 경우. -> 붕괴됐음.
                        System.out.println(time);
                        return;
                    }
                    bfs(i, j);
                    isBfs = true;
                }
            }

            if (!isBfs) { // bfs가 안도는 경우 -> 모두 녹은 경우.
                System.out.println(0);
                return;
            }

            matrix = temp;

            time++;
        }


    }


    private static void bfs(int row, int col) {

        queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.add(new Coord(row, col));

        while (!queue.isEmpty()) {
            Coord coord = queue.poll();

            int zCount = 0;
            for (Coord delta : deltas) {
                int nr = coord.row + delta.row;
                int nc = coord.col + delta.col;

                // 얘가 0이라면 체크. 아니라면 queue에 넣는다.
                if (matrix[nr][nc] == 0) {
                    zCount++;
                } else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Coord(nr, nc));
                }
            }
            temp[coord.row][coord.col] =
                    Math.max(matrix[coord.row][coord.col] - zCount, 0);
        }
    }


    static class Coord {

        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}