package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2667 {

    StringBuilder sb = new StringBuilder();
    List<Integer> danji = new ArrayList<>();
    int[][] matrix;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");

            int j = 1;
            for (String s : split) {
                matrix[i][j++] = Integer.parseInt(s);
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(matrix[i][j] != 0)
                    bfs(i,j);
            }
        }

        Collections.sort(danji);
        sb.append(danji.size()).append("\n");
        for (Integer integer : danji) {
            sb.append(integer).append("\n");
        }


        System.out.println(sb);

    }

    public void bfs(int row, int col) {

        Queue<Cor> q = new LinkedList<>();

        q.add(new Cor(row,col));
        matrix[row][col] = 0;
        int nOfHome = 0;
        while (!q.isEmpty()) {
            Cor poll = q.poll();
            nOfHome++;
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
        danji.add(nOfHome);
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
        new P2667().solution();
    }
}





