import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Star[] stars;

    static int[] parents;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        stars = new Star[n];
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);
            parents[i] = i;
        }




        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                pq.add(new Edge(i,j,Math.sqrt( Math.pow(stars[i].x - stars[j].x,2) + Math.pow(stars[i].y - stars[j].y,2) )));
            }
        }


        double total = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.from, edge.to)) {
                total += edge.dist;
                if(++cnt == n-1)
                    break;
            }
        }

        int f = (int) (total * 100);
        double last = (double) f / 100;
        System.out.println(last);

    }

    private static int find(int n) {
        if(n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    private static boolean union(int l, int r) {
        int lp = find(l);
        int rp = find(r);

        if(lp == rp) return false;
        parents[lp] = rp;
        return true;
    }

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        double dist;

        public Edge(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;

        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(dist,o.dist);
        }
    }


}