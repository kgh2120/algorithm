import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 :
    @입력 범위 :
    @문제 내용 :
    @주의 사항 :
    @예상 알고리즘 :
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Edge[] graph = new Edge[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to =  Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Edge(to, weight, graph[from]);

        }
        int [] dist = new int[n+1];
        int [] path = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0, null));
        dist[a] = 0;
        path[a] = -1;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(dist[edge.to] < edge.weight) continue;

            for(Edge e = graph[edge.to]; e != null; e = e.next) {
                if(dist[e.to] > dist[edge.to] + e.weight) {
                    dist[e.to] = dist[edge.to] + e.weight;
                    path[e.to] = edge.to;
                    pq.add(new Edge(e.to, dist[e.to], null));
                }
            }
        }

        sb.append(dist[b]).append("\n");


        int k = path[b];
        Deque<Integer> route = new ArrayDeque<>();
        route.addFirst(b);
        while (k != -1) {
            route.addFirst(k);
            k = path[k];
        }
        sb.append(route.size()).append("\n");
        while(!route.isEmpty()) {
            Integer r = route.pollFirst();
            sb.append(r).append(" ");
        }

        System.out.println(sb);

    }

    static class Edge implements Comparable<Edge> {
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
            return Integer.compare(this.weight, o.weight);
        }
    }


}