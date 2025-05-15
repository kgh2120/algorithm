import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        
        int index = 0;
       for(int number : numbers){
            int size = q.size();
            while(size-->0){
                int num = q.poll();
                q.add(num + number);
                q.add(num - number);
            }
          
        }
        
        while(!q.isEmpty()){
            if(target == q.poll())
               answer++; 
        }
        
    
        
        return answer;
    }
    
    
}