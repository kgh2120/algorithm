package programmers.prev.random;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot {


    int row;
    int col;
    public int solution(String[] board) {
        int answer = 0;
        row = board.length;
        col = board[0].length();
        int startR = 0;
        int startC = 0;
        int endR = 0;
        int endC = 0;
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(board[i].charAt(j) == 'R'){
                    startR = i;
                    startC = j;
                }
                if(board[i].charAt(j) == 'G'){
                    endR = i;
                    endC = j;
                }
            }

        }

        return findPath(board,startR,startC,endR,endC);
    }

    public int findPath(String[]board, int sr, int sc, int endR, int endC){
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[row][col];
        q.add(new int[]{sr,sc});
        visited[sr][sc] = 1;
        visited[endR][endC] = -1;

        while(!q.isEmpty()){
            int[]cor = q.poll();
            int r = cor[0];
            int c = cor[1];

            move(r,c,-1,0,visited,board,q);
            move(r,c,1,0,visited,board,q);
            move(r,c,0,-1,visited,board,q);
            move(r,c,0,1,visited,board,q);

            if(visited[endR][endC] != -1)
                return visited[endR][endC] -1;

        }
        return -1;
    }
    public void move(int r, int c, int mr, int mc, int[][]visited, String[]board, Queue<int[]>q){
        int cr = r;
        int cc = c;
        while(cr+mr >=0 && cr + mr < row && cc+mc >=0 && cc+mc <col && board[cr+mr].charAt(cc+mc) != 'D') {
            cr = cr+mr;
            cc = cc+mc;

        }

        if(visited[cr][cc] == 0){
            q.add(new int[]{cr,cc});
            visited[cr][cc] = visited[r][c] +1;
        }


        if(board[cr].charAt(cc) == 'G'){
            visited[cr][cc] = visited[r][c] +1;
        }
    }


    public static void main(String[] args) throws IOException {
//        String [] a = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String [] a = {".D.R", "....", ".G..", "...D"};

        System.out.println(((new RicochetRobot().solution(a))));



    }
}
