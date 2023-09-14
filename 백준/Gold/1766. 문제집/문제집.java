import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] counts;
    static PriorityQueue<Integer> pq;
    static int n;
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new Node[n+1];
        int m = Integer.parseInt(st.nextToken());
        counts = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to,graph[from]);
            counts[to]++;
        }

        pq = new PriorityQueue<>();
        for (int i = 1; i < n + 1; i++) {
            if(counts[i] == 0)
                pq.add(i);
        }
        topologySort();
        System.out.println(sb);
    }

    private static void topologySort(){
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            sb.append(poll).append(" ");
            for (Node node = graph[poll]; node != null; node = node.next) {
                if(--counts[node.to] == 0)
                    pq.add(node.to);
            }
        }
    }

    static class Node{
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }


}