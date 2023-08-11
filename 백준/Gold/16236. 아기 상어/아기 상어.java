import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 김규현
 * @git
 * @youtube
 * @performance
 * @category #
 * @note 아기 상어 뚜루뚜뚜루 아기 상어 뚜루뚜뚜루 아기 상어 뚜루뚜뚜루
 * N * N에 물고기 M마리, 상어 1마리가 있음. 물고기는 한칸에 한마리씩 있다고 함.
 * 아기샤크는 자기보다 큰 공간은 못감.
 * 상하좌우로 한칸씩 이동 가능함.
 * 자기보다 작은 물고기는 먹을 수 있음(같은 애도 불가능)
 * 하지만, 크기가 같은 애는 지나갈 수는 있다.
 * <p>
 * 이동 로직
 * 1. 더이상 먹을 수 없다면 엄마상어를 부른다.
 * 2. 먹을 수 있는 물고기가 1마리가 있다면, 걔를 먹는다.
 * 2-1. 1마리보다 많다면 가까운 물고기를 먹는다.
 * 2-2 가까운 애한테 갈 때는, 최소값으로만 이동한다.
 * 2-3 거리가 가까운 물고기의 수가 여러개라면, 가장 위, 왼쪽 기준으로 가서 먹는다.
 * <p>
 * 상어의 크기는 2부터 시작한다.
 * 크기만큼 물고기를 먹어야 커진다.
 * <p>
 * 제한 2초
 * N <= 20
 * @see
 * @since 2023-08-11
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static int n;
    static int size;
    static int r, c;
    static int seconds;


    static int[][] deltas = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };
    static PriorityQueue<Coor> pq;
    static Queue<Coor> q;
    static int time;
    static int eatCount;
    static boolean flag;

    public static void main(String[] args) throws Exception {


        // 동작 방식
        // 내가 먹을 수 있는 애 탐색.
        // 먹을 수 있는 애들 중에서 거리가 가까운 순으로 정렬
        // 위치를 타겟팅 함.
        // bfs로 이동
        // 사이즈 늘리기.
        // 반복
        // 만약 먹을 수 있느 애가 없다면 종료
        setVariables();

        babySharkDDuduDDuDuru();

        System.out.println(time);
    }

    private static void babySharkDDuduDDuDuru() {
        while (true) {

            // 무빙 가능한지 체크

            if (canEat()) {
                int before = time;
                int temp = eatCount;
//                dfs(new boolean[n][n],time, r,c); // 타겟으로 이동
                bfs();
                if (temp == eatCount) { // 먹을게 없는 경우?
                    time = before;
                    break;
                }
                if (eatCount == size) {
                    eatCount = 0;
                    size++;
                }

                continue;
            }
            break;
        }
    }

    private static boolean canEat() {
        for (int[] mm : matrix) {
            for (int m : mm) {
                if (m > 0 && m < size)
                    return true;
            }
        }
        return false;
    }
        private static void bfs(){
        q.clear();
        q.add(new Coor(r, c));
        boolean[][] visited = new boolean[n][n];
        visited[r][c] = true;

        loop: while (!q.isEmpty()) {
            int qSize = q.size();
            time++;
            pq.clear();
            pq.addAll(q);
            q.clear();
            for (int i = 0; i < qSize; i++) {
                Coor coor = pq.poll();
                int block = matrix[coor.r][coor.c];
                if ( (block != 0 && block < size)) {
                    matrix[coor.r][coor.c] = 0;
                    eatCount++;
                    r = coor.r;
                    c = coor.c;
                    time--;
                    break loop;
                }


                for (int[] delta : deltas) {
                    int nr = coor.r + delta[0];
                    int nc = coor.c + delta[1];
                    if (isIn(nr, nc, Main.size) && !visited[nr][nc]) {
                        q.add(new Coor(nr,nc));
                        visited[nr][nc] = true;



                    }
                }
            }
        }
    }
    private static boolean isIn(int row, int col, int size) {
        return row >= 0 && row < n && col >= 0 && col < n && matrix[row][col] <= size;
    }

    private static void setVariables() throws IOException {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        size = 2;
        q = new ArrayDeque<>();
        pq = new PriorityQueue<>(new Comparator<Coor>() {
            @Override
            public int compare(Coor o1, Coor o2) {
                if(o1.r == o2.r)
                    return Integer.compare(o1.c, o2.c);
                return Integer.compare(o1.r,o2.r);
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 9) {
                    matrix[i][j] = 0;
                    r = i;
                    c = j;
                }
            }
        }
    }

    static class Coor {
        int r;
        int c;

        public Coor(int r, int c) {
            this.r = r;
            this.c = c;
        }


    }

}