package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
    https://www.acmicpc.net/problem/10026
    그래프 탐색 골드 5
    문제는 별로 안어려웠는데 웹 에디터로 하다보니 진짜 존나많이 틀린다.
    컴파일조차 안됨..
    짜증난다 진짜로..
    체크하기 너무 힘들다...

 */

public class P10026 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];

        for(int i = 0; i<n; i++){
            String row = br.readLine();
            for(int j = 0; j<n; j++){
                matrix[i][j] = row.charAt(j);
            }
        }
        int rgb = rgbBfs(matrix,n);
        int rg =  rbBfs(matrix,n);

        System.out.println(rgb + " " + rg);
    }

    private static int rgbBfs(char[][]matrix, int n){
        boolean [][] visited = new boolean[n][n];
        int c = 0;
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(visited[i][j])
                    continue;
                c++;
                Queue<Cor> q = new LinkedList<>();
                q.add(new Cor(i,j));
                visited[i][j] = true;

                while(!q.isEmpty()){
                    Cor poll = q.poll();
                    char o = matrix[poll.row][poll.col];
                    moveRgb(poll.row-1, poll.col, o, matrix,visited,q,n );
                    moveRgb(poll.row+1, poll.col, o, matrix,visited,q,n );
                    moveRgb(poll.row, poll.col-1, o, matrix,visited,q,n );
                    moveRgb(poll.row, poll.col+1, o, matrix,visited,q,n );
                }
            }
        }
        return c;
    }

    private static int rbBfs(char[][]matrix, int n){
        boolean [][] visited = new boolean[n][n];
        int c = 0;
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(visited[i][j])
                    continue;
                c++;
                Queue<Cor> q = new LinkedList<>();
                q.add(new Cor(i,j));
                visited[i][j] = true;

                while(!q.isEmpty()){
                    Cor poll = q.poll();
                    char o = matrix[poll.row][poll.col];
                    moverb(poll.row-1, poll.col, o, matrix,visited,q,n );
                    moverb(poll.row+1, poll.col, o, matrix,visited,q ,n);
                    moverb(poll.row, poll.col-1, o, matrix,visited,q,n );
                    moverb(poll.row, poll.col+1, o, matrix,visited,q,n );
                }
            }
        }
        return c;
    }


    private static void moveRgb(int row, int col, char o, char[][] matrix, boolean [][] visited, Queue<Cor> q, int n){
        if(row >= 0 && row < n && col >= 0 && col <n
        ){
            if(o ==matrix[row][col] && !visited[row][col] ){
                visited[row][col] = true;
                q.add(new Cor(row,col));
            }

        }
    }

    private static void moverb(int row, int col, char o, char[][]matrix, boolean [][] visited, Queue<Cor> q, int n){
        if(row >= 0 && row < n && col >= 0 && col <n
        ){
            if((o == matrix[row][col] || rg(o,matrix[row][col]))  && !visited[row][col]){
                visited[row][col] = true;
                q.add(new Cor(row,col));
            }

        }
    }

    private static boolean rg(char o , char t){
        return (o == 'R' && t == 'G') || (o == 'G' && t == 'R');
    }




}


class Cor{
    int row;
    int col;

    Cor(int r, int c){
        row = r;
        col = c;
    }
}

