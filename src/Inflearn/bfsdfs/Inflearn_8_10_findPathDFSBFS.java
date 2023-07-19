package Inflearn.bfsdfs;



import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn_8_10_findPathDFSBFS {

    class Coordinate{
        int row;
        int col;

        public Coordinate() {
        }

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] matrix;
    int ans = Integer.MAX_VALUE;
    boolean flag = false;
    int level;
    int move;
    public Coordinate move(int code, int nr, int nc) {
        int row = 0;
        int col = 0;

        switch (code) {
            case 1 :
                // 1 : 상
                row = nr-1;
                col = nc;
                if(row <= 0 || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return null;
                break;
            case 2 :
                // 2 : 하
                row = nr+1;
                col = nc;
                if(row >= matrix.length || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return null;
                    break;
            case 3 :
                // 3 : 좌
                row = nr;
                col = nc-1;
                if(col <= 0 || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return null;
                break;

            case 4:
                // 4 : 우
                row = nr;
                col = nc+1;
                if(col >= matrix[row].length || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return null;
                break;
        }
        matrix[nr][nc] = 9;


        Coordinate coordinate = new Coordinate();
        coordinate.row = row;
        coordinate.col = col;
        return coordinate;
    }

    public void showMatrix() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void DFS(int nr, int nc) {
        if(move > ans) return;
        if (nr == 7 && nc == 7) {
            ans = Math.min(ans,move);
        }else{
            for (int i = 1; i <= 4; i++) {

                Coordinate cor = move(i, nr, nc);
                if (cor !=null) {
                    move++;
                    DFS(cor.row,cor.col);
                    matrix[nr][nc] = 0;
                    move--;
                }
            }
        }
    }

    public void BFS(int targetRow, int targetCol) {
        Queue<Coordinate> cors = new ArrayDeque<>();
        cors.add(new Coordinate(1,1));
        loop : while (!cors.isEmpty()) {
            int size = cors.size();

            for (int i = 0; i < size; i++) {
                Coordinate poll = cors.poll();

                if (poll.row == targetRow && poll.col == targetCol) {
                    flag = true;
                    break loop;
                }
                for (int j = 1; j <= 4; j++) {
                    Coordinate movedCor = move(j, poll.row, poll.col);
                    if(movedCor!=null)
                        cors.add(movedCor);
                }
            }
            level++;
        }

        if (flag)
            System.out.println(level);
        else
            System.out.println(-1);


    }





    public static void main(String[] args) {
        Inflearn_8_10_findPathDFSBFS m = new Inflearn_8_10_findPathDFSBFS();
        Scanner sc = new Scanner(System.in);

        m.matrix = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                m.matrix[i][j] = sc.nextInt();
            }
        }
//        m.DFS(1,1);
//        System.out.println(m.ans == Integer.MAX_VALUE ? -1 : m.ans);
        m.BFS(7,7);
    }




}