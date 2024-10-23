import java.util.*;
class Solution {

    final int init = -1;
    public int solution(int[] money) {
        int answer = 0;
     
 

        int length = money.length;
        if(length == 3){
            return Math.max(money[0], Math.max(money[1], money[2]));
        }
       int[][] dp = new int[2][money.length];
        dp[1][0] = money[0];
        dp[0][1] = money[1];
        dp[0][2] = money[2]; 
        dp[1][2] = money[0] + money[2];
        
            
        
        for(int i = 3; i<length; i++){
            // 내 기준에서.. i-2 or i-3 어차피 i-1은 못먹음
            
            if(i == length-1){
              dp[0][i] = Math.max(dp[0][i-2], dp[0][i-3]) + money[i];
              dp[1][i] = Math.max(dp[1][i-2], dp[1][i-1]);
                continue;
            }
            
            dp[0][i] = Math.max(dp[0][i-2], dp[0][i-3]) + money[i];
            dp[1][i] = Math.max(dp[1][i-2], dp[1][i-3]) + money[i];
        }
        
        
        
        answer = Math.max(dp[0][length-1], dp[1][length-1]);
        return answer;
    }

    

}