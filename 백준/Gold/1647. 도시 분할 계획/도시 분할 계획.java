import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] parents;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());



        Edge[] kruskal = new Edge[m];

        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            kruskal[i] = new Edge(from, to, cost);
        }

        Arrays.sort(kruskal);


        int i = 0;
        int tree = 0;
        int totalCost = 0;
        int max = -1;
        while (i < m) {
            Edge edge = kruskal[i++];
            if (union(edge.from, edge.to)) {
                totalCost += edge.cost;
                max = Math.max(max, edge.cost);
                if (++tree == n - 1) {
                    break;
                }
            }
        }
        System.out.println(totalCost - max);
        





    }

    static boolean union(int a, int b){

        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            return false;
        }
        parents[fa] = fb;
        return true;
    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }



}