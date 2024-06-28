import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Queue<Edge> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if(i >= j) continue;
                q.add(new Edge(i,j,weight));
            }
        }


        int count = 0;
        long sum = 0;
        while (!q.isEmpty() && count < n) {
            Edge e = q.poll();
            if (union(e.from, e.to)) {
                sum += e.weight;
                count++;
            }
        }
        System.out.println(sum);
    }

    private static boolean union(int l, int r){

        int ll = find(l);
        int rr = find(r);

        if(ll == rr) return false;
        else parents[ll] = rr;
        return true;
    }
    private static int find(int l){
        if(parents[l] == l) return l;
        return parents[l] = find(parents[l]);
    }


    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int f, int t, int w){
            from = f;
            to = t;
            weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


}