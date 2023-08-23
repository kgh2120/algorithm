import java.util.*;
import java.io.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int [] peoples;
    static List<List<Integer>> adjList;
//    static boolean [] selected;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        peoples = new int[n+1];
//        selected = new boolean[n+1];
        visited = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }
        adjList = new ArrayList<>();
        for (int i = 0; i <n+1 ; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                adjList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        makeSubset(1, new boolean[n+1]);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    private static void makeSubset(int cnt, boolean[] selected ){
        if (cnt == n+1) {

            Arrays.fill(visited,false);
            int t = bfs(selected, true);
            int f = bfs(selected, false);

            if (isAllConnected()) {
                if(t == -1 || f == -1) return;
                min = Math.min(min,Math.abs(t-f));
            }
            return;
        }

        selected[cnt] = true;
        makeSubset(cnt+1, selected);
        selected[cnt] = false;
        makeSubset(cnt+1, selected);

    }

    private static boolean isAllConnected(){
        for (int i = 1; i <= n ; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
    private static int bfs(boolean[] selected, boolean flag){
        int sum = 0;
        int first = findFirst(selected, flag);
        if(first == -1) return -1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(first);
        visited[first] = true;
        sum += peoples[first];
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : adjList.get(poll)) {
                if(visited[i] || selected[i] != flag) continue;
                visited[i] = true;
                q.add(i);
                sum += peoples[i];
            }
        }
        return sum;
    }

    private static int findFirst(boolean[] selected, boolean flag) {
        for (int i = 1; i <= n ; i++) {
            if(selected[i] == flag) return i;
        }
        return -1;
    }
}