import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요

        int n = Integer.parseInt(input.readLine());

        map = new int[n][3];
        dp = new int[3][n][3];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            answer = Math.min(answer, dp(n-1, i, i));
        }

        System.out.println(answer);

    }

    static int dp(int depth, int selected, int firstSelected){
        if(depth == 0){
            if(selected == firstSelected)
                return Integer.MAX_VALUE;
            else return map[0][selected];
        }

        if(dp[firstSelected][depth][selected] != 0)
            return dp[firstSelected][depth][selected];

        // 굴리기

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<3; i++){
            if(i == selected) continue;
            min = Math.min(min, dp(depth-1, i, firstSelected));
        }

        return dp[firstSelected][depth][selected] = map[depth][selected] + min;
    }
}
