import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int row;
    static int col;
    
    static int[][] deltas = {{-1,0}, {0,1}, {0,-1}, {1,0}};
    static boolean [][] visited;
    static int[][] map;
    
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());

        row= Integer.parseInt(st.nextToken());
        col= Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        visited = new boolean[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        int nOfTomato= 0;
        int minus = 0;
        
        for(int i = 0; i < col; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j< row; j++){
                int f = Integer.parseInt(st.nextToken());
                map[j][i] = f;
                
                if(f == 1){
                    visited[j][i] = true;
                    q.add(new int[]{j,i});
                    nOfTomato++;
                } else if(f == -1)
                    minus++;
                
            }
            
        }
        
        if(nOfTomato + minus == row * col){
            System.out.println(0);
            return;
        }
        
        
        
        int turn = -1;
        while(!q.isEmpty()){
            turn++;
            int size = q.size();
            while(size-->0){
                    
            int [] coor = q.poll();
            
            for(int [] delta : deltas){
                int nr = coor[0] + delta[0];
                int nc = coor[1] + delta[1];
                
                    if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] != -1){
                        nOfTomato++;
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        
        }
        
        int answer = nOfTomato + minus == row * col ? turn : -1;
        System.out.println(answer);
        
    }
    
    
    static boolean isIn(int r, int c){
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}
