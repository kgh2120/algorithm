import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author 규현
 * @url https://www.acmicpc.net/problem/7569
 * @level G5
 * @try
 * @performance
 * @category #
 * @note 토마토 상자에서 토마토가 익는 것이 전염되는 상황에서, 전부 익을때까지 며칠이 걸리는지 계산하는 문제이다. 익은 토마토는 그 영향력을 인접한 위,아래, 전후좌후
 * 6방향으로 퍼뜨릴 수 있다.
 * <p>
 * 토마토가 인접한 6방향으로 영향력을 퍼뜨리는 것을 보면 BFS와 흡사하다는 것을 알 수 있다.
 * <p>
 * 그래서 토마토의 영향력 행사에 대해서 BFS를 활용해서 로직을 작성하려고 한다.
 * <p>
 * 주어진 조건은 가로, 사로, 높이가 전부 100이하의 값을 보인다. 그렇다면 전체를 탐색한다고 했을 때, 10^6으로 1ms의 값이 나오기 때문에, BFS를 하더라도 충분히
 * 안정적인 성능을 보장할 수 있다.
 * <p>
 * 모든 토마토가 익는 경우에는 며칠이 소모되었는지를 체크하고, 그렇지 못한 경우엔 -1을 출력해야 한다. 그리고 저장될 때부터 모든 토마토가 익었다면 0을 출력한다.
 * <p>
 * 그렇다면, 토마토가 익을 때 걸리는 일수와, 익지 않은 토마토의 개수를 체크해야 하고, bfs가 끝나더라도 체크값이 0이 아니라면 -1을, 시작부터 0이라면 0을 출력하고
 * 그렇지 않다면 가장 마지막에 가지고있는 일수를 출력한다.
 * @since 2023-08-09
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[][][] matrix;
    static int nOfNormalTomato;
    static Queue<Tomato> q;


    static int r, c, h;
    static int[][] deltas = {
            {1, 0, 0}, {-1, 0, 0},
            {0, 1, 0}, {0, -1, 0},
            {0, 0, 1}, {0, 0, -1}
    };

    static int lastDay;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();

        matrix = new int[r][c][h];
        for (int a = 0; a < h; a++) {
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < c; i++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    if(tomato == 0)
                        nOfNormalTomato++;
                    if (tomato == 1) {
                        q.add(new Tomato(j,i,a,0));
                    }
                    matrix[j][i][a] = tomato;
                }
            }
        }

        if (nOfNormalTomato == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        if (nOfNormalTomato != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(lastDay);


    }
    private static void bfs(){

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            lastDay = Math.max(lastDay,tomato.day);

            for (int[] del : deltas) {
                int nr = tomato.row + del[0];
                int nc = tomato.col + del[1];
                int nh = tomato.height + del[2];

                if (isIn(nr, nc, nh) && matrix[nr][nc][nh] == 0) {
                    q.add(new Tomato(nr,nc,nh,tomato.day+1));
                    matrix[nr][nc][nh] = tomato.day+1;
                    nOfNormalTomato--;
                }
            }
        }
    }

    private static boolean isIn(int row, int col, int height){
        return row >= 0 && row < r && col >= 0 && col < c && height >= 0 && height < h;
    }

    static class Tomato {

        int row;
        int col;
        int height;
        int day;

        public Tomato(int row, int col, int height,int day) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.day = day;
        }
    }

}