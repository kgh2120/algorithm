import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<List<Node>> adjList;

    static int n,m,x;

    static int[] xToTown;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        xToTown = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(from).add(new Node(from, to, w));
        }

        dijkstra();

        int result = -100;
        for (int i = 1; i <= n; i++) {
            if(i == x) continue;
          result = Math.max(result, xToTown[i] + dijkstra(i));

        }
        System.out.println(result);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        Arrays.fill(xToTown,Integer.MAX_VALUE);
        xToTown[x] = 0;
        pq.add(new Node(x,0,0));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if(xToTown[n.from] < n.w) continue;;
            for (Node adj : adjList.get(n.from)) {
                if(xToTown[adj.to] > adj.w + xToTown[adj.from]){
                    xToTown[adj.to] = adj.w + xToTown[adj.from];
                    pq.add(new Node(adj.to,0,xToTown[adj.to]));
                }
            }
        }
    }

    private static int dijkstra(int startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        int[]distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[startNode] = 0;
        pq.add(new Node(startNode,0,0));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if(distance[n.from] < n.w) continue;;
            for (Node adj : adjList.get(n.from)) {
                if(distance[adj.to] > adj.w + distance[adj.from]){
                    distance[adj.to] = adj.w + distance[adj.from];
                    pq.add(new Node(adj.to,0,distance[adj.to]));
                }
            }

        }
        return distance[x];
    }

    static class Node{
        int from;
        int to;
        int w;

        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }


}