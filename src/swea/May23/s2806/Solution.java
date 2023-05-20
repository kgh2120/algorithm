package swea.May23.s2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static boolean[][] board;
//    static List<Set<Integer>> blocked;
    static int n;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i<=t; i++){
            n = Integer.parseInt(br.readLine());
            count = 0;
            board = new boolean[n][n];
            nQueen(0,n);
            System.out.println("#"+i +" "+count);


        }
    }

    private static void nQueen(int depth, int n){
        if(depth == n){
            count++;

            return;
        }

        for (int i = 0; i < n; i++) {
            if(board[depth][i])
                continue;
            // 갈 수 있음
            boolean[][] temp = block(depth, i);
            nQueen(depth+1,n);
            board = temp;

        }
    }
    private static boolean[][] block(int depth, int i){

        boolean[][] temp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                temp[j][k] = board[j][k];
            }
        }

        // 일단.. 세로 줄 밴하기
        for (int j = depth; j < n; j++) {
            board[j][i]=true;
            if(i+j-depth < n)
                board[j][i+j-depth]=true;
            if(i-j+depth >= 0)
             board[j][i-j+depth]=true;
        }

        return temp;

    }




}