package beak.Jul2023.p14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] matrix;
    static int n,m;
    static int r,c;
    static int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public static void main(String[] args) throws Exception {
        setVariables();
        bfs();
        printResult();
    }

    private static void printResult() {
        for(int[] row : matrix){
            for(int col : row)
                sb.append(col).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c,0});
        matrix[r][c] = 0;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int[] del : deltas){
                int nr = poll[0] + del[0];
                int nc = poll[1] + del[1];
                if(isIn(nr,nc) && matrix[nr][nc] == -1){
                    int turn = poll[2] + 1;
                    queue.add(new int[]{nr,nc, turn});
                    matrix[nr][nc] = turn;
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(number == 2){
                    r = i;
                    c = j;
                }
                if(number == 1)
                    number = -1;
                matrix[i][j] = number;
            }
        }
    }


}