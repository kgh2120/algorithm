import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/**

    @author 규현
    @since 2023-09-19
    @url https://www.acmicpc.net/problem/17836
    @level G5
    @try 7
    @performance 13096KB, 128MS
    @category #그래프이론 #그래프탐색 #너비우선탐색
    @note

 공주님이 있는 위치로 용사가 가야한다.
 용사의 위치는 (0,0)이고 공주님의 위치는 (N-1,M-1)에 있다.

 용사가 이동할 때, 벽(1)이 있으면 거긴 못간다.
 하지만 짱쎈 검(2)을 찾으면 벽을 무시하고 갈 수 있다.

 용사가 주어진 시간이 있는데, 이 시간 안에 공주님을 구할 수 있는지, 그리고 구할 수 있다면 최소 몇 시간이 걸리는지를
 출력하면 된다. 만약 구하지 못하면 -1을 출력해야 한다.

 용사는 공주를 구하러 가는 방법이 2가지가 있다.

 첫 번째는 그냥 공주의 위치(n-1,m-1)로 가는 것, 두 번째는 검의 위치로 가고, 검의 위치에서 (n-1,m-1)로 이동하는 것이다.

 두 방법 모두 BFS를 이용해서 접근을 하고, 검의 위치에서는 해당 좌표에서 n-1, m-1과의 차이만큼 시간이 추가로 걸리는 것으로
 시간 계산이 가능하다.

 두 방법 모두 BFS를 진행하면서 시간 소모가 limit을 넘어가면 -1을 리턴하도록 하였다, 또 원하는 위치 [(n-1,m-1), (검위치)]에 도달하지 못하면
 -1을 리턴한다.

 **검의 위치를 찾아서 최종 거리를 계산한 경우에 limit을 넘긴다면 -1로 바꿔주도록 해야 했다.**

 두 방법의 결과로 나온 값 중에서 -1이 아닌 값 중에서 최소값을 리턴하면 정답이 된다.


 많이 틀린 이유 : 검의 위치를 찾고 나서 limit을 계산하는 것을 까먹고 많이 틀렸다.
 누군가가 겁나 쉽다고 바이럴해서, 대충 읽고 풀어서 내용을 제대로 숙지하지 않았다.
 문제를 잘 읽자.





*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int limit;

    static int[][] matrix;

    static int gR, gC;

    static int[][] deltas = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();

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

        boolean[][] visited = new boolean[n][m];
        q.clear();
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