package beak.dp;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 돌놓기와 같은 패턴의 문제.
 * 놓을 수 있는 패턴을 한정짓고 각 패턴별로 어떤 값이 가장 (최대, 최소)인지를 판별하는 문제.
 * 그간 튜닝했던 식에서 !=0이면 즉시 리턴이 별로 의미 없는 줄 알았는데,
 * 꽤나 의미가 있었던 모양이다.
 */
public class p1149 {




    int[][] pattern = {
            {1,2},
            {0,2},
            {0,1}
    };

    long[][]m;
    long[][]dp;
    public static void main(String []args) throws Exception {
        new p1149().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        m = new long[n][3];
        dp =new long[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int k = Integer.parseInt(st.nextToken());
                m[i][j]=k;
            }
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(r(n-1,i),min);
        }
        System.out.println(min);
    }

    public long r(int level, int me) {
        if(dp[level][me]!=0)
            return dp[level][me];

        if (level == 1) {
            return dp[level][me] = m[level][me]+ Math.min(m[level-1][selectColor(me,0)],m[level-1][selectColor(me,1)]);
        }
        return dp[level][me] = m[level][me] + Math.min(r(level-1,selectColor(me,0)),r(level-1,selectColor(me,1)));
    }

    public int selectColor(int prev, int color){
        return pattern[prev][color];
    }




}