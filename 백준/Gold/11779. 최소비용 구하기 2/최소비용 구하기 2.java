import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 @author 김규현
 @since 2023-08-09
 @see https://www.acmicpc.net/problem/11779
 @performance
 @category #
 @note
 도시 N, 버스가 M개가 있다.
 A -> B로 가는 버스 비용을 최소화 하려고 한다.
 1 <= n <= 1000, 1 <= m <= 100_000

 다익스트라를 돌면서, 거리가 업데이트되면 그 값을 바꿔준다.

  **출력
 비용
 도시 개수
 도시들
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static List<List<Node>> adjList;

    static long[] dist;
    static int[] lastVisited;
    static PriorityQueue<Node> pq;

    static int n,e;
    static int start, end;


    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.w,o2.w);
            }
        });

        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(f).add(new Node(f,t,w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new long[n+1];
        lastVisited = new int[n+1];
        lastVisited[start] = start;
        Arrays.fill(dist,Long.MAX_VALUE);
        dijkstra(start,end);


        List<Integer> visited = new ArrayList<>();;
        int depth = findParent(end, visited);
        sb.append(dist[end])
                .append("\n")
                .append(depth)
                .append("\n");
        for(int i = visited.size()-1; i>=0; i--)
            sb.append(visited.get(i)).append(" ");

        System.out.println(sb);
    }
    private static int findParent(int n, List<Integer> visited){
        visited.add(n);
        if (lastVisited[n] == n) {
            return 1;
        }
        return findParent(lastVisited[n], visited) + 1;
    }

    private static void dijkstra(int start, int end){
        dist[start] = 0;
        pq.add(new Node(start,0,0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if(dist[node.f] < node.w) continue;
            for (Node n : adjList.get(node.f)) {
                if (dist[n.t] > dist[n.f] + n.w) {
                    dist[n.t] = dist[n.f] + n.w;
                    lastVisited[n.t] = n.f;
                    pq.add(new Node(n.t,0,dist[n.t]));
                }
            }
        }
    }
    static class Node{
        int f;
        int t;
        long w;

        public Node(int f, int t, long w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }
}