package programmers.prev.dfsbfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {



    int maxR;
    int maxC;

    public int solution(int[][] maps) {
        int answer = 0;
        maxR = maps.length;
        maxC = maps[0].length;
        int[][] visited = new int[maxR][maxC];
        return bfs(maps,visited);
    }

    public int bfs(int[][]maps, int[][]visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = 1;

        while(!q.isEmpty()){
            int[] cor = q.poll();
            int row = cor[0];
            int col = cor[1];
            int turn = visited[row][col];
//             위
            move(row-1,col,q,visited,maps,turn);
//                 아래
            move(row+1,col,q,visited,maps,turn);
//                 좌
            move(row,col-1,q,visited,maps,turn);
//                 우
            move(row,col+1,q,visited,maps,turn);

            if(visited[maxR-1][maxC-1] != 0){
                return visited[maxR-1][maxC-1];
            }

        }
        return -1;
    }

    public void move(int row, int col, Queue<int[]>q, int[][]visited, int[][]maps, int turn){
        if(row >= 0 && row < maxR && col >=0 && col < maxC){
            if(maps[row][col] == 1 && visited[row][col] ==0){
                visited[row][col] = turn +1;
                q.add(new int[]{row,col});
            }
        }
    }



    public static void main(String[] args) throws IOException {


//        System.out.println(((new Solution().solution())));



    }
}