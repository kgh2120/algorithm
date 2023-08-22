import java.util.*;
import java.io.*;




class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<List<Node>> adjList;
    static int max;
    static int maxNode;
    static int maxDirected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
//        br = new BufferedReader(new StringReader("12\n" +
//                "1 2 3\n" +
//                "1 3 2\n" +
//                "2 4 5\n" +
//                "3 5 11\n" +
//                "3 6 9\n" +
//                "4 7 1\n" +
//                "4 8 7\n" +
//                "5 9 15\n" +
//                "5 10 4\n" +
//                "6 11 6\n" +
//                "6 12 10"));

        int n = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        max = Integer.MIN_VALUE;
        visited = new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(parent).add(new Node(t,w));
            adjList.get(t).add(new Node(parent,w));
        }

        visited[1] = true;
        findMaxNode(1,0);
//        System.out.println(max);


        Arrays.fill(visited,false);
        visited[maxNode] = true;
//        System.out.println(maxNode + " " + maxDirected);
        maxDirected = 0;
        findMaxNode(maxNode, 0);

        System.out.println(maxDirected);
    }



    private static void findMaxNode(int node, int acc){

        for (Node n : adjList.get(node)) {
            if(visited[n.v]) continue;
            visited[n.v] = true;
            findMaxNode(n.v, acc + n.w);
            visited[n.v] = false;
        }

        if (maxDirected < acc) {
            maxDirected = acc;
            maxNode = node;
        }
    }
    
    private static int comb(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i];
            for (int j = i+1; j <arr.length ; j++) {
                max = Math.max(max, temp+arr[j]);
            }
        }
        return max;
    }

    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

}