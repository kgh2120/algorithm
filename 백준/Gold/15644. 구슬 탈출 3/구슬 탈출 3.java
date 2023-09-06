import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @author 규현
 * @url
 * @level
 * @try
 * @performance
 * @category #
 * @note 각각의 방향으로 기울여서 빨간공을 구멍에 넣는 게임을 만든다. 이때, 파란색이 구멍에 들어가면 안되고, 빨간 공이 들어가도, 파란 공이 들어가면 안된다.
 * <p>
 * 상,하,좌,우 이동에 대해서는 델타를 만들고, 이동할 수 있는 끝까지 이동하도록 설정해주어야겠음.
 * <p>
 * 그 다음에, 각 4방향에 대해서는, 더 그 방향에 가까운 공을 먼저 이동시켜야 함. ex) R, B 순서로 있는데, 오른쪽으로 가고 싶다면, B를 먼저, 그 다음에 R을
 * 이동
 * <p>
 * 완전탐색과 백트래킹이 들어갈 거 같음.
 * <p>
 * 최소한의 횟수로 빼낼 수 있는지를 체크하고, 10번을 넘어도 못찾으면 -1을 출력해야 한다.
 * <p>
 * 한번 상,하,좌,우로 이동했을 때, 그 다음에는 같은 방향으로는 이동할 수 없음. (왜냐면 어차피 같으니까)
 * <p>
 * 그냥 direction 변수를 넣어서 체크할 까 하는데, 어차피 변하지 않는다면 반복문도 얼마 안돌테니까 그냥 전 위치랑 후 위치가 같다면 더 들어가지 않는 것으로 하는 것이
 * 좋을 듯 싶음.
 * <p>
 * 그리고 한번이라도 성공을 했다면, 그 횟수를 넘어가는 depth에서는 out을 해주면 될 듯 싶다.
 * <p>
 * 판의 크기 N,M은 3<= a <= 10이고, 각각의 마지막 칸은 벽으로 되어있ㄷ으니까, 1~8 사이즈로 보는 것이 맞을 거 같다.
 * <p>
 * 그렇다면 시간복잡도는... 4^10 (1024 ^ 2) * 8 ?? 시간제한은 1초(10억회) 충분히 가능해보인다.
 * @since 2023-09-04
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int min;
    static char[][] matrix;

    static Pos goal, red, blue;

    static int[][] deltas = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int n, m;
    static final int BEFORE = -1;
    static int[] log;
    static char[] converter = {'U','D','L','R'};

    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        setVariables();
        dfs(0, red.r, red.c, blue.r, blue.c, log);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        if(sb != null)
            System.out.println(sb);
    }

    private static void dfs(int depth, int redRow, int redCol, int blueRow, int blueCol, int[] log) {
        if (depth == 10) {
            return;
        }
        if (depth > min) {
            return;
        }

        // 4방향으로 이동해야 함.
        // 일단 북쪽
        // 둘 중 어디가 더 r이 작은지
        MoveResult move = move(0, redRow, redCol, blueRow, blueCol, redRow < blueRow);
        log[depth] = 0;
        if (!move.blueFinish) {
            if (!move.redFinish) {
                Pos nextRed = move.nextRed;
                Pos nextBlue = move.nextBlue;
                if (!(redRow == nextRed.r && redCol == nextRed.c && blueRow == nextBlue.r
                        && blueCol == nextBlue.c)) {

                    dfs(depth + 1, nextRed.r, nextRed.c, nextBlue.r, nextBlue.c, log);
                }
            } else {
                if (min > depth + 1) {
                    min = depth+1;
                    saveLog(depth);
                }
                log[depth] = BEFORE;
                return;
            }
        }
        log[depth] = BEFORE;


        // 하
        move = move(1, redRow, redCol, blueRow, blueCol, redRow > blueRow);
        log[depth] = 1;
        if (!move.blueFinish) {
            if (!move.redFinish) {
                Pos nextRed = move.nextRed;
                Pos nextBlue = move.nextBlue;
                if (!(redRow == nextRed.r && redCol == nextRed.c && blueRow == nextBlue.r
                        && blueCol == nextBlue.c)) {

                    dfs(depth + 1, nextRed.r, nextRed.c, nextBlue.r, nextBlue.c, log);


                }
            } else {
                if (min > depth + 1) {
                    min = depth+1;
                    saveLog(depth);
                }
                log[depth] = BEFORE;
                return;
            }
        }
        log[depth] = BEFORE;

        // 좌
        move = move(2, redRow, redCol, blueRow, blueCol, redCol < blueCol);
        log[depth] = 2;
        if (!move.blueFinish) {
            if (!move.redFinish) {
                Pos nextRed = move.nextRed;
                Pos nextBlue = move.nextBlue;
                if (!(redRow == nextRed.r && redCol == nextRed.c && blueRow == nextBlue.r
                        && blueCol == nextBlue.c)) {

                    dfs(depth + 1, nextRed.r, nextRed.c, nextBlue.r, nextBlue.c,log);


                }
            } else {
                if (min > depth + 1) {
                    min = depth+1;
                    saveLog(depth);
                }
                log[depth] = BEFORE;
                return;
            }
        }
        log[depth] = BEFORE;
        // 우
        move = move(3, redRow, redCol, blueRow, blueCol, redCol > blueCol);
        log[depth] = 3;
        if (!move.blueFinish) {
            if (!move.redFinish) {
                Pos nextRed = move.nextRed;
                Pos nextBlue = move.nextBlue;
                if (!(redRow == nextRed.r && redCol == nextRed.c && blueRow == nextBlue.r
                        && blueCol == nextBlue.c)) {

                    dfs(depth + 1, nextRed.r, nextRed.c, nextBlue.r, nextBlue.c,log);

                }
            } else {
                if (min > depth + 1) {
                    min = depth+1;
                    saveLog(depth);
                }
                log[depth] = BEFORE;
                return;
            }
        }
        log[depth] = BEFORE;
    }

    private static void saveLog(int depth){
        sb = new StringBuilder();
//        System.out.println("d : " + depth);
        for (int i = 0; i <= depth; i++) {
            if(log[i] == BEFORE) break;
            sb.append(converter[log[i]]);
//            System.out.print(log[i] + " ");
        }
//        System.out.println();
//        System.out.println(sb);
    }

    private static MoveResult move(int direction, int rr, int rc, int br, int bc,
                                   boolean isRedFirst) {

        boolean redFinish = false;
        boolean blueFinish = false;
        int[] delta = deltas[direction];

        int nrr = rr + delta[0];
        int nrc = rc + delta[1];
        // blue 이동
        int nbr = br + delta[0];
        int nbc = bc + delta[1];
        if (isRedFirst) {
            // blue랑 닿으면 안되고, 벽이면 안되고, O면 끝남.
            while (isIn(nrr, nrc) && (nrr != br || nrc != bc) && matrix[nrr][nrc] != '#') {
                if (nrr == goal.r && nrc == goal.c) {
                    redFinish = true;
                    nrr = -1;
                    nrc = -1;
                    break;
                }
                nrr += delta[0];
                nrc += delta[1];
            }
            // 더이상 못갈 떄 끝나니까 각각 -1씩 해준다.
            nrr -= delta[0];
            nrc -= delta[1];


            while (isIn(nbr, nbc) && (nbr != nrr || nbc != nrc) && matrix[nbr][nbc] != '#') {
                if (nbr == goal.r && nbc == goal.c) {
                    blueFinish = true;
                    nbr = -1;
                    nbc = -1;
                    break;
                }
                nbr += delta[0];
                nbc += delta[1];
            }
            // 더이상 못갈 떄 끝나니까 각각 -1씩 해준다.
            nbr -= delta[0];
            nbc -= delta[1];


        } else {

            while (isIn(nbr, nbc) && (nbr != rr || nbc != rc) && matrix[nbr][nbc] != '#') {
                if (nbr == goal.r && nbc == goal.c) {
                    blueFinish = true;
                    nbr = -1;
                    nbc = -1;
                    break;
                }
                nbr += delta[0];
                nbc += delta[1];
            }
            // 더이상 못갈 떄 끝나니까 각각 -1씩 해준다.
            nbr -= delta[0];
            nbc -= delta[1];

            while (isIn(nrr, nrc) && (nrr != nbr || nrc != nbc) && matrix[nrr][nrc] != '#') {
                if (nrr == goal.r && nrc == goal.c) {
                    redFinish = true;
                    nrr = -1;
                    nrc = -1;
                    break;
                }
                nrr += delta[0];
                nrc += delta[1];
            }
            // 더이상 못갈 떄 끝나니까 각각 -1씩 해준다.
            nrr -= delta[0];
            nrc -= delta[1];

        }
        return new MoveResult(new Pos(nrr, nrc), new Pos(nbr, nbc), blueFinish, redFinish);
    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        matrix = new char[n][m];
        log = new int[10];
        Arrays.fill(log,BEFORE);
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char comp = line.charAt(j);
                if (comp == 'B') {
                    blue = new Pos(i, j);
                } else if (comp == 'R') {
                    red = new Pos(i, j);
                } else if (comp == 'O') {
                    goal = new Pos(i, j);
                }

                if (comp == '#') {
                    matrix[i][j] = comp;
                } else {
                    matrix[i][j] = '.';
                }
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 1 && row < n - 1 && col >= 1 && col < m - 1;
    }

    static class Pos {

        int r;
        int c;
        boolean isOut;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class MoveResult {

        Pos nextRed;
        Pos nextBlue;
        boolean blueFinish;
        boolean redFinish;

        public MoveResult(Pos nextRed, Pos nextBlue, boolean blueFinish, boolean redFinish) {
            this.nextRed = nextRed;
            this.nextBlue = nextBlue;
            this.blueFinish = blueFinish;
            this.redFinish = redFinish;
        }
    }

}