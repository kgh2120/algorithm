import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Edge[] graph;

    static StringTokenizer st;
    static int s;
    static int t;

    static int[] dist;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Edge[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, 10_0000_0000);



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[f] = new Edge(f,t,w,graph[f]);
            graph[t] = new Edge(t,f,w,graph[t]);
        }



        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());


        dijkstra(s);

        System.out.println(dist[t]);


    }

    private static void dijkstra(int s) {
        Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        dist[s] = 0;
        pq.add(new Edge(s, 0, 0, null));

        while (!pq.isEmpty()) {

            Edge e = pq.poll();

            if(dist[e.f] < e.w) continue;

            for (Edge next = graph[e.f]; next != null; next = next.next) {
                if (dist[next.t] > e.w + next.w) {
                    dist[next.t]  = e.w + next.w;
                    pq.add(new Edge(next.t, 0, e.w + next.w, null));
                }
            }
        }
    }






    static class Edge {

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