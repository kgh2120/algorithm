import java.util.*;
import java.io.*;


/*
    author : 규현
    date : 2023-08-23
    url : 
    performance :
    category : 
    note:



*/
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] hitterResult;
    static int max = Integer.MIN_VALUE;
    static int n;
    static boolean[] s;
    static int currentScore;
    static int outCount;
    static int currentRunner;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        hitterResult = new int[n][10];
        s = new boolean[10];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                hitterResult[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(0, new int[9]);
        System.out.println(max);
        ;
    }

    private static void permutation(int depth, int[] selected) {
        if (depth == 9) {
            playBaseball(selected);
            return;
        }
        if (depth == 3) {
            selected[3] = 1;
            permutation(depth + 1, selected);
            return;
        }
        for (int i = 2; i <= 9; i++) {
            if (s[i]) continue;
            s[i] = true;
            selected[depth] = i;
            permutation(depth + 1, selected);
            s[i] = false;
        }
    }

    private static void playBaseball(int[] selected) {
        // 게임 진행
        // 각 이닝당 Queue에서 선수를  꺼내서 타격을 한다.
        // 그 결과에 따라서 runnerQueue에 반영을 한다.
        // outCount가 3이 되면 이닝을 넘긴다.
        currentScore = 0;

        int inning = 0;
        int no = 0;
        while (inning < n) {
            outCount = 0;
            currentRunner = 1;
            // hit
            while (outCount < 3) {
                if (no > 8)
                    no = 0;
                hit(hitterResult[inning][selected[no++]]);
            }

            inning++;
        }
        max = Math.max(max, currentScore);
    }

    private static void hit(int hit) {

        if (hit == 0) {
            outCount++;
            return;
        }
        //

        currentRunner = currentRunner << hit; // 먼저 밀고
        currentRunner = currentRunner | 1 << hit; // 해당 위치에 넣어주기
        while (currentRunner >= 16) {
            for (int i = 4; i <= 7 ; i++) {
                if ((currentRunner & 1 << i) > 0) {
                    currentScore++;
                    currentRunner = currentRunner & ~ (1 << i);
                }
            }

        }



    }


}