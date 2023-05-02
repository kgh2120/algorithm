package beak.shortestpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 벨만 포드
class P11657 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nOfCity = Integer.parseInt(st.nextToken());
        int nOfBusLine = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[nOfBusLine];
        for(int i = 0; i<nOfBusLine; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from,to,weight);
        }
        long[] dists = new long[nOfCity+1];
        Arrays.fill(dists,Long.MAX_VALUE);
        dists[1] = 0;
        boolean isMinusCycle = false;







        for (int i = 0; i < nOfCity+1; i++) {
            for (int j = 0; j < nOfBusLine; j++) {
                Edge e = edges[j];
                if(dists[e.from] == Long.MAX_VALUE)
                    continue;
                if(dists[e.to] > dists[e.from] + e.w){
                    dists[e.to] = dists[e.from] + e.w;

                    if(i==nOfCity)
                        isMinusCycle = true;
                }
            }
        }

        if (isMinusCycle) {
            System.out.print(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=nOfCity; i++){
            sb.append(dists[i] != Long.MAX_VALUE ? dists[i] : -1)
                    .append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);


    }
    class Edge{
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception{
        new P11657().solution();
    }
}