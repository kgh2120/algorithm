import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS로 4방 탐색을 하면서, visited 체크를 한다.
 * 그런데 내가 visited된 애를 만났는데, 그 방향이 내가 지금 이동한 방향이 아님, 즉 아래에서 왔는데 위로, 백해서 만난 경우가 아니라면, 사이클이 될 것임.
 */
public class Main {


    static int n;
    static int m;

    static char[][] matrix;
    static boolean[][] visited;

    static int[][] deltas = {{-1,0},{0,-1}, {1,0}, {0,1}}; // 0 2 / 1 3

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;


                if (bfs(i, j)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }

    static boolean bfs(int row, int col){

        Queue<Node> q = new ArrayDeque<>();
        visited[row][col] = true;

        q.add(new Node(row, col, 100));
        while(!q.isEmpty()){
            Node node = q.poll();

            // 사방탐색

            for (int i = 0; i < 4; i++) {
                int[] delta = deltas[i];
                int nr = node.row + delta[0];
                int nc = node.col + delta[1];

                if (isIn(nr, nc) && matrix[node.row][node.col] == matrix[nr][nc]) {
                    //
                    if (visited[nr][nc]) {
                        if(!node.isBackMoving(i))
                            return true;
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc, i));
                }
            }
        }
        return false;
    }

    static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static class Node{
        int row;
        int col;
        int lastDirection;

        public Node(int row, int col, int lastDirection) {
            this.row = row;
            this.col = col;
            this.lastDirection = lastDirection;
        }

        public boolean isBackMoving(int d){
            // d + direction == 3
            return d != lastDirection && (d + lastDirection) % 2 == 0;
        }
    }


}