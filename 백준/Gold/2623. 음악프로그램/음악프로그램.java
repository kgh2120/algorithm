import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Graph graph;

    static int[] childCount;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        graph = new Graph(size);
        childCount = new int[size+1];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int listSize = Integer.parseInt(st.nextToken());

            if(listSize <= 1)
                continue;

            int from = Integer.parseInt(st.nextToken());
            for(int j = 1; j<listSize; j++){
                int to = Integer.parseInt(st.nextToken());
                graph.addEdge(from,to);
                childCount[to]++;
                from = to;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1; i<= size; i++){
            if(childCount[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int poll = q.poll();
            sb.append(poll).append("\n");

            for(Edge e = graph.getEdge(poll); e != null; e = e.next){
                if(--childCount[e.to] == 0){
                    q.add(e.to);
                }
            }
        }
        
        for(int i = 1; i<= size; i++)
            if(childCount[i] != 0){
                System.out.println(0);
                return;
            }
        
        System.out.println(sb);
    }

    static class Graph{

        Edge [] edges;

        public Graph(int size){
            edges = new Edge[size+1];
        }

        public void addEdge(int from, int to){
            edges[from] = new Edge(to, edges[from]);
        }

        public Edge getEdge(int from){
            return edges[from];
        }

    }

    static class Edge{
        int to;
        Edge next;

        public Edge(int to, Edge next){
            this.to = to;
            this.next = next;
        }
    }
}