import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[][] matrix;
    static int n,m;
    static int r,c;

    static int[][] deltas = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    static int count;
    static final char VISITED = '1';
    static final char BLOCK = 'X';
    static final char PEOPLE = 'P';

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new char[n][m];
        // I를 알려면 결국은 다 돌아야함..
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j<m; j++){
                char col = line.charAt(j);
                    matrix[i][j] = col;
                    if(col == 'I'){
                        r = i;
                        c = j;
                    }

            }
        }


        bfs();
        System.out.println(count != 0 ? count : "TT");

    }

    private static void bfs(){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        matrix[r][c] = VISITED;

        while(!q.isEmpty()){

            int[] poll = q.poll();


            for(int[] del : deltas){
                int nr = poll[0] + del[0];
                int nc = poll[1] + del[1];

                if(isIn(nr,nc) && matrix[nr][nc] != BLOCK&& matrix[nr][nc] != VISITED ){
                    if(matrix[nr][nc]==PEOPLE)
                        count++;
                    matrix[nr][nc] = VISITED;
                    q.add(new int[]{nr,nc});
                }
            }
        }


    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }


}