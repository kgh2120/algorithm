package beak.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 서로의 시너지 값을 구하는 문제.
 * 전체를 루핑돌아야 할 것 같지만, 순서가 상관 없고, 절반만 구해도 되서
 * 해당 부분을 고려해야 시간 내에 풀 수 있었던 거 같기도 하고..
 *
 */
public class p14889 {



    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        int loop = n/2;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
            int[] team = new int[loop];
            Arrays.fill(team,-1);
            looping(0,loop,matrix,team,0);
            System.out.println(min);


    }

    public static void looping(int level, int end, int[][]matrix, int[]team, int prev) {
        if (level == end) {
            // 계산
            int compute = compute(team, end, matrix);
            // 최소값 구하기
            min = Math.min(min,compute);
            return;
        }

        for (int i = prev; i < end*2; i++) {

            team[level] = i;
            looping(level+1,end,matrix,team,i+1);
            team[level] = -1;
        }
    }

    public static int compute(int[]team, int loop, int[][]matrix) {
        int scoreStart = 0;
        int scoreLink = 0;

        int[] teamL = createLinkTeam(team,loop);

        for (int i = 0; i < loop; i++) {
            int si = team[i];
            int li = teamL[i];
            for (int j = 0; j < loop; j++) {
                int sj = team[j];
                int lj = teamL[j];

                scoreStart += matrix[si][sj];
                scoreLink += matrix[li][lj];
            }

        }

        return Math.abs(scoreStart-scoreLink);

    }



    private static int[] createLinkTeam(int[]team, int l) {
        int[] lteam = new int[l];
        int c = 0;
        for (int i = 0; i < l*2; i++) {
            if (!contains(team, i, l)) {
             lteam[c] = i;
             c++;
            }
        }
        return lteam;
    }


    private static boolean contains(int [] team, int m, int l) {
        for (int i = 0; i < l; i++) {
            if(team[i] == m)
                return true;
        }
        return false;
    }

}