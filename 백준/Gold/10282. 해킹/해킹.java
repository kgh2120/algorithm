import java.util.*;
import java.io.*;


public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t <tc; t++){
            st = new StringTokenizer(br.readLine());
            int nOfPc = Integer.parseInt(st.nextToken());
            int nOfDependencies = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            
            Edge [] graph = new Edge[nOfPc+1];
            int[] dist = new int[nOfPc+1];
            
            for(int i = 0; i< nOfDependencies; i++){
                st = new StringTokenizer(br.readLine());
                
                int to= Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                
                graph[from] = new Edge(to,cost,graph[from]);
                
                
            }
            
            Arrays.fill(dist, 10_0000_0000);
            dist[start] = 0;
            
            Queue<Edge> pq = new PriorityQueue<>();
            
            pq.add(new Edge(start,0,null));
            
            while(!pq.isEmpty()){
                Edge current = pq.poll();
                
                if(dist[current.to] < current.cost) continue;
                
                for(Edge e = graph[current.to]; e != null; e = e.next){
                    if(dist[e.to] > e.cost + dist[current.to]){
                        dist[e.to] = e.cost + dist[current.to];
                        pq.add(new Edge(e.to, e.cost + dist[current.to], null));
                    }
                }
            }
            
            // 개수랑 숫자 세기
            int max = -1;
            int count = 0;
            for(int i = 1; i<= nOfPc; i++){
                if(dist[i] == 10_0000_0000) continue;
                max = Math.max(max, dist[i]);
                count++;
            }
            answer.append(count).append(" ").append(max).append("\n");
        }
        System.out.println(answer);
    }
    
    static class Edge implements Comparable<Edge>{
        int to;
        int cost;
        Edge next;
        public Edge(int to, int cost, Edge next){
            this.to = to;
            this.cost= cost;
            this.next = next;
        }
        
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }
    }
}
