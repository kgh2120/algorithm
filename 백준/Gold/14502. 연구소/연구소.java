import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;

    static int[][] matrix;
    static int[][] deltas = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    static List<int[]> viruses;
    static int nOfSafeZone;
    static int answer = Integer.MIN_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{

        setVariables();
        // 좌표 변환 만들어야 함.
        // 조합으로 3개 벽 치고, BFS 돌면서 개수 찾기.
        combination(0,0);
        System.out.println(answer);

    }

    static void combination(int depth, int prev){
        if(depth == 3){
            // 바이러스 퍼뜨리기

            // visited에 복사하기

            copyMap();
            int result = spread();
            answer = Math.max(answer, result);
            // 바이러스들 bfs 진행시키기
            // nOfSafeZone 맥스랑 비교하기.

            return;
        }

        for(int i = prev; i< n*m; i++){
            int[] coord = transformCoord(i);
            if(matrix[coord[0]][coord[1]] == 0){
                matrix[coord[0]][coord[1]] = 1;
                nOfSafeZone--;
                combination(depth+1, i+1);
                matrix[coord[0]][coord[1]] = 0;
                nOfSafeZone++;
            }
        }
    }

    static int spread(){

        Queue<int[]> q = new ArrayDeque<>();
        for(int[] virus : viruses)
            q.add(virus);

        int safeZone = nOfSafeZone;

        while(!q.isEmpty()){
            int[] virus = q.poll();

            int row = virus[0];
            int col = virus[1];

            for(int[] delta : deltas){
                int nr = row + delta[0];
                int nc = col + delta[1];

                if(canAccess(nr,nc)){
                    visited[nr][nc] = true;
                    safeZone--;
                    q.add(new int[] {nr,nc});
                }
            }

        }
        return safeZone;
    }

    static void copyMap(){
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                visited[i][j] = matrix[i][j] != 0;
            }
        }
    }


    static int[] transformCoord(int index){
        return new int[] {index/m, index%m};
    }

    static void setVariables() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        viruses = new ArrayList<>();

        for(int i = 0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;
                if(value == 0){
                    nOfSafeZone++;
                }else if(value == 2){
                    viruses.add(new int[]{i,j});
                }
            }
        }
    }

    static boolean canAccess(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == false;
    }
}