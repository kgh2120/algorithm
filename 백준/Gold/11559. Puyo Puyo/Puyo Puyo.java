import java.util.*;
import java.io.*;

/*
    같은 타입의 뿌요가 상하좌우 방향으로 4개가 있다면 터진다. 
    터지면 1연쇄가 추가됨. 
        연쇄 : 터질 기회 1개 추가.
    
    터지고 나면 아래로 떨어진다.
    동시에 터질 애들이 있다면 연쇄는 1개만 준다.
*/

public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map;
    static int maxRowSize = 12;
    static int maxColSize = 6;
    
    static int[][] deltas = {
      {-1,0}  ,{0,-1},{1,0},{0,1}
    };
    
    static final char BLANK = '.';
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        map = new char[maxRowSize][];
        for(int i = 0; i<maxRowSize; i++){
            map[i] = input.readLine().toCharArray();
        }
        
        int answer = play();
        System.out.println(answer);
    }
    
    static int play(){
        
        int chainCount = 0;
        while(true){
            boolean isChained = false;
            for(int i = maxRowSize-1; i>=0; i--){
                for(int j = maxColSize-1; j>=0; j--){
                    if(map[i][j] == BLANK) continue;
                    
                    if(bfs(i,j)){
                        isChained = true;
                    }
                }
            }
            
            if(isChained){
                chainCount++;
                dropDown();
                continue;
            } 
            
            return chainCount;
        }
        
    }
    
    static void dropDown(){
        for(int col = 0; col < maxColSize; col++){
            for(int row = maxRowSize -1; row >= 0; row--){ // 새로 위치할 곳
                if(map[row][col] != BLANK ) continue;
                for(int target = row-1; target>=0; target--){
                    if(map[target][col] == BLANK) continue;
                    map[row][col] = map[target][col];
                    map[target][col] = BLANK;
                    break;
                }
            }
        }
    }
    
    static boolean bfs(int row, int col){
        boolean [][] visited = new boolean[maxRowSize][maxColSize];
        visited[row][col] = true;
        
        char target = map[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> brokenQueue = new ArrayDeque<>();
        q.add(new int[]{row,col});

        int puyoCount = 0;
        while(!q.isEmpty()){
            
           int[] puyo = q.poll();
           brokenQueue.add(puyo);
           puyoCount++;
        
            for(int[] delta : deltas){
                int nr = puyo[0] + delta[0];
                int nc = puyo[1] + delta[1];
                
                if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == target){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
            
        }
        
        if(puyoCount >= 4){
            while(!brokenQueue.isEmpty()){
                 int[] puyo = brokenQueue.poll();
                map[puyo[0]][puyo[1]] = BLANK;
            }
        }
        
        return puyoCount >= 4;
    }
    
    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRowSize && col >= 0 && col < maxColSize;
    }
    

}
