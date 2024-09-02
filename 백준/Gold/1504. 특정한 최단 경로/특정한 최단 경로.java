import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int INF = 10_0000_0000;
    static int n;
    static Edge[] edges;
    static Map<Integer, int[]> records;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new Edge[n+1];
        records = new HashMap<>();





        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[f] = new Edge(t, w, edges[f]);
            edges[t] = new Edge(f, w, edges[t]);

        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());



        // 다익스트라 1->a, a->b, b->n
        long ansA = (long) dijkstra(1, a) + dijkstra(a, b) + dijkstra(b, n);
        long ansB = (long) dijkstra(1, b) + dijkstra(b, a) + dijkstra(a, n);

        long ans = 0L;
        if(ansA >= INF && ansB >= INF)
            ans = -1;
        else if(ansA < INF && ansB < INF)
            ans = Math.min(ansA, ansB);
        else if(ansA >= INF)
            ans = ansB;
        else ans = ansA;

        System.out.println(ans);


    }

    static int dijkstra(int start, int end){
        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0, null));

        int[] dist = records.get(start);
        if (dist != null) {
            return dist[end];
        }
        dist = new int[n + 1];
        records.put(start, dist);
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!q.isEmpty()){
            Edge edge = q.poll();

            if(dist[edge.to] < edge.weight) continue;

            for (Edge e = edges[edge.to]; e != null; e = e.next) {
                if(dist[e.to] > dist[edge.to] + e.weight){
                    dist[e.to] = dist[edge.to] + e.weight;
                    q.add(new Edge(e.to, dist[e.to], null));
                }
            }
        }

        return dist[end];
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
        public int compareTo(Edge o){
            return Integer.compare(weight, o.weight);
        }

    }

}