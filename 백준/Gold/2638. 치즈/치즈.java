import java.io.*;
import java.util.*;
import javax.swing.text.View;


/**

    @author 규현
    @since 2023-09-23
    @url https://www.acmicpc.net/problem/2638
    @level G3
    @try
    @performance
    @category #
    @note

    이전 G4 치즈의 변형문제.
    마찬가지로 BFS를 돌되, 이번엔 2번 접한 애들을 제거해주어야 한다.
    이전 문제와 마찬가지로 가장자리에는 치즈가 놓이지 않음.
    그럼 공기가 진행하면서, 공기인 경우 (0)은 그대로 지나치기.
    흠... 두번 찍었다는 것을 어떻게 표현을 할 지..
    매번 int배열로 visited를 체크하고, visited가 2가 되면 이미 탐색이 끝났다는 것으로 matrix의 값을 -1로 변형시키는 형태로 진행하면 어떨까..

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] matrix;
    static int[][] visited;
    static Queue<int[]> q;
    static int n, m;
    static int nOfC;
    static final int VISITED = -1;
    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new int[n][m];
        q = new ArrayDeque<>();
        int time = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if(num == 1) nOfC++;
            }
        }

        if (nOfC == 0) {
            time = 0;
        }else{

            q.add(new int[]{0,0});
            matrix[0][0] = VISITED;

            while(nOfC != 0){
                time++;
                bfs();
            }
        }
        System.out.println(time);

    }
    private static void bfs(){
        Queue<int[]> next = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int[] delta : deltas) {
                int nr = poll[0] + delta[0];
                int nc = poll[1] + delta[1];
                if(canMove(nr,nc)){
                    int num = matrix[nr][nc];
                    if(num == 0){
                        matrix[nr][nc] = VISITED;
                        q.add(new int[]{nr,nc});
                    }else{
                        if(visited[nr][nc] >= 1){
                            matrix[nr][nc] = VISITED;
                            next.add(new int[]{nr,nc});
                            nOfC--;
                        }else{
                            visited[nr][nc]++;
                        }
                    }
                }
            }
        }
        q = next;
    }

    private static boolean canMove(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] != VISITED;
    }


    
}