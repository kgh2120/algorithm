import java.util.*;
import java.io.*;


public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n;
    static int[][] matrix;
    static int[][] dp;
    
    static boolean[][]visited;
    static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        dp = new int[n][n];
      
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = -1;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
            
                max = Math.max(dfs(i,j), max);
            }
        }
        System.out.println(max);
    }
    
    static int dfs(int row, int col){
        
        if(dp[row][col] != 0)
            return dp[row][col];
            
        dp[row][col] = 1;
       
        for(int [] del : deltas){
            int nr = row + del[0];
            int nc = col + del[1];
            
            if(isIn(nr,nc) && matrix[row][col] < matrix[nr][nc]){
                 dp[row][col] = Math.max(dp[row][col], dfs(nr,nc)+1);
            }
        }
        return dp[row][col];
    }
    
    static boolean isIn(int row, int col){
        return row >= 0 && row <n && col >= 0 && col <n;
    }
}
