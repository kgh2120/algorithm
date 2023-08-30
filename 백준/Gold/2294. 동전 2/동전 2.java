import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int INF = 10_0000_0000;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int nOfCoin = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int[] dp = new int[money+1];
        int[] coins = new int[nOfCoin];
        for (int i = 0; i < nOfCoin; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= money ; i++) {
            for (int coin : coins) {
                if(i >= coin)
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        System.out.println(dp[money] != INF ? dp[money] : -1);



    }


}