import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {


    List<LinkedList<Edge>> adjacent = new ArrayList<>();
    int[]d;
    HashSet<Integer> s = new HashSet<>();
    HashSet<Integer> v = new HashSet<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nOfV = Integer.parseInt(st.nextToken());
        int nOfE = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());
        d = new int[nOfV+1];

        for (int i = 0; i <= nOfV; i++) {
            adjacent.add(new LinkedList<>());
            if(i>=1)
                v.add(i);
        }
        for (int i = 0; i < nOfE; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjacent.get(f).add(new Edge(f,t,w));
        }


        dijkstra(startNode);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <=nOfV ; i++) {
            String dis = d[i] == 9999 ? "INF" : String.valueOf(d[i]);
            sb.append(dis).append("\n");
        }
        System.out.println(sb);

    }

    public void dijkstra(int startNode){
        Arrays.fill(d,9999);
        d[startNode] = 0;
        HashSet<Integer> ds = new HashSet<>(v);
        while (s.size() != v.size()) {
            Integer integer = extractMin(ds);
            s.add(integer);
            ds.remove(integer);

            // 인접한 애들 가져오기
            LinkedList<Edge> edges = adjacent.get(integer); // L(U)
            for (Edge edge : edges) {
                if (ds.contains(edge.to) && d[integer] + edge.weight < d[edge.to]) {
                    d[edge.to] = d[integer] + edge.weight;
                }
            }
        }
    }
    private Integer extractMin(HashSet<Integer> ds){
        int min = 9999;
        int index = 0;
        for (Integer integer : ds) {
            if (min > d[integer]) {
                min = d[integer];
                index = integer;
            }
        }
        return index;
    }

    class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }



    public static void main(String[] args) throws Exception {

        new Main2().solution();
    }

}
