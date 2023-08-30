import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static boolean [][][] check;
    static List<Pos> next;
    static boolean flag;

    public static void main(String[] args) throws Exception {

        matrix = new int[9][9];
        check = new boolean[3][9][10];
        next = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int number = line.charAt(j) - '0';
                matrix[i][j] = number;
                if (number != 0) {

                    check[0][i][number] = true;
                    check[1][j][number] = true;
                    check[2][getSection(i,j)][number] = true;
                }else{
                    next.add(new Pos(i,j));
                }

            }
        }

        bf(0);
        System.out.println(sb);
    }

    private static void bf(int index){

        if (index == next.size()) {
            flag = true;

            appendResult();


            return;
        }

        Pos pos = next.get(index);
        for (int i = 1; i <= 9 ; i++) {
            if (isValid(pos.r, pos.c, i)) {
                matrix[pos.r][pos.c] = i;
                check[0][pos.r][i] = true;
                check[1][pos.c][i] = true;
                check[2][getSection(pos.r,pos.c)][i] = true;
                bf(index+1);
                if(flag) return;
                matrix[pos.r][pos.c] = 0;
                check[0][pos.r][i] = false;
                check[1][pos.c][i] = false;
                check[2][getSection(pos.r,pos.c)][i] = false;
            }
        }
    }

    private static void appendResult(){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sb.append(anInt);
            }
            sb.append("\n");
        }

    }


    private static boolean isValid(int r, int c, int num) {
        return !(check[0][r][num] || check[1][c][num] || check[2][getSection(r,c)][num]);
    }

    // section 구하기
    private static int getSection(int r, int c){
        int row = r/3;
        int col = c/3;
        return row * 3 + col;
    }

    static class Pos{
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}