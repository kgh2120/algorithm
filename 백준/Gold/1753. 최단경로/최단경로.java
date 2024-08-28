import java.util.*;
import java.io.*;

/*
    얼핏보면 그냥 다익스트라같은데?
    정점 a, b 사이에 여러 간선이 존재할 수 있다는 점은 고려해야 할 듯 싶다.
    다익스트라 -> E log E 였나. 30만 * 20? 
*/
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static Edge [] graph;
    static int n;
    static int m;
    static int startIndex;
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist, 10_0000_0000);
        
        startIndex = Integer.parseInt(br.readLine());
        graph = new Edge[n+1];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph[from] = new Edge(to,weight,graph[from]);
        }
        
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startIndex,0,null));
        dist[startIndex] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            
            if(dist[e.to] < e.weight) continue;
            
            for(Edge next = graph[e.to]; next != null; next = next.next){
                if(dist[next.to] > next.weight + e.weight){
                    dist[next.to] = next.weight + e.weight;
                    pq.add(new Edge(next.to, dist[next.to], null));
                }
            }
        }
        
        for(int i = 1; i<=n; i++){
            String ans = dist[i] == 10_0000_0000 ? "INF" : Integer.toString(dist[i]);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    
    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        Edge next;
        public Edge(int t, int w, Edge n ){
            to = t;
            weight = w;
            next = n;
        }
        
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
}
