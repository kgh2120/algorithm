package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍, 골드 5
 * LCS (최장 공통 수열) 문제.
 * 다른 문제들과 마찬가지로 점화식을 그린다면 쉽게 풀 수 있다고들 한다..
 * 점화식 그리는게 문제 아닌가?
 */
public class P9251 {

    Integer[][] memo;

    String a;
    String b;
    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        memo = new Integer[a.length()][b.length()];

        dp(a.length()-1,b.length()-1);
        System.out.println(memo[a.length()-1][b.length()-1]);
    }

    public int dp(int i, int j){
        if(i < 0 || j < 0)
            return 0;

        if (memo[i][j] == null) {
            if (a.charAt(i) == b.charAt(j)) {
                memo[i][j] = 1 + dp(i-1,j-1);
            }else{
                memo[i][j] = Math.max(dp(i-1,j), dp(i,j-1));
            }
        }
        return memo[i][j];
    }


    public static void main(String[] args) throws Exception {
        new P9251().solution();
    }

}
