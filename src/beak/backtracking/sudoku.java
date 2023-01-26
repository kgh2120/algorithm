package beak.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  수도쿠 문제
 *  엔퀸이랑 비슷한 방법으로 풀었어야 했음.
 *  유추하는 방법은 잘 찾아갔는데, N퀸과 다르게 무조건 해당 row에서 최적해를 찾을 수 있다고
 *  생각해버렸음.
 *  N퀸은 무조건 찾을 수 있어서 값을 채울 수 있었는데, 얘는 아니었음.
 *  그래서 돌아올 때 값을 초기화 시켜 줘야 풀렸던 문제.
 *  N퀸도 사실은 초기화를 해줬어야 했을 거 같다.
 */
public class sudoku {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] s = new int[9][9];
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int token = Integer.parseInt(st.nextToken());
                s[i][j] = token;
                if (token == 0) {
                    rows.add(i);
                    cols.add(j);
                }

            }
        }

        int nOfZ = rows.size();


        sdoku(s, 0, rows, cols, nOfZ);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(s[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }


    public static void sdoku(int[][] s, int i, List<Integer> rows, List<Integer> cols, int size) {

        if (i == size) {
            flag = true;
            return;
        }

        int r = rows.get(i);
        int c = cols.get(i);
        for (int j = 1; j <= 9; j++) {
            s[r][c] = j;
            if (isValid(s, r, c, j))
                sdoku(s, i + 1, rows, cols, size);
            if(flag)
                return;
            s[r][c] = 0;
        }

    }

    private static boolean isValid(int[][] s, int r, int c, int t) {
        // row valid
        for (int i = 0; i < 9; i++) {
            if (s[r][i] == t && c != i) return false;
            if (s[i][c] == t && r != i) return false;
        }

        // sqaure valid
        return squareValid(s, r, c, t);
    }

    private static boolean squareValid(int[][] s, int r, int c, int t) {


        int sR = r / 3 * 3;
        int sC = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (s[sR + i][sC + j] == t) {
                    if (sR + i != r && sC + j != c)
                        return false;
                }
            }
        }
        return true;
    }


}