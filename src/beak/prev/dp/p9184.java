package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀 연산에 DP를 적용한 문제.
 * 문제에 적힌 대로 식을 작성하고 DP를 사용
 */

public class p9184 {


    int[][][] w;

    public static void main(String[] args) throws Exception {
        new p9184().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        w = new int[21][21][21];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            sb.append("w("+a+", "+b+", "+c+") = ") // format은 진짜 최악이네 성능이 원래는 잘 나오는 건데..
                    .append(r(a, b, c))
                    .append("\n");
        }


        System.out.println(sb);


    }

    public int r(int a, int b, int c) {


        if (inRange(a, b, c) && w[a][b][c] != 0) {
            return w[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        if (a > 20 || b > 20 || c > 20) {

            return w[20][20][20] = r(20, 20, 20);
        }
        if (a < b && b < c) {
            return w[a][b][c] = r(a, b, c - 1) + r(a, b - 1, c - 1) - r(a, b - 1, c);
        }


        return w[a][b][c] = r(a - 1, b, c) + r(a - 1, b - 1, c) + r(a - 1, b, c - 1) - r(a - 1, b - 1, c - 1);

    }

    private boolean inRange(int a, int b, int c) {
        return a>=0 && a<=20 && b>=0 && b<=20 && c>=0 && c<=20;
    }


}