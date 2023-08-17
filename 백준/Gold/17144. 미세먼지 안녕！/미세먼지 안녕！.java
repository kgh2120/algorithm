import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author 규현
@since 2023-08-17
@url
@level
@try
@performance
@category #
@note


*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] matrix;

    static int n,m;
    static int uR,dR;

    static int time;
    static Queue<Dust> q;

    static int[][] deltas = {
            {-1,0},{1,0},{0,1},{0,-1}
    };
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];

        uR = -1;
        dR = -1;
        q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m ; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    if(uR == -1) uR = i;
                    else if(dR == -1) dR = i;
                }
                matrix[i][j] = num;
            }
        }

        int cur = 0;
        while (cur != time) {
            cur++;
            // 확산
            spread();

            // 돌리기
            upWind();
            downWind();

        }


        System.out.println(countDust());

    }

    private static int countDust(){
        int sum = 0;
        for (int[] dusts : matrix) {
            for (int dust : dusts) {
                if(dust == 0 || dust == -1)
                    continue;
                sum += dust;
            }
        }
        return sum;
    }

    //위치가 보장이 안된다. 그럼 queue를 못쓸지도?
    // 매 번 n^n을 하면서 queue에 넣고 해줘야하나...
    private static void spread(){
        findDust();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Dust dust = q.poll();

            for (int[] delta : deltas) {
                int nr = dust.r + delta[0];
                int nc = dust.c + delta[1];
                int spreadDust = dust.amount/5;
                if (canSpread(nr, nc)) {
                    matrix[dust.r][dust.c] -= spreadDust;
                    if(matrix[dust.r][dust.c] < 0)
                        matrix[dust.r][dust.c] = 0;
                    matrix[nr][nc] += spreadDust;
                }
            }

        }

    }

    private static void findDust(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0 || matrix[i][j] == -1)
                    continue;
                q.add(new Dust(i,j,matrix[i][j]));
            }
        }
    }


    private static boolean canSpread(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] != -1;
    }

    private static void upWind(){

        for (int i = uR - 1; i > 0; i--) {
            matrix[i][0] = matrix[i-1][0];
        }
        for (int i = 0; i < m - 1; i++) {
            matrix[0][i] = matrix[0][i+1];
        }
        for (int i = 0; i < uR; i++) {
            matrix[i][m-1] = matrix[i+1][m-1];
        }
        for(int i = m-1; i > 1; i--)
            matrix[uR][i] = matrix[uR][i-1];
        matrix[uR][1] = 0;

    }

    private static void downWind(){

        for (int i = dR+1; i < n - 1; i++) {
            matrix[i][0] = matrix[i+1][0];
        }

        for(int i = 0; i < m-1; i++)
            matrix[n-1][i] = matrix[n-1][i+1];


        for (int i = n - 1; i > dR; i--) {
            matrix[i][m-1] = matrix[i-1][m-1];
        }


        for (int i = m-1; i > 1; i--) {
            matrix[dR][i] = matrix[dR][i-1];
        }
        matrix[dR][1] = 0;
    }


    static class Dust{
        int r;
        int c;
        int amount;

        public Dust(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }
}