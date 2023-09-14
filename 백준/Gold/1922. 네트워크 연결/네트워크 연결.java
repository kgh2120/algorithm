import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parents;

    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }
//        edges = new Edge[m];
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(f == t) continue;
            edges.add(new Edge(f,t,w)) ;
        }

        Collections.sort(edges);

        int cnt = 0;
        long cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (union(edge.from, edge.to)) {
                cost += edge.w;
                if (++cnt == n - 1) {
                    break;
                }
            }
        }
        System.out.println(cost);

    }

    private static boolean union(int l, int r) {
        int lp = find(l);
        int rp = find(r);
        if(lp == rp ) return false;

        parents[lp] = rp;
        return true;
    }

    private static int find(int i) {
        if(i == parents[i]) return i;
        return parents[i] = find(parents[i]);
    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w,o.w);
        }
    }
}