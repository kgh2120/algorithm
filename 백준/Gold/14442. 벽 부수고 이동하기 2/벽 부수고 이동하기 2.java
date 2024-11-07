import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] deltas = {
            {-1,0},
            {0,-1},
            {1,0},
            {0,1}
    };

    static char[][] matrix;
    static boolean[][][] visited;


    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[k+1][n][m];

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = word.charAt(j);
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, k));
        int turn = 0;
        while (!q.isEmpty()) {
            turn++;
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();

                for (int[] d : deltas) {
                    int nr = cur.row + d[0];
                    int nc = cur.col + d[1];

                    if (isIn(nr, nc)) {

                        if (matrix[nr][nc] == '1' && cur.k > 0 && !visited[cur.k-1][nr][nc]) {
                            if(nr == n-1 && nc == m-1) {
                                System.out.println(turn+1);
                                return;
                            }
                            visited[cur.k-1][nr][nc] = true;
                            q.add(new Node(nr, nc, cur.k - 1));
                        }else if(matrix[nr][nc] == '0' && !visited[cur.k][nr][nc]) {
                            if(nr == n-1 && nc == m-1) {
                                System.out.println(turn+1);
                                return;
                            }
                            visited[cur.k][nr][nc] = true;
                            q.add(new Node(nr, nc, cur.k));
                        }
                    }
                }
            }

        }
        System.out.println(-1);

    }

    static boolean isIn(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static class Node{
        int row;
        int col;
        int k;

        public Node(int row, int col, int k) {
            this.row = row;
            this.col = col;
            this.k = k;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", k=" + k +
                    '}';
        }
    }


}
