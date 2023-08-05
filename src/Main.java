import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 규현
 * @since 2023-08-05
 * @url https://www.acmicpc.net/problem/1025
 * @level G5
 * @try 5
 * @performance 11640 , 84
 * @category #
 * @note n * m 행렬이 있음. 그 안에 ㅜㅅ자가 있다. 수를 조합을 하는데, row가 등차수열이어야 하고, col도 등차수열이여야 한다. r + i * a c + j *
 * b 이 칸에 적힌 수들을 조합해서 만든 수가 완전 제곱수여야 한다. 완전 제곱수란 정수를 제곱한 수라고 한다.
 * <p>
 * 입력 조건 1 <= N,M <= 9 제한 시간 2초 129MB 등차수열 조건에 맞춰서 완탐을 돌린다고 할 경우.. 잘 모르지만. row의 등차 0~ 3 col .. 0~3
 * 16 * 9 * 9 정도?? 시간적으로는 충분할 듯 싶다. 이걸로 수를 선택하고, 얘가 제곱수인지 체크해야 함. 제곱수는 어떻게 보냐. 제곱근이 정수면 제곱수임. 그 중에서
 * 가장 큰 수를 고르고 만약 없다면 -1을 출력한다. 그럼 MAX를 -1로 설정하면 될 듯 싶음.
 * <p>
 * 무조건 서로 다른 1칸이어야 한다.
 * <p>
 * 필요 변수
 * <p>
 * N,M int[][] matrix MAX
 * <p>
 * 필요 로직. row와 col의 등차를 나타내는 2중 포문 안에 matrix 조건에 탐색하는 2중 포문을 작성해야 할 거 같다.
 * <p>
 * 그리고 수를 모아주는 temp 변수도 필요
 *
 *
 * 오답 이유 : 다른 숫자를 선택을 해야 해서 증감이 0, 0인 경우엔 loop를 돌지 않았는데,
 * 1X1인 경우 0,0에서도 돌아야 하는데, 이 경우에서 반례가 발생했다.
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[][] matrix;
    static int MAX;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        MAX = -1;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String column = br.readLine();
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = column.charAt(j-1) - '0';
            }
        }







        for (int i = -n+1; i < n; i++) {
            for (int j = -m+1; j < m; j++) {
                for (int r = 1; r <= n; r++)
                    for(int c = 1; c<=m; c++)
                        comb(r,c,i,j,matrix[r][c]);
            }
        }
        System.out.println(MAX);

    }

    private static void comb(int row, int col, int pr, int pc, int acc) {

        updateMax(acc);
        if(pr == 0 && pc == 0)
            return;
        int nr = row + pr;
        int nc = col + pc;
        if (isIn(nr, nc))
            comb(nr,nc,pr,pc,acc * 10 + matrix[nr][nc]);
    }

    private static void updateMax(int next) {
        int sqrt = (int) Math.sqrt(next);
        if (sqrt * sqrt == next) {
            MAX = Math.max(MAX, next);
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 1 && row < n+1 && col >= 1 && col < m+1;
    }


}