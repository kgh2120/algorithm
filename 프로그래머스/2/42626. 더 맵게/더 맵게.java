import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.add(s);
        }
        
        while(true){
            int l1 = pq.poll();
            if(l1 >= K){
                return answer;
            }
            if(pq.isEmpty()){
                return -1;
            }
            int l2 = pq.poll();
            
            pq.add(l1 + l2 * 2);
            answer++;
        }
        

    }
}