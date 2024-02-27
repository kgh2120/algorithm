import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nOfCandy = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nOfCandy[i] = Integer.parseInt(st.nextToken());
        }

        Edge[] edges = new Edge[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from] = new Edge(to, edges[from]);
            edges[to] = new Edge(from, edges[to]);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Edge> q = new ArrayDeque<>();
        List<Group> groups = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            int nOfChild = 1;
            int totalCandy = nOfCandy[i];
            q.add(new Edge(i, null));
            while (!q.isEmpty()) {
                Edge poll = q.poll();
                for (Edge e = edges[poll.to]; e != null; e = e.next) {
                    if(visited[e.to]) continue;
                    visited[e.to] = true;
                    q.add(new Edge(e.to, null));
                    nOfChild++;
                    totalCandy += nOfCandy[e.to];
                }
            }
            if(nOfChild < k)
                groups.add(new Group(nOfChild, totalCandy));
        }

        int[] dp = new int[k+1];
        
        for (int i = 0; i <groups.size() ; i++) {
            Group group = groups.get(i);
            for (int j = k; j >= 0 ; j--) {
                if (group.nOfChild < j) {
                    dp[j] = Math.max(dp[j], dp[j - group.nOfChild] + group.totalCandy);
                }
            }
        }
        System.out.println(dp[k]);


//        System.out.println(knapsack(dp, groups.size()-1, k, groups));
//
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }

    }

    static int knapsack(int[][]dp, int index, int k, List<Group> groups) {
        if(index < 0 || k <=0)
            return 0;

        if(dp[index][k] != -1)
            return dp[index][k];
        // 이거 채우냐 vs 안채우냐
        Group group = groups.get(index);
        int stay = knapsack(dp, index - 1, k, groups);

        int temp = 0;
        if (k > group.nOfChild) {
            temp = knapsack(dp,index-1, k - group.nOfChild, groups) +  group.totalCandy;
        }
        return dp[index][k] =  Math.max(stay, temp);
    }


    static class Edge{
        int to;
        Edge next;

        public Edge(int to, Edge next) {
            this.to = to;
            this.next = next;
        }
    }
    static class Group{
        int nOfChild;
        int totalCandy;

        public Group(int nOfChild, int totalCandy) {
            this.nOfChild = nOfChild;
            this.totalCandy = totalCandy;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "nOfChild=" + nOfChild +
                    ", totalCandy=" + totalCandy +
                    '}';
        }
    }


}