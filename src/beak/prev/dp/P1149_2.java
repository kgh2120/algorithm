package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149_2 {
    
    int [][] price;
    int nOfHouse;
    int [][] memo;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nOfHouse = Integer.parseInt(br.readLine());
        price = new int[nOfHouse][3];
        memo =  new int[nOfHouse][3];

        for (int i = 0; i < nOfHouse; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                price[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            memo[0][i] = price[0][i];
        }

        getMinPrice();

    }

    public void getMinPrice(){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int m = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if(i==j)
                    continue;
                m = Math.min(m, dp(j,price.length-2));
            }
            min = Math.min(min, price[price.length-1][i] + m);
        }
        System.out.println(min);
    }

    public int dp(int cur, int n) {
        if(memo[n][cur] != 0)
            return memo[n][cur];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i == cur)
                continue;
            min = Math.min(min,dp(i,n-1) + price[n][cur]);
        }
        return memo[n][cur] = min;
    }




    public static void main(String[] args) throws Exception {
        new P1149_2().solution();
    }

}
