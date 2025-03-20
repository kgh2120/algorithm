import java.io.*;
import java.util.*;

/**
 운영진들은 상하좌우로 이동가능함.
 이동할 수 있는 방이 있고 , 부숴야 이동가능한 벽이 존재함.

 벽을 최소 몇개 부숴야 하는지를 찾고 싶어한다. -> 최단 거리 X
 탈출을 위해 최소한으로 부수는 케이스.

 **/

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int maxRow;
    static int maxCol;

    static int[][] matrix;
    static int[][] dp;


    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};


    static final int DIJKSTRA_INIT = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());


        maxCol = Integer.parseInt(st.nextToken());
        maxRow = Integer.parseInt(st.nextToken());

        matrix = new int[maxRow][maxCol];
        dp = new int[maxRow][maxCol];




        for(int i = 0; i<maxRow; i++){
            String row = br.readLine();
            Arrays.fill(dp[i], DIJKSTRA_INIT);
            for(int j = 0; j<maxCol;j++){
                int cell = row.charAt(j) - '0';
                matrix[i][j] = cell;
            }
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));
        dp[0][0] = 0;


        while(!q.isEmpty()){
            Node cur = q.poll();

            if(dp[cur.row][cur.col] < cur.cost) continue;

            for (int[] delta : deltas) {
                int nr = cur.row + delta[0];
                int nc = cur.col + delta[1];

                if (isIn(nr, nc) && dp[nr][nc] > cur.cost + matrix[nr][nc]) {
                    dp[nr][nc] = cur.cost + matrix[nr][nc];
                    q.add(new Node(nr, nc, cur.cost + matrix[nr][nc]));
                }
            }
        }

        System.out.println(dp[maxRow-1][maxCol-1]);



    }


    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    static class Node implements Comparable<Node>{
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }


}
