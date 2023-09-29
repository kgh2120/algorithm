import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


/**

    @author 규현
    @since 2023-09-29
    @url https://www.acmicpc.net/problem/1400
    @level G2
    @try
    @performance
    @category #
    @note

    BFS문제에서 신호등이 생겼다.
    신호등때문에 해당 방향이 아니라면, 대기를 해야 하는 케이스가 발생함.

    핵심은 신호등을 어떻게 구현할지를 생각해야함.

    신호등은 인덱스, 시작 방향, 동-서 시간, 남-북 시간을 가진다.

    신호등의 개수는 총 20개가 끝이고, 전체 매트릭스의 크기도 20*20이기 때문에,

    신호등이 현재 어느 방향을 가르키고 있는지를 매 시간이 지날 때, 연산을 통해서 진행하고, 상하는  0,1 좌우는 2,3 델타를 쓰는 걸로
    방향 체크를 하면 될 듯 싶다.

    그래서 이동이 가능하면 nr,nc로 이동한 애를 큐에 넣어주고
    이동 못하면 이동은 못하고 걍 넣어주는 걸로

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };

    static Map<Character,LeeMuJin> leeMuJins;
    static int n,m;
    static int sR,sC;

    static char[][] matrix;
    static boolean[][] visited;
    static final char BLOCK = '.';
    public static void main(String[] args) throws Exception {

        while (true) {
            String str = br.readLine();
            st = new StringTokenizer(str);

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0)
                break;

            setVariables();

            int result = bfs();
            if (result == -1) {
                sb.append("impossible\n");
            }else
                sb.append(result).append("\n");
            br.readLine();

        }
        System.out.println(sb);
    }

    private static void setVariables() throws IOException {
        matrix = new char[n][m];
        visited = new boolean[n][m];
        leeMuJins = new HashMap<>();
        int nofDigit = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'A') {
                    sR = i;
                    sC = j;
                } else if (Character.isDigit(c)) {
                    nofDigit++;
                }
                matrix[i][j] = c;
            }
        }

        for (int i = 0; i < nofDigit; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            boolean isLR = st.nextToken().charAt(0) == '-';
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            leeMuJins.put(c, new LeeMuJin(isLR,a,b));
        }
    }


    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sR,sC});
        visited[sR][sC] = true;

        int time = 0;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            while (size-- > 0) {
                int[] poll = q.poll();

                for (int k = 0; k< deltas.length; k++) {
                    int nr = poll[0] + deltas[k][0];
                    int nc = poll[1] + deltas[k][1];

                    if (canMove(nr, nc)&& !visited[nr][nc]) {
                        // 만약 거기가 리무진이라면??

                        if (Character.isDigit(matrix[nr][nc])) {
                            LeeMuJin leeMuJin = leeMuJins.get(matrix[nr][nc]);
                            if (leeMuJin.canAccess(k)) {
                                visited[nr][nc] = true;
                                q.add(new int[]{nr,nc});
                            }else{
                                // 넌 신호 기달려라..
                                q.add(new int[]{poll[0], poll[1]});
                            }
                        }else{
                            // 신호등 아닐 때
                            visited[nr][nc] = true;
                            // B라면..
                            if (matrix[nr][nc] == 'B') {
                                return time;
                            }else{
                                q.add(new int[]{nr, nc});
                            }

                        }
                    }
                }

            }
            // 시간이 흐른다.
            for (LeeMuJin value : leeMuJins.values()) {
                value.spendTime();
            }
        }

        return -1;
    }

    static boolean canMove(int row , int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] != BLOCK;
    }
    static class LeeMuJin{
        boolean isLR;
        int a;
        int b;

        int time; // 0이 되면 isLR이 바뀐다.
        public LeeMuJin(boolean isLR, int a, int b) {
            this.isLR = isLR;
            this.a = a;
            this.b = b;
            setTime();
        }
        private void setTime() {
            time = isLR ? a : b;
        }

        public boolean canAccess(int direction) {
            if(!isLR)
                return direction == 0 || direction == 1;
            else
                return direction == 2 || direction == 3;
        }

        public void spendTime(){
            if (--time == 0) {
                isLR = !isLR;
                setTime();
            }
        }
    }
}