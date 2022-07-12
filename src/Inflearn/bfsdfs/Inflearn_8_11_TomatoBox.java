package Inflearn.bfsdfs;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn_8_11_TomatoBox {

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
    int[] mRow = {-1,1,0,0};
    int[] mCol = {0,0,-1,1};

    int rMax;
    int cMax;


    public boolean canMove(int row, int col, int code) {

        return row+mRow[code] >= 0 && row + mRow[code] < rMax
        && col+mCol[code] >=0 && col+mCol[code] <cMax
                && matrix[row+mRow[code]][col+mCol[code]] == 0;

    }

    public boolean isFull() {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if(anInt == 0)
                    return false;
            }
        }
        return true;
    }




    public int BFS(Queue<Coordinate> tomatos) {
        if (isFull()) {
            return 0;

        }
        int level = 0;

       loop: while (!tomatos.isEmpty()) {
            int size = tomatos.size();

            for (int i = 0; i < size; i++) {
                Coordinate tomato = tomatos.poll();
                for (int j = 0; j < 4; j++) {
                    if (canMove(tomato.row, tomato.col, j)) {
                        Coordinate newTomato = new Coordinate(tomato.row + mRow[j], tomato.col + mCol[j]);
                        matrix[newTomato.row][newTomato.col] = level;

                        tomatos.add(newTomato);
                    }

                }
            }

           level++;
           if (isFull())
               break;
        }

        if(!isFull())
            level = -1;

       return level;
    }

    public void showMatrix(int row, int col, int[][] matrix) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cons = br.readLine();
        String[] s = cons.split(" ");

        Scanner sc = new Scanner(System.in);
        int col = Integer.parseInt(s[0]);
        int row = Integer.parseInt(s[1]);

        Inflearn_8_11_TomatoBox m = new Inflearn_8_11_TomatoBox();
        m.matrix = new int[row][col];
        m.rMax = row;
        m.cMax = col;
        Queue<Coordinate> tomatos = new ArrayDeque<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j <col ; j++) {
//                int tomato = sc.nextInt();
//                m.matrix[i][j] = tomato;
//                if(tomato == 1)
//                    tomatos.add(new Coordinate(i,j));
//            }
//        }

        for (int i = 0; i < row; i++) {
            String mm = br.readLine();
            String[] s1 = mm.split(" ");
            for (int j = 0; j < s1.length; j++) {
                int i1 = Integer.parseInt(s1[j]);
                m.matrix[i][j] = i1;
                if(i1 == 1)
                    tomatos.add(new Coordinate(i,j));
            }
        }
//        m.showMatrix(row,col, m.matrix);
//        System.out.println(m.isFull());
        int bfs = m.BFS(tomatos);
        System.out.println(bfs);
    }





}