package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {

    StringBuilder sb = new StringBuilder();
    List<Integer> danji = new ArrayList<>();
    int[][] matrix;

    int nOfWorm;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfTest = Integer.parseInt(br.readLine());

        for (int i = 0; i < nOfTest; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int nOfBaecu = Integer.parseInt(st.nextToken());
            matrix = new int[row+2][col+2];
            nOfWorm=0;
            for (int j = 0; j < nOfBaecu; j++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                matrix[r+1][c+1] = 1;
            }

            for (int r = 1; r <= row ; r++) {
                for (int c = 1; c <= col ; c++) {
                    if(matrix[r][c] != 0)
                        bfs(r,c);
                }
            }
            sb.append(nOfWorm).append("\n");

        }

        System.out.println(sb);

    }

    public void bfs(int row, int col) {

        Queue<Cor> q = new LinkedList<>();

        q.add(new Cor(row,col));
        matrix[row][col] = 0;
        nOfWorm++;
        while (!q.isEmpty()) {
            Cor poll = q.poll();
            // 4방을 봐야 함.
            // 위
            enque(q, poll.row -1 , poll.col);
            // 아래
            enque(q,poll.row+1,poll.col);
            // 오른쪽
            enque(q,poll.row,poll.col+1);
            // 왼쪽
            enque(q,poll.row,poll.col-1);
        }
    }

    public void enque(Queue<Cor>q, int row, int col) {

        if (matrix[row][col] != 0) {
            q.add(new Cor(row,col));
            matrix[row][col] = 0;
        }
    }

    class Cor {
        int row;
        int col;

        public Cor(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }





    public static void main(String[] args) throws Exception {
        new P1012().solution();
    }
}





