import java.util.*;
import java.io.*;




/*
    author : 규현
    date : 2023-08-22
    url : https://www.acmicpc.net/problem/13023
    performance :
    category :
    note:

    서로서로 친구인 사람들이 있다.
    이 친구들을 연결해서 5명을 만들어서 5인큐를 돌리는 게 목적이다.

    사람의 수와 친구 관계의 수가 주어지고, 이를 통해 연결을 하면 될 듯 싶다.
    친구는 서로 친구인 거니까 양방향 그래프를 뜻하는 것 같다.

*/
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<Node>[] adjList;
    static int n,m;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(a,b));
            adjList[b].add(new Node(b,a));
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i,0);
            visited[i] = false;
        }

        System.out.println(flag?1:0);



    }

    private static void dfs(int node, int cnt) {
        if (cnt == 4) {
            flag = true;
            return;
        }
        for (Node n : adjList[node]) {
            if(visited[n.t]) continue;
            visited[n.t] = true;
            dfs(n.t,cnt+1);
            if(flag)
                return;
            visited[n.t] = false;
        }
    }

    static class Node{
        int f,t;

        public Node(int f, int t) {
            this.f = f;
            this.t = t;
        }
    }


}