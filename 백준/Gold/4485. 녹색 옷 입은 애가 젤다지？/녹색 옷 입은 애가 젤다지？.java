import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static int n;

    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };
    static int[][] dp;
    static boolean[][] visited;
    static final int INF = 10_0000_0007;
    public static void main(String[] args) throws Exception {


        int TC = 1;
        while  ((n = Integer.parseInt(br.readLine())) != 0) {
            setVariables();
            visited[0][0] = true;
            bfs();

//            for (int[] ints : dp) {
//                System.out.println(Arrays.toString(ints));
//            }

            sb.append("Problem ").append(TC++).append(": ").append(dp[n-1][n-1]).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,matrix[0][0]));
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int[] delta : deltas) {
                int nr = node.row + delta[0];
                int nc = node.col + delta[1];
                if (isIn(nr, nc) && dp[nr][nc] > node.cost + matrix[nr][nc]) {
                    dp[nr][nc] = node.cost + matrix[nr][nc];
                    q.add(new Node(nr,nc,dp[nr][nc]));
                }
            }
        }




    }

    private static void setVariables() throws IOException {
        matrix = new int[n][n];
        dp = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i],INF);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = matrix[0][0];
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }



    static class Node{
        int row;
        int col;
        int cost;
        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }



}