import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int v,e;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parents = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            parents[i] = i;
        }
        Edge[] edges = new Edge[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(f,t,w);
        }

        Arrays.sort(edges);

        long result = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.f, edge.t)) {
                result += edge.w;
                if(++cnt == v-1) break;
            }
        }
        System.out.println(result);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static class Edge implements Comparable<Edge>{
        int f;
        int t;
        int w;

        public Edge(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w,o.w);
        }
    }


}