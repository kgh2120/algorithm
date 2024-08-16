import java.util.*;
class Solution {
    
    int[][] dp;
    int[][] deltas = {{1,0}, {0,1}};
    
    int m;
    int n;
    final int mod = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        
       
        
        for(int[] hole : puddles)
            dp[hole[0]-1][hole[1]-1] = -1;
        
        
        for(int i = 1; i<m; i++){
              if(dp[i][0] != -1)
                dp[i][0] = 1;
            else
                break;
        }
          
        
        
        for(int i = 1; i<n; i++){
            if(dp[0][i] != -1)
                  dp[0][i] = 1;
            else break;
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(dp[i][j] == -1) continue;
                int left = Math.max(0, dp[i][j-1]);
                int up = Math.max(0, dp[i-1][j]);
                
                dp[i][j] = left+up;
                dp[i][j] %= mod;                
            }
        }
           
        
        answer = dp[m-1][n-1];
        
      
        
        return answer;
    }
    
  
}