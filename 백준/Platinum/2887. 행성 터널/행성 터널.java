import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] parents;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        parents = new int[n];

        Planet[] p = new Planet[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            st = new StringTokenizer(br.readLine());
            p[i] = new Planet(i,Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        Arrays.sort(p, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.x,o2.x);
            }
        });

        for (int i = 0; i < n-1; i++) {
            edges.add(new Edge(p[i].idx,p[i+1].idx, Math.abs(p[i].x - p[i+1].x)));
        }
        Arrays.sort(p, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.y,o2.y);
            }
        });

        for (int i = 0; i < n-1; i++) {
            edges.add(new Edge(p[i].idx,p[i+1].idx, Math.abs(p[i].y - p[i+1].y)));
        }

        Arrays.sort(p, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.z,o2.z);
            }
        });

        for (int i = 0; i < n-1; i++) {
            edges.add(new Edge(p[i].idx,p[i+1].idx, Math.abs(p[i].z - p[i+1].z)));
        }

        int cnt = 0;
        int result = 0;
        while(!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (union(edge.f, edge.t)) {
                result += edge.dist;
                if(++cnt == n-1)
                    break;
            }
        }

        System.out.println(result);

    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot]  = aRoot;
        return true;

    }

    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    static class Edge implements Comparable<Edge> {
        int f;
        int t;
        int dist;

        public Edge(int f, int t, int dist) {
            this.f = f;
            this.t = t;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static class Planet{
        int idx;
        int x;
        int y;
        int z;

        public Planet(int i, int x, int y, int z) {
            this.idx = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}