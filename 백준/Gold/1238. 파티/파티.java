import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Edge[] graph;
    static Edge[] reverseGraph;

    static int[] dist;
    static int[] reverseDist;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new Edge[n+1];
        reverseGraph = new Edge[n+1];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from] = new Edge(to, weight, graph[from]);
            reverseGraph[to] = new Edge(from, weight, reverseGraph[to]);
        }


        dist = new int[n+1];
        reverseDist = new int[n+1];

        Arrays.fill(dist, 10_0000_0000);
        Arrays.fill(reverseDist, 10_0000_0000);


        dijkstra(graph, dist, x);
        dijkstra(reverseGraph, reverseDist, x);

        int maxTime = -1;
        for(int i = 1; i<= n; i++){
            int time = dist[i] + reverseDist[i];
            if(maxTime < time){
                maxTime = time;
            }
        }
        System.out.println(maxTime);
    }

    static void dijkstra(Edge[] graph, int[] dist, int x){

        Queue<Edge> q = new PriorityQueue<>();
        dist[x] = 0;
        q.add(new Edge(x,0,null));

        while(!q.isEmpty()){
            Edge e = q.poll();

            if(dist[e.t] < e.w) continue;

            for(Edge n = graph[e.t]; n != null; n = n.next){
                if(dist[n.t] > dist[e.t] + n.w){
                    dist[n.t] = dist[e.t] + n.w;
                    q.add(new Edge(n.t, dist[n.t], null ));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int t;
        int w;
        Edge next;

        Edge(int t, int w, Edge next){
            this.t = t;
            this.w = w;
            this.next = next;
        }

        public int compareTo(Edge e){
            return Integer.compare(w, e.w);
        }
    }
}