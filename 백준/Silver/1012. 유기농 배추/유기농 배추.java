import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * - @author 규현
 * - @since 2024-03-16
 * - @limit memory :  time :
 * - @performance
 * - @category
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] deltas = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };

    static int r;
    static int c;


    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());

             r = Integer.parseInt(st.nextToken());
             c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] matrix = new boolean[r][c];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            int count = 0;

            for (int a = 0; a < r; a++) {
                for (int b = 0; b < c; b++) {
                    if(!matrix[a][b]) continue;
                    count++;
                    bfs(a,b,matrix);
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }

    private static void bfs(int a, int b, boolean[][] matrix) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a,b});
        matrix[a][b] = false;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int[] delta : deltas) {
                int nr = poll[0] + delta[0];
                int nc = poll[1] + delta[1];

                if (isIn(nr, nc) && matrix[nr][nc]) {
                    matrix[nr][nc] = false;
                    q.add(new int[]{nr, nc});
                }
            }
        }


    }

    static boolean isIn(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }


}