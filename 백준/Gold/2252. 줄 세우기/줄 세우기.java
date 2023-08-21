import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<List<Edge>> adjList;
    static int[] eCount;
    static int v, e;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        eCount = new int[v + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            eCount[t]++;
            adjList.get(f).add(new Edge(f, t));
        }
        topologySort();

        System.out.println(sb);


    }

    private static void topologySort() {
        Queue<Edge> q = new ArrayDeque<>();
        for (int i = 1; i <= v; i++) {
            if(eCount[i] == 0)
                q.add(new Edge(i,0));
        }

        while (!q.isEmpty()) {
            Edge e = q.poll();
            sb.append(e.f).append(" ");

            for (Edge edge : adjList.get(e.f)) {
                eCount[edge.t]--;
                if(eCount[edge.t] == 0)
                    q.add(new Edge(edge.t,0));
            }

        }
    }


    static class Edge {
        int f;
        int t;

        public Edge(int f, int t) {
            this.f = f;
            this.t = t;
        }
    }
}