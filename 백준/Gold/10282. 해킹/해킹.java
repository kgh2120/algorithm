import java.util.*;
import java.io.*;

public class Main {

    static public void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int T = 0; T < TC; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numberOfPC = Integer.parseInt(st.nextToken());
            int numberOfDependencies = Integer.parseInt(st.nextToken());
            int targetPC = Integer.parseInt(st.nextToken());

            Edge[] graph = new Edge[numberOfPC+1];

            boolean[] visited = new boolean[numberOfPC+1];

            for(int i = 0; i< numberOfDependencies; i++){
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[from] = new Edge(to,weight, graph[from]);
            }

            prim(graph, visited, targetPC, sb);
        }

        System.out.print(sb);

    }

    static void prim(Edge[] graph, boolean[] visited, int targetPC, StringBuilder sb){
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(targetPC, 0, null));

        int npc = 0;
        int costTime = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(visited[e.to]) continue;
            visited[e.to] = true;
            npc++;
            costTime = Math.max(costTime, e.weight);

            for(Edge edge = graph[e.to]; edge != null; edge = edge.next){
                if(visited[edge.to]) continue;
                pq.add(new Edge(edge.to, costTime + edge.weight , null));
            }
        }

        sb.append(npc).append(" ").append(costTime).append("\n");


    }

    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        Edge next;

        public Edge(int t, int w, Edge e){
            to = t;
            weight = w;
            next = e;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(weight, o.weight);
        }
    }

}