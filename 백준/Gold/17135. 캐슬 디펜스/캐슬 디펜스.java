import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @author 김규현
 * @performance
 * @category #
 * @note 궁수가 활을 쏜다.
 * 활을 쏠 때에는 거리D 이내에 있는 적 중 가장 가까운 적을 쏘고, 가장 가까운 적의 수가 같다면 그 중에서 왼쪽에 있는 애를
 * 쏜다.
 * 하나의 적은 동시에 화살을 맞을 수 있음.
 * <p>
 * 궁수의 위치를 잘 알 수 없기 때문에 궁수의 위치를 조합으로 구하고, 그 다음에 궁수의 위치에서 BFS를 진행하면서
 * 화살을 쏴야 하지 않을까 싶음.
 * <p>
 * N과M은 15.
 * 궁수는 3개까지 배치 가능 하니, 조합은 15C3 15 * 14 * 13 / 3
 * @see https://www.acmicpc.net/problem/17135
 * @since 2023-08-18
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String[][] originalMap;
    static String[][] playingMap;

    static int[] selected;
    static int max;

    static int n, m, d;
    static int[][] deltas = {
            {0,-1}, {-1,0}, {0,1}
    };
    static Set<Coor> deleted ;

    public static void main(String[] args) throws IOException {
        setVariables();
        combination(0,0);

        System.out.println(max);

    }

    private static void playGame(){
        deleted = new HashSet<>();
        // 궁수 설정
        int r = n;
        while (r-- > 0) {
            for (int i : selected) {
                shot(r,i);
            }

            for (Coor coor : deleted) {
                playingMap[coor.r][coor.c] = "0";
            }

        }

        max = Math.max(max, deleted.size());
    }
    private static void shot(int r, int c){
        if (playingMap[r][c].equals("1")) {
            deleted.add(new Coor(r, c));
            return;
        }
        Queue<Coor> q = new ArrayDeque<>();
        q.add(new Coor(r,c));
        boolean[][] visited = new boolean[n][m];
        visited[r][c] = true;
        int dist = 1;
        loop : while (!q.isEmpty() && dist < d) {
            dist++;
            int size = q.size();
            while (size-- > 0) {
                Coor coor = q.poll();
                for (int[] delta : deltas) {
                    int nr = coor.r + delta[0];
                    int nc = coor.c + delta[1];
                    if (isIn(nr, nc) && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Coor(nr,nc));
                        if (playingMap[nr][nc].equals("1")) {
                            deleted.add(new Coor(nr,nc));
                            break loop;
                        }
                    }
                }
            }
        }

    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >=0 && col < m;
    }

    private static void combination(int start, int cnt) {
        if (cnt == selected.length) {
            // 게임 하기
            arrayCopy();
            playGame();
            return;
        }

        for (int i = start; i < m; i++) {
            selected[cnt] = i;
            combination(i+1,cnt+1);
        }
    }



    private static void arrayCopy(){
        for (int i = 0; i < n; i++) {
            System.arraycopy(originalMap[i],0,playingMap[i],0,m);
        }
    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        originalMap = new String[n][m];
        playingMap = new String[n][m];
        selected = new int[3];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = st.nextToken();
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

        @Override
        public String toString() {
            return "Coor{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coor coor = (Coor) o;
            return r == coor.r && c == coor.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}