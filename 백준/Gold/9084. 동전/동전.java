import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();

    static int[] coins;
    static int targetMoney;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        int TC = Integer.parseInt(input.readLine());

        while(TC-->0){

            int n = Integer.parseInt(input.readLine());
            coins = new int[n];
            st = new StringTokenizer(input.readLine());
            for(int i = 0; i<n; i++)
                coins[i] = Integer.parseInt(st.nextToken());
            targetMoney = Integer.parseInt(input.readLine());

            dp = new int[n][targetMoney+1];


            for(int i =0; i<n;i++)
                Arrays.fill(dp[i],-1);

            dp(n-1, targetMoney);
//            for (int[] ints : dp) {
//                System.out.println(Arrays.toString(ints));
//            }

            answer.append(dp[n-1][targetMoney]).append("\n");
        }
        System.out.print(answer.toString());
    }

    private static int dp(int index, int value){

        if(value == 0){
            return 1;
        }

        if(index < 0)
            return 0;

        if(dp[index][value] != -1){
            return dp[index][value];
        }

        int coin = coins[index];
        // value에서 coin의 배수만큼 깎아가면서 진행하기

        int count = 0;

        for(int i = 0; i * coin <= value; i++){
            count += dp(index-1, value - i*coin);
        }

        return dp[index][value] = count;
    }

}
