import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제한 사항 : 0.5s, 128MB
 * 문제 내용 :
 * N개의 도시에서 도시 X -> 도시 Y로 가는 M개의 버스가 있다고 한다.
 * 이 중에서 도시 A -> 도시 B로 가는 최소한의 버스 비용을 구하라고 한다.
 * 아마도 다익스트라일 가능성이 높지 않을까 싶다.
 *
 * N -> 1 <= N <= 1000
 * M -> 1 <= M <= 100_000
 * 버스 비용 C는 0 <= C <= 100_000
 * 최대 나올 수 있는 비용 : N * C => 100_000_000 / 10^8 1억 int 범위 내에서 해결 가능함.
 */

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        final int INIT = 10_0000_0000;

        Edge[] edges = new Edge[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INIT);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[from] = new Edge(to, cost, edges[from]);

        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0, null));
        dist[a] = 0 ;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(dist[edge.to] < edge.cost) continue;

            for(Edge e = edges[edge.to]; e != null; e = e.next) {
                if (dist[e.to] > e.cost + edge.cost) {
                    dist[e.to] = e.cost + edge.cost;
                    pq.add(new Edge(e.to, dist[e.to], null));
                }
            }
        }
        System.out.println(dist[b]);





    }

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;
        Edge next;

        public Edge(int to, int cost, Edge next) {
            this.to = to;
            this.cost = cost;
            this.next = next;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }


}