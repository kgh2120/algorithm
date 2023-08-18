import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[][][]map;

    static Position[] deltas = {
            new Position(-1,0,0),
            new Position(1,0,0),
            new Position(0,1,0),
            new Position(0,-1,0),
            new Position(0,0,-1),
            new Position(0,0,1),
    };
    static int h,r,c;

    static int time;
    static int sh,sr,sc,er,ec,eh;

    static final String FAILED = "Trapped!\n";
    static final String SUCCESS_PREFIX = "Escaped in ";
    static final String SUCCESS_POSTFIX =" minute(s).\n";
    static final char BLOCK = '#';

    public static void main(String[] args) throws Exception {

        while (setVariables()) {
            bfs();
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(sh,sr,sc));
        map[sh][sr][sc] = BLOCK;

        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            while (size-- > 0) {
                Position poll = q.poll();

                for (Position delta : deltas) {
                    int nh = poll.h + delta.h;
                    int nr = poll.r + delta.r;
                    int nc = poll.c + delta.c;
                    if (isIn(nh, nr, nc) && map[nh][nr][nc] != '#') {
                        q.add(new Position(nh,nr,nc));
                        if (map[nh][nr][nc] == 'E') {
                            sb.append(SUCCESS_PREFIX)
                                    .append(time)
                                    .append(SUCCESS_POSTFIX);
                            return;
                        }

                        map[nh][nr][nc] = '#';
                    }
                }
            }
        }

        sb.append(FAILED);
    }

    private static boolean isIn(int height, int row, int col) {
        return height >= 0 && height < h && row >= 0 && row < r && col >= 0 && col < c;
    }

    private static boolean setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        if(r == 0 && h == 0 && c == 0)
            return false;
        time = 0;
        map = new char[h][r][c];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                String line = br.readLine();
                for (int k = 0; k < c; k++) {
                    char com = line.charAt(k);
                    map[i][j][k] = com;
                    if (com == 'S') {
                        sh = i;
                        sr = j;
                        sc = k;
                    }
                    if (com == 'E') {
                        eh = i;
                        er = j;
                        ec = k;
                    }
                }
            }
            br.readLine();
        }

        return true;
    }
    static class Position{
        int h;
        int r;
        int c;

        public Position(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
}