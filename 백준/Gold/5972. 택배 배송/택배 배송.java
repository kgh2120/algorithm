import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int n;
    static int m;
    static Edge[] edges;

    static int[] dist;

    static final int INF = 10_0000_0000;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new Edge[n+1];
        dist = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[f] = new Edge(f, t, w, edges[f]);
            edges[t] = new Edge(t, f, w, edges[t]);
        }
        Arrays.fill(dist, INF);


        dijkstra();

        System.out.println(dist[n]);
    }


    static void dijkstra(){
        Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        pq.add(new Edge(1, 0, 0, null));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(dist[edge.f] < edge.w) continue;

            for (Edge e = edges[edge.f]; e != null; e = e.next) {

                if (dist[e.t] > dist[e.f] + e.w) {
                    dist[e.t] = dist[e.f] + e.w;
                    pq.add(new Edge(e.t, 0, dist[e.t], null));
                }
            }
        }
    }



    static class Edge{
        int f;
        int t;
        int w;

        Edge next;

        public Edge(int f, int t, int w, Edge next) {
            this.f = f;
            this.t = t;
            this.w = w;
            this.next = next;
        }
    }



}