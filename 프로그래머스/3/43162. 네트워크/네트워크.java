import java.util.*;

class Solution {
    

    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        
        for(int i = 0; i< n; i++){
            
            if(visited[i]) continue;
            answer++;
            
            // 이제 돌기
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            visited[i] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                
                for(int j = 0; j< n; j++){
                    if(computers[cur][j] == 0 || visited[j]) continue;
                    visited[j] = true;
                    q.add(j);
                }
                
            }
            
        }
        
        
        
        
        return answer;
    }
    
    
}