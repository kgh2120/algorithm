import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;


/*
    14728 벼락치기

    준석이는 바쁘다. 그래서 주어진 시간 내에 최대한 공부해서 점수를 얻고 싶다.

    그런데 어떤 조합을 공부해야 하는지 모르잖아? 쥐엔장

    대충 조합을 때려봐야 하지 않을까 싶다.

    그런데 이전에 한 것을 또 할수는 없을 껄?

    그냥 냅색 문제 같다.
 */
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Gwamok[] gwamoks;

    static int[][] dp;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        dp = new int[n][time+1];
        gwamoks = new Gwamok[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            gwamoks[i] = new Gwamok(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        Arrays.sort(gwamoks, new Comparator<Gwamok>() {
            @Override
            public int compare(Gwamok o1, Gwamok o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        System.out.println(knapsack(n-1,time));

    }

    static int knapsack(int depth, int weight){
        if(depth < 0 || weight <= 0)
            return 0;

        if(dp[depth][weight] != -1)
            return dp[depth][weight];

        Gwamok gwamok = gwamoks[depth];
        if (weight >= gwamok.cost) {
            return dp[depth][weight] = Math.max( knapsack(depth-1, weight - gwamok.cost) + gwamok.value, knapsack(depth-1, weight)  );
        }
        return dp[depth][weight] = knapsack(depth-1, weight);
    }

    static class Gwamok{
        int cost;
        int value;

        public Gwamok(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }
}