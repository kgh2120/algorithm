import java.util.*;

class Solution {
    

    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean [] visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            bfs(computers, visited, i);
            answer++;
        }
        
        
        return answer;
    }
    
    private void bfs(int[][] computers, boolean[] visited, int cur){
        
        Queue<Integer> q = new ArrayDeque<>();
        visited[cur] = true;
        
        q.add(cur);
        
        while(!q.isEmpty()){
            int comp = q.poll();
            
            
            for(int idx = 0; idx < computers.length; idx++){
                
            
                
                    
                if(idx == comp || computers[comp][idx] == 0 || visited[idx]) continue;
                visited[idx] = true;
                q.add(idx);
            }
            
        }
        
    }
    
    
}