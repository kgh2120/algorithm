package Inflearn.bfsdfs;



import java.util.*;

public class Inflearn_8_12_Island {

    static class Coordinate{
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
    // 상하좌우
    int[] mRow = {-1,1,0,0,-1,-1,1,1};
    int[] mCol = {0,0,-1,1,-1,1,-1,1};

    int rMax;
    int cMax;
    int ans;
    List<Coordinate> cors = new ArrayList<>();


    public boolean canMove(int row, int col, int code) {

        return row+mRow[code] >= 0 && row + mRow[code] < rMax
        && col+mCol[code] >=0 && col+mCol[code] <cMax
                && matrix[row+mRow[code]][col+mCol[code]] == 1;

    }


    public void BFS() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        for (Coordinate cor : cors) {
            if (matrix[cor.row][cor.col] == 1) {
                queue.add(cor);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        Coordinate poll = queue.poll();

                        for (int j = 0; j < 8; j++) {
                            if (canMove(poll.row, poll.col, j)) {
//                        matrix[poll.row + mRow[j]][poll.col+mCol[j]]\
                                queue.add(new Coordinate(poll.row + mRow[j],poll.col+mCol[j]));
                            }
                        }
                        matrix[poll.row][poll.col] =9; // 이미 들른 좌표
                    }
                }
                ans++;
            }
        }
    }

    public void DFS() {
        for (Coordinate cor : cors) {
            if (matrix[cor.row][cor.col] == 1) {
                DFS(cor.row, cor.col);
                ans++;
            }
        }
    }

    public void DFS(int row, int col) {
        matrix[row][col] = 9;
        for (int i = 0; i < 8; i++) {
            if(canMove(row,col,i))
                DFS(row+mRow[i],col+mCol[i]);
        }
    }

    public static void main(String[] args) {
        Inflearn_8_12_Island m = new Inflearn_8_12_Island();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        m.matrix = new int[n][n];
        m.rMax = n;
        m.cMax = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int i1 = sc.nextInt();
                m.matrix[i][j] = i1;
                if(i1 == 1)
                    m.cors.add(new Coordinate(i,j));
            }
        }

//        m.BFS();
        m.DFS();
        System.out.println(m.ans);




    }






}