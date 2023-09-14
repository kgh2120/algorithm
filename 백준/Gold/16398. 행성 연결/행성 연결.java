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

        parents = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                list.add(new Edge(i,j,cost));
            }
        }

        Collections.sort(list);

//        System.out.println(list);
        long total = 0;
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (union(e.from, e.to)) {
                total += e.w;
                if (++cnt == n - 1) {
                    break;
                }
            }
        }
        System.out.println(total);


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

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", w=" + w +
                    '}';
        }
    }
}