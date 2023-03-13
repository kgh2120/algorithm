package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;


class P11724 {
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nOfVertex = Integer.parseInt(st.nextToken());
        int nOfEdge = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[nOfVertex+1];
        List<LinkedList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<nOfVertex+1; i++)
            adj.add(new LinkedList<>());

        for(int i = 0; i<nOfEdge; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        bfs(nOfVertex, visited, adj);
    }

    private static void bfs(int nOfVertex, boolean[] visited, List<LinkedList<Integer>> adj){
        int count = 0;
        for(int i =1; i<= nOfVertex; i++){
            if(visited[i])
                continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                Integer k = q.poll();
                for(Integer edge : adj.get(k)){
                    if(!visited[edge]){
                        visited[edge] = true;
                        q.add(edge);
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}