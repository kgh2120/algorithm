import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Edge[] edges;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        edges = new Edge[n];
        Queue<Edge> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                edges[i] = new Edge(i,j,weight, edges[i]);
            }
        }

        boolean[] visited = new boolean[n];
        q.add(new Edge(0, 0, 0, null));

        long sum = 0;
        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if(visited[poll.from]) continue;
            sum += poll.weight;
            visited[poll.from] = true;

            for(Edge e = edges[poll.from]; e != null; e = e.next) {
                if(visited[e.to]) continue;
                q.add(new Edge(e.to, 0, e.weight, null));
            }
        }
        System.out.println(sum);
    }




    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge next;

        public Edge(int f, int t, int w, Edge n){
            from = f;
            to = t;
            weight = w;
            next = n;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


}