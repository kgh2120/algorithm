package beak.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {


    List<List<Edge>> adjacentList;
    int[]dist;
    int startVertex;
    int nOfVertex;
    public void solution() throws Exception{
        setVariable();
        dijkstra();
        printAnswer();

    }

    private void printAnswer(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<= nOfVertex; i++)
            sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF")
                    .append("\n");
        System.out.println(sb.toString());
    }

    private void dijkstra(){
        dist[startVertex] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });

        pq.add(new Edge(startVertex,0,0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(dist[e.from] < e.w)
                continue;

            for(Edge adj : adjacentList.get(e.from)){
                if(dist[adj.to] > dist[e.from] + adj.w){
                    dist[adj.to] = dist[e.from] + adj.w;
                    pq.add(new Edge(adj.to,0,dist[adj.to]));
                }
            }
        }
    }

    private void setVariable() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nOfVertex = Integer.parseInt(st.nextToken());
        int nOfEdge = Integer.parseInt(st.nextToken());
        dist = new int[nOfVertex+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        startVertex = Integer.parseInt(br.readLine());

        adjacentList = new ArrayList<>();
        for (int i = 0; i <= nOfVertex; i++)
            adjacentList.add(new ArrayList<>());

        for(int i = 0; i<nOfEdge; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            adjacentList.get(from).add(new Edge(from, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
    }

    class Edge{
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }





    public static void main(String[] args) throws Exception{
        new P1753().solution();
    }
}