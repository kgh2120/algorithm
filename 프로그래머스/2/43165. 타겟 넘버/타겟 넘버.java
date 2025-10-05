import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        int idx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        
        for(int number : numbers){
            int size = q.size();
            while(size-->0){
                int cur = q.poll();
                q.add(cur + number);
                q.add(cur - number);
            }    
        }
        
        while(!q.isEmpty()){
            if(target == q.poll())
                answer++;
        }
        
        
        
        return answer;
    }
    
    
}