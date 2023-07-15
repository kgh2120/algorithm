package beak.Sep2023.p2447;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int n;
    static char[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];

        printStar(0,0,n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void printStar(int row, int col, int n){

        int depth = n/3;
        if (depth == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        matrix[row+i][col+j] = ' ';
                        continue;
                    }
                    matrix[row+i][col+j] = '*';
                }
            }
            return;
        }

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if (i ==1 && j == 1) {
                    printBlank(row  + i* depth, col + j * depth,depth);
                    continue;
                }
                printStar(row  + i* depth, col + j * depth,depth);
            }
        }

    }
    private static void printBlank(int row, int col, int n) {
        int depth = n/3;
        if (depth == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[row+i][col+j] = ' ';
                }
            }
            return;
        }

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                printBlank(row  + i* depth, col + j * depth,depth);
            }
        }


    }


}