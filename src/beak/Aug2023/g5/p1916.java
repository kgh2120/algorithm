package beak.Aug2023.g5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    @author 김규현
    @since 2023-08-03
    @see https://www.acmicpc.net/problem/1916
    @performance 54128, 520
    @category # 최단경로 - 다익스트라
    @note
    도시가 N개가 있고, 도시에서 다른 도시로 가는 버스가 M개가 있다.
    A -> B 도시로 갈 때 버스의 비용을 최소화하려고 한다.
    최소 비용 == 최단 경로를 구하는 것으로 해석이 된다.
    버스를 타는 비용이 음수가 되지 않는다면 다익스트라 알고리즘을 사용하고,
    음수가 나오면 벨만-포드 알고리즘을 사용하면 될 것 같다.
    
    입력값에서 도시 N에 대해서는 1<= N <= 1000이 주어지고, 
    버스의수 M은 1<= M <= 100,000개가 주어진다.
    그리고 버스의 비용은 0보다 크거나 같고, 100,000보다 작은 정수라고 한다.
    
    그렇다면 가중치가 양수이니까 다익스트라 알고리즘을 이용할 수 있을 거 같다.
 
    
    사용 변수

*/
public class p1916_최소비용_구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, List<Edge>> adjMap;
    static PriorityQueue<Edge> pq;
    static int n,m;
    static int[] dist;
    static int start,end;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        adjMap = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            adjMap.put(i,new ArrayList<>());
        }
        pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost,o2.cost);
            }
        });

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjMap.get(from).add(new Edge(from,to,cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());



        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start){

        dist[start] = 0;
        pq.add(new Edge(start,0,0));
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();

            if(dist[poll.from] < poll.cost)
                continue;

            for (Edge edge : adjMap.get(poll.from)) {
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    pq.add(new Edge(edge.to,0,dist[edge.from] + edge.cost));
                }
            }
            
        }


    }
    static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }


}
