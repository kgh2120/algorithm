import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dp;
    static App[] apps;

    static int n, limit;
    static final int code = 1_0000_0000;
    static int min;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        dp = new int[limit+1];

//        Arrays.fill(dp, Integer.MAX_VALUE);


        st = new StringTokenizer(br.readLine());
        StringTokenizer costSt = new StringTokenizer(br.readLine());

        apps = new App[n];

        for (int i = 0; i < n; i++) {
            apps[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(costSt.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= limit; j++) {
                // 넣을 수 있는지 없는지? 넣을 수야 다 있지... limit이 넘어가면 code를 추가해야해
                int other = 0;
                if(j + apps[i].value >= limit)
                    other = code;
                else
                    other = dp[j+apps[i].value];
                dp[j] = Math.max(dp[j], other - apps[i].cost);
            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(code - dp[0] );


    }



    static class App implements Comparable<App>{
        int value;
        int cost;

        public App(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public int compareTo(App o) {
            // value/cost가 높은 것. if cost가 0 이면 무적권 -1
            // v/c가 같다면 c가 낮은 애
            if (cost == 0)
                return -1;
            if(o.cost == 0)
                return 1;
            double vc = value/cost;
            double ovc = o.value / o.cost;

            if (vc == ovc) {
                return Integer.compare(cost,o.cost);
            }
            return Double.compare(vc,ovc) * -1;
        }

        @Override
        public String toString() {
            return "App{" +
                    "value=" + value +
                    ", cost=" + cost +
                    '}';
        }
    }



}