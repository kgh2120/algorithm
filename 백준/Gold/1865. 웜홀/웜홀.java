import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[(M << 1) + W];
            for (int i = 0, idx = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(S, E, T);
                edges[idx++] = new Edge(E, S, T);
            }

            for (int i = 0, idx = M << 1; i < W; ++i) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(S, E, -T);
            }
            boolean negativeCycle = bellmanFord(N, M, edges, 1);
            sb.append(negativeCycle ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static boolean bellmanFord(int v, int e, Edge[] edges, int start) {
        long[] distance = new long[v + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 0; i < v; ++i) {
            boolean update = false;
            for (Edge edge: edges) {
                if (distance[edge.e] > distance[edge.s] + edge.time) {
                    distance[edge.e] = distance[edge.s] + edge.time;
                    update = true;
                }
            }

            if (i == v - 1 && update) {
                return true;
            }
        }
        return false;
    }

    private static class Edge {
        int s, e, time;

        Edge(int s, int e, int time) {
            this.s = s;
            this.e = e;
            this.time = time;
        }
    }
}