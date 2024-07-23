import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Edge[] graph;
    static int[] dist;
    static final int INF = 10_0000_0000;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new Edge[v + 1];
        dist = new int[v + 1];



        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weg = Integer.parseInt(st.nextToken());

            graph[from] = new Edge(to, weg, graph[from]);
        }

        for (int i = 1; i <= v ; i++) {
            Arrays.fill(dist, INF);
            dijkstra(i);
            min = Math.min(min, dist[i]);
        }

        System.out.println(min == INF? -1 : min );



    }

    static void dijkstra(int index){

        Queue<Edge> pq = new PriorityQueue<>();
//        dist[index] = 0;
        pq.add(new Edge(index, 0, null));



        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(dist[edge.to] < edge.weight) continue;

            for(Edge e = graph[edge.to]; e != null; e = e.next){

//                if (e.to == index) {
//                    return edge.weight + e.weight;
//                }

                if (dist[e.to] > edge.weight + e.weight) {
                    dist[e.to] = edge.weight + e.weight;
                    pq.add(new Edge(e.to, dist[e.to], null));
                }
            }
        }



    }

    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        Edge next;

        public Edge(int to, int weight, Edge next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }


}