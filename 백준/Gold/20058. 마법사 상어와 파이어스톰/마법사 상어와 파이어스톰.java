import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 20058 마법사 상어와 파이어토네이도
 *
 * 마법사 상어놈이 지치지도 않고 마법을 또 연습한다. 리스펙트
 * 상어의 마법 과정을 보면 다음과 같이 동작한다.
 * 1. matrix의 영역을 나눈다.
 * 2. 오른쪽으로 돌린다.
 * 3. 인접한 애들이 값이 있다면(0이 아니라면) 살려주고, 그렇지 않으면 -1을 해준다.
 * 이 과정을 반복하고나서 마법 시전이 끝나면 전체 matrix에 남은 값 전부를 계산하고,
 * BFS를 통해 이어져있는 가장 큰 덩어리의 길이를 계산을 해야 함.
 */

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static boolean[][] isMinus;
    static int[][] deltas = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    static  boolean[][] visited;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int m = (int) Math.pow(2,l);
        matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int targetLevel = Integer.parseInt(st.nextToken());
            divide(0,0,targetLevel,l);
            melt();
        }

        int totalIceCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                totalIceCount += matrix[i][j];
            }
        }

        int maxChain = 0;
        visited = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(visited[i][j] || matrix[i][j] == 0) continue;
                maxChain = Math.max(maxChain,bfs(i,j));
            }
        }

        sb.append(totalIceCount).append("\n").append(maxChain);
        System.out.println(sb);

    }

    static int bfs(int row, int col) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] ice = q.poll();
            cnt++;

            for (int[] delta : deltas) {
                int nr = ice[0] + delta[0];
                int nc = ice[1] + delta[1];

                if (isIn(nr, nc) && !visited[nr][nc] && matrix[nr][nc] != 0) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return cnt;

    }

    // 1. 범위 쪼개는 메서드
    static void divide(int x, int y, int targetLevel, int currentLevel){


        if (currentLevel == targetLevel) {
             rotateRight(x,y,(int) Math.pow(2, currentLevel));
            return;
        }
        int m = (int) Math.pow(2, currentLevel-1);


        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                divide(x + i * m, y + j * m, targetLevel, currentLevel-1);
            }
        }
    }
    // 2. rotate right

    static void rotateRight(int x, int y, int l){


        int[][] temp = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                temp[i][j] = matrix[x + l - j -1][i+y];
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                matrix[x+i][y+j] = temp[i][j];
            }
        }

    }


    // 3. 4방 탐색 후 값 변경하는 메서드
    static void melt(){

        isMinus = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int iceCount = 0;
                for (int[] delta : deltas) {
                    int nr = i + delta[0];
                    int nc = j + delta[1];

                    if (isIn(nr, nc) && matrix[nr][nc] > 0) {
                        iceCount++;
                    }
                }

                if (iceCount < 3) {
                    isMinus[i][j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(!isMinus[i][j]) continue;
                matrix[i][j] = Math.max(0, --matrix[i][j]);
            }
        }




    }

    static boolean isIn(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }
}