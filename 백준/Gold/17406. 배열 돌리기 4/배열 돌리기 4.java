import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author 김규현
 * @performance
 * @category #
 * @note
 * @see https://www.acmicpc.net/problem/1865
 * @since 2023-08-10
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, r;
    static int[][] originalMatrix;
    static Ops[] ops;
    static int min;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        originalMatrix = new int[n + 1][m + 1];
        ops = new Ops[r];
        min = Integer.MAX_VALUE;
        Ops[] selected = new Ops[r];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalMatrix[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            ops[i] = new Ops(r, c, s);
        }
        permutation(0,selected);

        System.out.println(min);;

    }

    private static void permutation(int cnt, Ops[] selected){
        if (cnt == selected.length) {
            int[][] matrix = arrayCopy();

            // selected들을 가지고 rotate 돌리기
            for (Ops o : selected) {
                rotateRight(matrix,o.r-o.s,o.c-o.s, o.r+o.s, o.c + o.s);
            }

            min = Math.min(min,calcNumber(matrix));

            return;
        }

        for (int i = 0; i < r; i++) {
            if(ops[i] == null) continue;
            Ops temp = ops[i];
            ops[i] = null;
            selected[cnt] = temp;
            permutation(cnt+1, selected);
            ops[i] = temp;
        }

    }

    private static int[][] arrayCopy(){
        int[][] copy = new int[n + 1][m + 1];
        for(int i = 1; i<=n; i++)
            System.arraycopy(originalMatrix[i],0,copy[i],0,m+1);
        return copy;
    }

    private static void rotateRight(int[][] matrix, int sr, int sc, int er, int ec){

        if(er - sr < 1 || ec  - sc < 1)
            return;
//        if(sr >= sc || sc >= ec || sr < 0 || sc < 0 || er < 0 || ec < 0)
//            return;


        int leftTop = matrix[sr][sc];
        int leftBot = matrix[er][sc];
        int rightTop = matrix[sr][ec];
        int rightBot = matrix[er][ec];

        for (int i = ec; i > sc; i--) {
            matrix[sr][i] = matrix[sr][i-1];
        }

        for (int i = er; i > sr; i--) {
            matrix[i][ec] = matrix[i-1][ec];
        }
        matrix[sr+1][ec] = rightTop;

        for (int i = sc; i < ec; i++) {
            matrix[er][i] = matrix[er][i+1];
        }
        matrix[er][ec-1] = rightBot;
        for (int i = sr; i < er; i++) {
            matrix[i][sc] = matrix[i+1][sc];
        }
        matrix[er-1][sc] = leftBot;

        rotateRight(matrix, sr+1,sc+1,er-1,ec-1);


    }





    private static int calcNumber(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int j = 1; j <= m; j++) {
                num += matrix[i][j];
            }
            min = Math.min(min, num);
        }
//        System.out.println(min);
        return min;
    }


    static class Ops {
        int r;
        int c;
        int s;

        public Ops(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }


    }


}