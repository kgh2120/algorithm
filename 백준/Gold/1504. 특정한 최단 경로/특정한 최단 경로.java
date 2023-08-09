import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<List<Node>> adjList;

    static class Node{
        int f;
        int t;
        int w;

        public Node(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "f=" + f +
                    ", t=" + t +
                    ", w=" + w +
                    '}';
        }
    }

    static int[] dist;
    static PriorityQueue<Node> pq;
    static int n,v;

    static final int MAX = 8_000_000;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        adjList = new ArrayList<>(n);
        for(int i = 0; i<=n; i++)
            adjList.add(new ArrayList<>());

        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(f).add(new Node(f, t, w));
            adjList.get(t).add(new Node(t,f, w));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(1);
        int distA = dist[a];
        int distB = dist[b];


        dijkstra(a);
        int distAToB = dist[b];
        int distAToN = dist[n];
        dijkstra(b);
        int distBToA = dist[a];
        int distBToN = dist[n];
        int min = Math.min(distA + distAToB + distBToN, distB + distBToA + distAToN);
        if(min >= MAX)
            min = -1;
        System.out.println(min);


    }

    private static void dijkstra(int startNode){
        pq.clear();
        Arrays.fill(dist, MAX);
        dist[startNode] = 0;
        pq.add(new Node(startNode, 0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(dist[node.f] < node.w) continue;
            for (Node n : adjList.get(node.f)) {
                if (dist[n.t] > n.w + dist[n.f]) {
                    dist[n.t] = n.w + dist[n.f];
                    pq.add(new Node(n.t,0, dist[n.t]));
                }
            }
        }
    }

}