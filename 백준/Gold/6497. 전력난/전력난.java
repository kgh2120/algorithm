import java.util.*;
import java.io.*;





class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static Edge[] edges;
    static int v,e;
    static int[] parents;
    public static void main(String[] args) throws Exception {

        while (true) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            if(v == 0 && e == 0)
                break;
            edges = new Edge[e];
            parents = new int[v];
            for (int i = 0; i < v; i++) {
                parents[i] = i;
            }
            int cost  = 0;
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(f,t,w);
                cost+=w;
            }
            Arrays.sort(edges);

            int save = 0;
            int idx = 0;
            for (Edge edge : edges) {
                if (union(edge.f, edge.t)) {
                    save += edge.w;
                    if(++idx == v)
                        break;
                }
            }
            sb.append(cost-save)
                    .append(System.lineSeparator());

        }

        System.out.println(sb);
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