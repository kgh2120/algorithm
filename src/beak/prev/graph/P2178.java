package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {

    StringBuilder sb = new StringBuilder();
    int[][] matrix;

    int nOfWorm;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tRow = Integer.parseInt(st.nextToken());
        int tCol = Integer.parseInt(st.nextToken());
        matrix = new int[tRow+2][tCol+2];

        for (int i = 1; i <= tRow; i++) {
            String[] split = br.readLine().split("");
            int j =1;
            for (String s : split) {
                matrix[i][j++]  = Integer.parseInt(s);
            }
        }


        bfs(1,1);




        System.out.println(matrix[tRow][tCol]);

    }

    public void bfs(int row, int col) {

        Queue<Cor> q = new LinkedList<>();

        q.add(new Cor(row,col));


        while (!q.isEmpty()) {
            Cor poll = q.poll();
            int count = matrix[poll.row][poll.col];
            // 4방을 봐야 함.
            // 위
            enque(q, poll.row -1 , poll.col,count);
            // 아래
            enque(q,poll.row+1,poll.col,count);
            // 오른쪽
            enque(q,poll.row,poll.col+1,count);
            // 왼쪽
            enque(q,poll.row,poll.col-1,count);
        }
    }

    public void enque(Queue<Cor>q, int row, int col, int count) {

        if (matrix[row][col] == 1) {
            q.add(new Cor(row,col));
            matrix[row][col] = count+1;
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
        new P2178().solution();
    }
}





