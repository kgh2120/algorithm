import com.sun.corba.se.spi.ior.IdentifiableFactory;

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

    static int n,m;
    static boolean[] visited;
    static int max;

    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };
    static char[][] matrix;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new char[n][m];
        visited = new boolean[128];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        visited[matrix[0][0]] = true;
        dfs(0,0,1);
        System.out.println(max);

    }

    private static void dfs(int r, int c, int d) {
        max = Math.max(max,d);

        for (int[] delta : deltas) {
            int nr = r + delta[0];
            int nc = c + delta[1];

            if (isIn(nr, nc) && !visited[matrix[nr][nc]]) {
                visited[matrix[nr][nc]] = true;
                dfs(nr,nc, d+1);
                visited[matrix[nr][nc]] = false;
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

}