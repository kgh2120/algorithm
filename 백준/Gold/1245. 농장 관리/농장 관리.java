import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;



/**

@author 규현
@since 2023-09-10
@url
@level
@try
@performance
@category #
@note
 산 봉우리의 개수를 세는 문제이다.
 민식이의 땅은 N * M의 형태로 주어진다.
 산 봉우리란 같은 높이를 가진 집단인데, 인접한 애들은 자기보다 작아야 한다.


 인접하다 : x좌표 혹은 y좌표의 차이가 모두 1보다 작은 경우이다.
          즉 자기 위치로부터 8방향 내에 있는 애들은 모두 인접한 것.

 BFS를 통해서 접근하려고 한다.
 0,0부터 n-1,m-1 까지 bfs를 반복하면서 산봉우리를 찾는다. 시작 지점을 기준으로, 8방 탐색을 진행하면서
 탐색을 한다. 탐색을 하는 기준은 자기와 크기가 같은 애들을 넣는다. 탐색하는 과정에서 8방향 내에 자신보다 큰
 격자를 찾으면, 체크를 하여, 해당 지점이 산봉우리가 아님을 표기한다.

 높이를 비교할 때엔 bfs의 방문배열과 무관하게 진행한다.

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int [][] matrix;
    static boolean[][] visited;
    static int nOfTop;
    static Position[] deltas = {
            new Position(-1,-1),
            new Position(-1,0),
            new Position(-1,1),
            new Position(0,-1),
            new Position(0,1),
            new Position(1,-1),
            new Position(1,0),
            new Position(1,1),
    };

    static int n,m;
    static Queue<Position> q;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if(bfs(i,j))
                    nOfTop++;
            }
        }

        System.out.println(nOfTop);


    }

    static boolean bfs(int row, int col){
        q.add(new Position(row, col));
        int height = matrix[row][col];
        visited[row][col] = true;
        boolean isTop = true;

        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (Position del : deltas) {
                int nr = pos.row + del.row;
                int nc = pos.col + del.col;
                if (isIn(nr, nc)) {
                    // 크기 비교
                    if (matrix[nr][nc] > matrix[pos.row][pos.col]) {
                        isTop = false;
                    }else{
                        if (!visited[nr][nc] && matrix[nr][nc] == height) {
                            visited[nr][nc] = true;
                            q.add(new Position(nr,nc));
                        }
                    }
                }
            }
        }
        return isTop;
    }

    static boolean isIn(int row, int col){
        return row >= 0 && row <n && col >= 0 && col < m;
    }


    static class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}