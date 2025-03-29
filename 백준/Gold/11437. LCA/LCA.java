import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    static Node [] tree;
    static boolean[] visited;
    static int[] depth;
    static int[] parents;


    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        visited = new boolean[n+1];
        depth = new int[n+1];
        parents = new int[n+1];
    

        int t = n-1;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a] = new Node(b, tree[a]);
            tree[b] = new Node(a, tree[b]);
        }

        visited[1] = true;
        dfs(1, 0 , 1);


        int k = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 높이 조절

            while(depth[a] > depth[b]) {
                a = parents[a];
            } 
            while (depth[b] > depth[a]) {
               b = parents[b];
            }

            // 이제 레벨 맞췄으니까 비교하기

            while (a != b) {
                a = parents[a];
                b = parents[b];
            }
            answer.append(a).append("\n");
        }
        System.out.print(answer);

    }

    private static void dfs(int index, int parent, int d){
        depth[index] = d;
        parents[index] = parent;
        for(Node n = tree[index]; n != null; n = n.next){
            if (!visited[n.to]) {
                visited[n.to] = true;
                dfs(n.to, index, d+1);
                visited[n.to] = false;
            }
        }
    }

    static class Node{
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }



}
