import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static boolean [][] matrix;
    static boolean [][] visited;
    static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    static int r;
    static int c;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        while(tc-->0){
            
            st = new StringTokenizer(br.readLine());
             r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());      
            
            
            matrix = new boolean[r][c];
            visited = new boolean[r][c];
            
            while(k-->0){
                st = new StringTokenizer(br.readLine());
                
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                
                matrix[row][col] = true;
                
            }     
            
            

            int count = 0;
            for(int i = 0; i<r; i++){
                for(int j = 0; j< c; j++){
                    if(visited[i][j] || !matrix[i][j]) continue;
                    bfs(i, j);
                    count++;
                }
            }
            
            
            sb.append(count).append("\n");
            
        }
        
        System.out.print(sb);
        
    }
    
    static void bfs(int startRow, int startCol){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        while(!q.isEmpty()){
            
            int[] pos = q.poll();
            
            for(int [] delta : deltas){
                int nr = delta[0] + pos[0];
                int nc = delta[1] + pos[1];
                
                if(isIn(nr,nc) && matrix[nr][nc] && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
            
            
        }
    }
    
    static boolean isIn(int row, int col){
        return row >= 0 && row < r && col >= 0 && col < c;
    }
}
