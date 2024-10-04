import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works)
            pq.add(work);
        
        while(n-->0){
            int time = pq.poll();
            if(--time == 0){
                if(pq.isEmpty()) break;
                 continue;
            }
            pq.add(time);
                
        }
       
                   
        while(!pq.isEmpty()){
            int work = pq.poll();
            answer += (long) work * work;
        }
                   
                   
        return answer;
    }
}