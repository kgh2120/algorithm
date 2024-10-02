import java.util.*;
class Solution {
    
    Edge[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new Edge[n+1];
        
        for(int[] e : edge){
            int f = e[0];
            int t = e[1];
            graph[f] = new Edge(t,graph[f]);
            graph[t] = new Edge(f,graph[t]);
        }
        
        
        boolean [] visited = new boolean[n+1];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        
        
        while(!q.isEmpty()){
            int queueSize = q.size();
            answer = queueSize;
            
            while(queueSize-->0){
                 Integer vertex = q.poll();
            
                for(Edge adjcentVertex = graph[vertex]; adjcentVertex != null; adjcentVertex = adjcentVertex.next){
                    if(visited[adjcentVertex.to]) continue;
                    visited[adjcentVertex.to] = true;
                    q.add(adjcentVertex.to);
                }
            }
            
           
        }
        
        
        return answer;
    }
    
    static class Edge{
        int to;
        Edge next;
        
        public Edge (int to, Edge next){
            this.to = to;
            this.next = next;
        }
    }
    
}