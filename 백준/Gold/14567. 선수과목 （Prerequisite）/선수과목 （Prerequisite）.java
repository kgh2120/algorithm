import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<Integer>[] adjList;
    static int[] eCount;
    static int[] hakgi;
    static int v, e;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        eCount = new int[v + 1];
        adjList = new ArrayList[v+1];
        hakgi = new int[v+1];

        for (int i = 0; i < v+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            eCount[t]++;
            adjList[f].add(t);
        }


        topologySort();


        for (int i = 1; i < v+1; i++) {
            sb.append(hakgi[i]).append(" ");
        }

        System.out.println(sb);


    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= v; i++) {
            if(eCount[i] == 0)
                q.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();

            while (size-- > 0) {
                Integer e = q.poll();
                hakgi[e] = cnt;
                for (Integer edge : adjList[e]) {
                    eCount[edge]--;
                    if(eCount[edge] == 0)
                        q.add(edge);
                }
            }


        }
    }

}