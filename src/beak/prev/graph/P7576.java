package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

    StringBuilder sb = new StringBuilder();
    int day = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[y][x];
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < y; i++) {
            int k = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                matrix[i][k] = token;
                if (token == 1) {
                    q.add(new Tomato(i, k, day));
                }
                k++;
            }
        }

        if (isFull(matrix)) {
            System.out.println(0);
            return;
        }

        bfs(q, matrix);

        if (isFull(matrix)) {
            System.out.println(day);
            return;
        }
        System.out.println(-1);
    }


    public void bfs(Queue<Tomato> q, int[][] matrix) {

        while (!q.isEmpty()) {
            Tomato poll = q.poll();
            day = Math.max(poll.day, day);

            // 사방 전염
            moveFourDirection(matrix,poll,q);
        }

    }

    public void moveFourDirection(int[][] matrix, Tomato t, Queue<Tomato> q) {

        // 위
        move(matrix, t.row, t.col, -1, 0, q, t.day);
        // 아래
        move(matrix, t.row, t.col, 1, 0, q, t.day);
        // 좌
        move(matrix, t.row, t.col, 0, -1, q, t.day);
        // 우
        move(matrix, t.row, t.col, 0, +1, q, t.day);
    }

    public void move(int[][] matrix, int row, int col, int rowD, int colD, Queue<Tomato> q,
            int day) {
        if ( row + rowD >= 0
                && row + rowD < matrix.length
                && col + colD >= 0
                && col + colD < matrix[0].length
                &&
                matrix[row + rowD][col + colD] == 0
        ) {

            q.add(new Tomato(row + rowD, col + colD, day + 1));
            matrix[row + rowD][col + colD] = day + 1;
        }
    }


    public boolean isFull(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    class Tomato {

        int row;
        int col;
        int day;

        public Tomato(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }


    public static void main(String[] args) throws Exception {
        new P7576().solution();
    }
}





