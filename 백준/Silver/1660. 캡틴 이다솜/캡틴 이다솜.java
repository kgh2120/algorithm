import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int prev = 0;
        int i = 0;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while (prev <= n) {
            i++;
            cnt += i;
            prev += cnt;
            list.add(prev);
        }
        // 이제 시작인데..

        int[][]dp = new int[n+1][list.size()+1];

        for (int[] ints : dp) {
            Arrays.fill(ints, 10_0000_0000);
        }

        int answer = dp(dp, n, list.size(), list);
        System.out.println(answer);
    }

    static int dp(int[][]dp, int n, int i, List<Integer> list){

        if(n == 0)
            return 0;

        if(n < 0 || i == 0)
            return 10_0000_0000;

        if(dp[n][i] != 10_0000_0000)
            return dp[n][i];

        int v = list.get(i-1);

        if (n >= v) {
            // 자기 그대로 vs 1빼기 vs 안하기
            dp[n][i] = Math.min(dp[n][i],  Math.min(dp(dp,n-v,i,list), Math.min(dp(dp, n-v, i-1, list), dp(dp, n,i-1, list)))) + 1;
        }
        return dp[n][i] = Math.min(dp[n][i], dp(dp, n, i - 1, list));
    }



}