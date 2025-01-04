import java.util.*;
import java.io.*;

/**
 *  크게 어렴지 않은 BFS + DP 문제같다.
 *
 *  인풋으로 미뤄보아 시작점을 (0,0)이 아닌 (1,1)로 잡는 것 같다.
 *  벽에 대해서 1로 잡는 것 같고, 벽을 깼을 때, 더 이득이 되는가를 체크하는 문제.
 *  벽부수고 이동하기와 거의 동일한 문제라고 보면 된다.
 *
 *
 */
public class Main{

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int maxRow;
    static int maxCol;

    static int[][] deltas = {
            {-1,0}, {0,-1}, {1,0}, {0,1}
    };

    static boolean[][][] visited;
    static int[][] matrix;

    static final int WALL = 1;
    static final int ROAD = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());

        matrix = new int[maxRow+1][maxCol+1];
        visited = new boolean[2][maxRow+1][maxCol+1];

        st = new StringTokenizer(input.readLine());

        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        int targetRow = Integer.parseInt(st.nextToken());
        int targetCol = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= maxRow; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 1; j <= maxCol; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findShortestPath(startRow, startCol, targetRow, targetCol));


    }

    static int findShortestPath(int startRow, int startCol, int targetRow, int targetCol){

        int turn = 0;

        Queue<Node> q = new ArrayDeque<>();
        boolean hasAbility = true;
        if(matrix[startRow][startCol] == WALL){
            hasAbility = false;
        }
        q.add(new Node(startRow, startCol, hasAbility));

        visited[hasAbility ? 1 : 0][startRow][startCol] = true;


        while(!q.isEmpty()){
            int size = q.size();

            turn++;
            while (size-- >0) {
                Node cur = q.poll();

                // 사방이동

                int k = cur.hasAbility ? 0 : 1;

                for (int[] delta : deltas) {
                    int nr = cur.row + delta[0];
                    int nc = cur.col + delta[1];

                    if (isIn(nr, nc)) {
                        // 만약 벽이라면
                        if (matrix[nr][nc] == WALL && cur.hasAbility && !visited[1][nr][nc]) {
                            q.add(new Node(nr, nc, false));
                            visited[1][nr][nc] = true;

                            if(nr == targetRow && nc == targetCol){
                                return turn;
                            }
                        }

                        if (matrix[nr][nc] == ROAD && !visited[k][nr][nc]) {
                            q.add(new Node(nr, nc, cur.hasAbility));
                            visited[k][nr][nc] = true;

                            if(nr == targetRow && nc == targetCol){
                                return turn;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }




    static boolean isIn(int row, int col) {
        return row >= 1 && row <= maxRow && col >= 1 && col <= maxCol;
    }

    static class Node{
        int row;
        int col;
        boolean hasAbility;

        public Node(int row, int col, boolean hasAbility) {
            this.row = row;
            this.col = col;
            this.hasAbility = hasAbility;
        }
    }
}