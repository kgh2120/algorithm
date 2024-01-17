import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static final int INIT = -1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] item;

    static int[][] dp;

    static int n;
    static int k;

    public static void main(String[] args) throws Exception {


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        item = new int[k][2];
        dp = new int[k][n+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] d : dp) {
            Arrays.fill(d, INIT);
        }

        System.out.println(knapsack(k-1, n));

    }

    static int knapsack(int index, int weight){

        if(index < 0 || weight < 0)
            return 0;

        if(dp[index][weight] != INIT)
            return dp[index][weight];

        if(weight - item[index][1] >= 0)
            return dp[index][weight] = Math.max(knapsack(index - 1, weight - item[index][1]) + item[index][0], knapsack(index - 1, weight));
        else return dp[index][weight] = knapsack(index - 1, weight);
    }



}