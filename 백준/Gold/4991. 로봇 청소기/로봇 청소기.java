import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;



/*
    로봇이 상하좌우로 이동하면서 더러운 칸을 깨끗하게 만들어준다.
    로봇은 같은 곳을 다시 갈 수 있음.
    모든 더러운 곳을 처리하는 최소 시간을 출력하고, 그렇지 못하는 경우엔 -1을 출력하라고 함.
    같은 곳을 다시 갈 수 있다고 해도, 무의미한 상태로 다시 가는건 의미가 없다.

    visited를 체크할 때, 어떤 더러운 칸을 내가 처리했는지에 대해서 알고있으면 될 듯 싶다.

    그럼 visited 배열을 bitmasking을 해가지고 만들면 될 듯 싶음.

    그리고 visited가 다 찼을 경우, bit+1이 1 << 더러운 칸과 같을 경우에 time을 출력하면 될 듯 싶다.


    필요한 것, 먼지 클래스,
    상하좌우 델타 배열,
    3차원 visited 배열,
    청소기 위치.
    BFS를 돌 큐

 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static char[][] matrix;
    static int sr, sc;
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

    static final char BLOCK = 'x', DIRT = '*', NORMAL = '.', ROBOT = 'o';

    static List<Dirt> dirtList;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            matrix = new char[n][m];
            dirtList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    char com = line.charAt(j);
                    matrix[i][j] = com;
                    if (com == ROBOT) {
                        sr = i;
                        sc = j;
                        matrix[i][j] = NORMAL;
                    } else if (com == DIRT) {
                        dirtList.add(new Dirt(i, j));
                    }
                }
            }
            if (dirtList.isEmpty()) {
                sb.append("0\n");
            } else {
                visited = new boolean[1 << dirtList.size()][n][m];
                sb.append(bfs()).append("\n");
            }
        }
        System.out.print(sb);


    }

    private static int bfs(){
        Queue<Pos> q = new ArrayDeque<>();
        visited[0][sr][sc] = true;
        q.add(new Pos(sr,sc,0));
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                Pos poll = q.poll();
                int cnt = poll.count;
                for (int[] delta : deltas) {
                    int nr = poll.row + delta[0];
                    int nc = poll.col + delta[1];
                    if (isIn(nr, nc) && !visited[cnt][nr][nc]) {
                        if (matrix[nr][nc] == NORMAL) {
                            visited[cnt][nr][nc] = true;
                            q.add(new Pos(nr,nc,cnt));
                        } else if (matrix[nr][nc] == DIRT) {
//                            visited[cnt][nr][nc] = true;
                            int index = dirtList.indexOf(new Dirt(nr, nc));
                            if (!visited[cnt | (1 << index)][nr][nc]) {
                                visited[cnt | (1 << index)][nr][nc] = true;
                                q.add(new Pos(nr,nc, cnt | (1 << index)));
                            }
                            if ((cnt | (1 << index))+ 1 == 1 << dirtList.size()) {
                                return time;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] != BLOCK;
    }

    static class Dirt{
        int row;
        int col;

        public Dirt(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dirt dirt = (Dirt) o;
            return row == dirt.row && col == dirt.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Pos{
        int row;
        int col;
        int count;

        public Pos(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "row=" + row +
                    ", col=" + col +
                    ", count=" + count +
                    '}';
        }
    }

}