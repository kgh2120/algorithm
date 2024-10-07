import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

            
        
        int idx = 1;
        int sIndex = 0;
     
        
        // 그.. 이미 설치된 station 범위 안에 있다면        
        while(idx <= n){
           
            if(stations[sIndex] + w < idx){
                if(++sIndex == stations.length)
                    sIndex--;
            }
                
            if(inbound(stations[sIndex], w, idx)){
                idx = stations[sIndex] + w + 1;
                continue;
            }
         
            answer++;
            idx += 2*w + 1;
        }

        return answer;
    }
    
    private boolean inbound(int s, int w, int idx){
        return s - w <= idx && idx <= s+w;
    }
    
   
}