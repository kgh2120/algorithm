import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Node[] graph;
    static int[] items;
    static int n;
    static int m;
    static int r;
    static int[] dist;
    static final int INF = 10_0000_0000;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n + 1];
        graph = new Node[n+1];
        dist = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from] = new Node(to, dist, graph[from]);
            graph[to] = new Node(from, dist, graph[to]);
        }

        int max = -1;
        for (int i = 1; i <= n ; i++) {
            Arrays.fill(dist, INF);
            dist[i] = 0;
            int dijkstra = dijkstra(i);
            max = Math.max(max, dijkstra);
        }


        System.out.println(max);
    }

    static int dijkstra(int startNode) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0, null));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if(dist[node.to] < node.w) continue;

            for (Node n = graph[node.to]; n != null; n = n.next) {
                if (dist[n.to] > dist[node.to] + n.w && dist[node.to] + n.w <= m) {
                    dist[n.to] = dist[node.to] + n.w;
                    pq.add(new Node(n.to, dist[n.to], null));
                }
            }
        }

        int score = 0;
        for (int i = 1; i <= n ; i++) {
            int value = dist[i];
            if (value <= m) {
                score += items[i];
            }
        }
        return score;
    }

    static class Node implements Comparable<Node>{
        int to;
        int w;
        Node next;

        public Node(int to, int w, Node next) {
            this.to = to;
            this.w = w;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
}