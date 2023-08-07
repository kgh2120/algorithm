package beak.Aug2023.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/**

@author 규현
@since 2023-08-07
@url https://www.acmicpc.net/problem/2178
@level s1
@try 1
@performance 12028, 96ms
@category #너비 우선 탐색
@note 

*/
public class p2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static int n,m;

    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };

    static Queue<Position> queue;

    static int result;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String column = br.readLine();
            for(int j = 0; j<m; j++ )
                matrix[i][j] = column.charAt(j) - '0';
        }


        bfs();
        System.out.println(result);


    }

    private static void bfs(){
        queue = new ArrayDeque<>();
        queue.add(new Position(0,0));
        matrix[0][0] = -1;

        loop: while (!queue.isEmpty()) {
            Position poll = queue.poll();

            for (int[] del : deltas) {
                int nr = poll.row + del[0];
                int nc = poll.col + del[1];

                if (isIn(nr, nc) && matrix[nr][nc] == 1) {
                    queue.add(new Position(nr,nc));
                    matrix[nr][nc] = matrix[poll.row][poll.col] -1;
                    if (nr == n - 1 && nc == m - 1) {
                        result = matrix[nr][nc] * -1;
                        break loop;
                    }

                }
            }


        }
    }

    private static boolean isIn(int row, int col) {
        return row >=0 && row <n && col >= 0 && col <m;
    }

    static class Position{

        int row;
        int col;

        public Position( int row, int col) {

            this.row = row;
            this.col = col;
        }
    }



}