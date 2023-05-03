package beak.prev.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int nOfCoin = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[nOfCoin];
        for (int i = 0; i < nOfCoin; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }


        int result = 0;
        for (int i = nOfCoin-1; i >= 0; i--) {
            int coin = coins[i];
            if(limit >= coin){
                result += limit/coin;
                limit = limit%coin;
            }
        }
        System.out.println(result);
    }


    public static void main(String []args) throws Exception {
        new P11047().solution();
    }
}





