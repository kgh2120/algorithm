import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 규현
 * - @since 2024-03-03
 * - @limit memory : 256mb time : 2s
 * - @performance
 * - @category #Bruteforce #DFS
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int [][] matrix;
    static int max;
    static int r;
    static int c;
    static boolean[][] visited;

    static int[][][] blocks = {
            {
                    {0,0},
                    {0,1},
                    {1,1}
            },
            {
                    {0,1},
                    {1,1},
                    {1,0}
            },
            {
                    {0,0},
                    {1,0},
                    {1,1}
            },
            {
                    {1,0},
                    {0,0},
                    {0,1}
            }
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new int[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bf(0,0,0);
        System.out.println(max);

    }

    static void bf(int i, int j , int w){

        if (i == r) {
            return;
        }
        max = Math.max(max, w);
        int[] next = next(i, j);

        // blocks를 loop 돌면서 일단 가능ㅇ한지 체크하고 더하고 넘겨
        // 선택을 안하는 방법도 있구나.
        bf(next[0], next[1], w);

        loop: for (int[][] block : blocks) {
            int total = 0;
            int index = 0;
            for (int[] delta : block) {
                int nr = i + delta[0];
                int nc = j + delta[1];

                if (isIn(nr, nc) && !visited[nr][nc]) {
                    total += matrix[nr][nc];
                    if(index == 1)
                        total += matrix[nr][nc];
                }else{
                    continue loop;
                }
                index++;
            }
            for (int[] delta : block) {
                int nr = i + delta[0];
                int nc = j + delta[1];
                visited[nr][nc] = true;
            }
            bf(next[0], next[1], w + total);
            for (int[] delta : block) {
                int nr = i + delta[0];
                int nc = j + delta[1];
                visited[nr][nc] = false;
            }
        }



    }

    static int[] next(int row, int col){
        int nc = col + 1 == c ? 0 : col+1;
        int nr = nc == 0 ? row+1 : row;
        return new int[]{nr,nc};
    }
    static boolean isIn(int row, int col) {
        return row >=0 && row < r && col >= 0 && col < c;
    }

}