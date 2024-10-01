import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        int[][] dp = new int[size+1][size+1];
        
        for(int i = 0; i<size; i++){
            for(int j = 0; j<=i; j++){
                dp[i+1][j+1] = triangle[i][j] + Math.max(dp[i][j], dp[i][j+1]);
            }
        }
        
      
        for(int value : dp[size])
            answer = Math.max(answer, value);
        
        return answer;
    }
}