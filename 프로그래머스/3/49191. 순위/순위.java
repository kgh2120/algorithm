import java.util.*;

class Solution {
    
    // big,small은 index 보다 순위가 큰, 작은 애들, 즉 big은 index한테 이긴 애, small은 index한테 진 애들
    Edge[] big;
    Edge [] small;
    boolean[] visited;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        big = new Edge[n+1];
        small = new Edge[n+1];
        visited = new boolean[n+1];
        
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            
            small[win] = new Edge(lose, small[win]);
            big[lose] = new Edge(win, big[lose]);
        }
        
        // index마다 bfs를 돌아서 그 개수를 체크한다.
        
        for(int i =1; i<=n; i++){
            visited = new boolean[n+1];
            int count = 0 ;
            count+= bfs(i, big);
            count+= bfs(i,small);
            
            if(count == n-1)
                answer++;
        }
        
        
        
        return answer;
    }
    
    private int bfs(int idx, Edge[] graph){
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);
        
        int cnt = 0;
        while(!q.isEmpty()){
            Integer poll = q.poll();
            
            for(Edge e = graph[poll]; e != null; e = e.next){
                if(visited[e.value]) continue;
                visited[e.value] = true;
                q.add(e.value);
                cnt++;
            }
            
        }
        
        return cnt;
    }
    
    
    static class Edge {
        
        int value;
        Edge next;
        public Edge(int value, Edge next){
            this.value = value;
            this.next = next;
        }
        
    }
}