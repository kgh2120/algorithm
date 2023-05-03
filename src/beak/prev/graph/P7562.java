package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {

    StringBuilder sb = new StringBuilder();
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfCase = Integer.parseInt(br.readLine());

        int i = 0;
        while (i < nOfCase) {
            int matrixSize = Integer.parseInt(br.readLine());

            int[][] matrix = new int[matrixSize][matrixSize];
            for (int[] ints : matrix) {
                Arrays.fill(ints,Integer.MAX_VALUE);
            }


            StringTokenizer st = new StringTokenizer(br.readLine());
            Cor start = new Cor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Cor target = new Cor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(matrix, start, target);
            i++;

        }
        System.out.println(sb.toString());
    }

    public void bfs(int[][]matrix, Cor start,  Cor target){


        Queue<Cor> q = new LinkedList<>();
        q.add(start);
        matrix[start.row][start.col] = 0;
        int seq = 0;
        while (!q.isEmpty()) {
            Cor poll = q.poll();
            seq = matrix[poll.row][poll.col];

            if (poll.row == target.row && poll.col == target.col) {
                sb.append(seq).append("\n");
                break;
            }

            if(move(matrix, q, seq, poll, -2, -1, target))
                break;
            if(move(matrix, q, seq, poll, -1, -2, target))
                break;
            if(move(matrix, q, seq, poll, -2, +1, target))
                break;
            if(move(matrix, q, seq, poll, -1, +2, target))
                break;

            if(move(matrix, q, seq, poll, +1, -2, target))
                break;
            if(move(matrix, q, seq, poll, +2, -1 ,target))
                break;
            if(move(matrix, q, seq, poll, +1, +2, target))
                break;
            if(move(matrix, q, seq, poll, +2, +1, target))
                break;



        }




    }

    private boolean move(int[][] matrix, Queue<Cor> q, int seq, Cor poll, int rowD, int colD, Cor target) {
        if (poll.row + rowD == target.row && poll.col + colD == target.col) {
            sb.append(seq+1).append("\n");
            return true;
        }


        if (poll.row + rowD >= 0 && poll.row + rowD < matrix.length
                && poll.col + colD >= 0 && poll.col + colD < matrix.length
                && matrix[poll.row + rowD][poll.col +colD] > seq+1) {
                q.add(new Cor(poll.row +rowD, poll.col +colD));
            matrix[poll.row + rowD][poll.col + colD] = seq + 1;

        }
        return false;
    }


    class Cor{
        int row;
        int col;

        public Cor(int row, int col) {
            this.row = row;
            this.col = col;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cor cor = (Cor) o;
            return row == cor.row && col == cor.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }


    public static void main(String[] args) throws Exception {
        new P7562().solution();
    }
}





