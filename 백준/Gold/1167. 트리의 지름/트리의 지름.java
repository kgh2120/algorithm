import java.util.*;
import java.io.*;





class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<List<Node>> adjList;

    static boolean[] visited;
    static int max;
    static int maxNode;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        adjList = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int t;
            int w;
            while ((t = Integer.parseInt(st.nextToken())) != -1) {
                w = Integer.parseInt(st.nextToken());
                adjList.get(from).add(new Node(t,w));
//                adjList.get(t).add(new Node(from,w));
            }
        }


        visited[1] = true;
        findMax(1,0);


        Arrays.fill(visited,false);
        max = 0;
        visited[maxNode] = true;
        findMax(maxNode, 0);

        System.out.println(max);

    }

    private static void findMax(int node, int acc) {

        for (Node n : adjList.get(node)) {
            if(visited[n.t]) continue;
            visited[n.t] = true;
            findMax(n.t, acc + n.w);
//            visited[n.t] = false;
        }

        if (max < acc) {
            max = acc;
            maxNode = node;
        }

    }

    static class Node{
        int t;
        int w;

        public Node(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }
    

}