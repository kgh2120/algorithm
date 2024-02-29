import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[][] matrix;
    static int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    static int n;
    static boolean [][] visited;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        // rgb
        // rb


        int rgbCount = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                bfs(i,j,matrix[i][j]);
                rgbCount++;
            }
        }

        int rbCount = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                char value = matrix[i][j];
                char [] target = null;
                if (value == 'B') {
                    target = new char[]{'B'};
                }else{
                    target = new char[]{'R','G'};
                }
                bfs(i,j,target);
                rbCount++;
            }
        }


        System.out.println(rgbCount + " " + rbCount);


    }

    static void bfs(int row, int col, char... target){

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int[] delta : deltas) {
                int nr = delta[0] + poll[0];
                int nc = delta[1] + poll[1];

                if ( isIn(nr, nc) && !visited[nr][nc] &&  isSame(matrix[nr][nc], target)) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }

        }

    }

    static boolean isSame(char cur, char ... targets) {
        for (char target : targets) {
            if(target == cur)
                return true;
        }
        return false;
    }

    static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >=0 && col < n;
    }

}