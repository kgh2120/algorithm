import java.util.*;
class Solution {

    final int init = -1;
    public int solution(int[] money) {
        int answer = 0;
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        int length = money.length;
        if(length == 3){
            return Math.max(money[0], Math.max(money[1], money[2]));
        }
        dp2[0] = money[0];
        dp1[1] = money[1];
        dp1[2] = money[2]; 
        dp2[2] = money[0] + money[2];
        
            
        
        for(int i = 3; i<length; i++){
            // 내 기준에서.. i-2 or i-3 어차피 i-1은 못먹음
            
            if(i == length-1){
              dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + money[i];
              dp2[i] = Math.max(dp2[i-2], dp2[i-1]);
                continue;
            }
            
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + money[i];
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + money[i];
        }
        
        
        
        answer = Math.max(dp1[length-1], dp2[length-1]);
        return answer;
    }

    

}