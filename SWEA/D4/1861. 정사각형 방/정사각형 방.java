import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
/**
    @author 김규현
    @since 2023-08-09
    @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYlH3z4K78kDFAVR&contestProbId=AV5LtJYKDzsDFAXc&probBoxId=AYnN7JhqMPoDFAUe&type=PROBLEM&problemBoxTitle=0807%EC%A3%BC&problemBoxCnt=4
    @performance
    @category #
    @note
    방이 N X N 형태로 있다.
    각 방에는 1 <= o <= N^2
    상하좌우로 이동할 수 있음. 근데 이때 이동할 수 있는 범위(0<= x < n) 내에 있어야 하고, 내 숫자 o보다 1큰 수여야 한다.
    어떤 방에서 출발하는 것이 가장 탐색을 많이할 수 있는지에 대한 문제이다.
 
    방의 크기 N : 1 <= N <= 10^3
 
    방을 전체 탐색하는 경우 10^6, 인듯. 이미 탐색을 했는지를 체크한다면 10^6 * 4정도 일 듯.
    10^6이라면 1ms이기 때문에 여유로워 보인다.
 
    27개의 케이스, 2초
 
*/
public class Solution {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] matrix;
 
    static int[][] deltas = {
            {-1,0},{1,0},{0,1},{0,-1}
    };
 
    static int n;
    static int maxCount;
    static Position maxPosition;
    static Map<Integer,Position> map;
    static final int VISITED = -1;
 
    static class Position{
        int row;
        int col;
        int number;
 
        public Position(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }
    }
 
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        map = new HashMap<>();
//        matrix = new int[1000][1000];
        for (int test = 1; test <= T; test++) {
            n = Integer.parseInt(br.readLine());
            map.clear();
            maxCount = 1;
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    matrix[i][j] = number;
                    map.put(number, new Position(i,j,number));
                }
            }
            maxPosition = map.get(1);
            for (int i = 1; i <= n * n; i++) {
                if(maxCount >= n*n /2)
                    break;
                if(maxCount >= n*n - i)
                    break;
                    Position start = map.get(i);
                    if(matrix[start.row][start.col] == VISITED)
                        continue;
                    bfs(start);
                }
 
            sb.append("#").append(test)
                    .append(" ")
                    .append(maxPosition.number)
                    .append(" ")
                    .append(maxCount)
                    .append("\n");
        }
        System.out.println(sb);
     
 
 
    }
 
    private static void bfs(Position start){
        Queue<Position> q = new ArrayDeque<>();
        q.add(start);
        matrix[start.row][start.col] = VISITED;
//        map.remove(start);
        int cnt =1;
        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int[] delta : deltas) {
                int nr = p.row + delta[0];
                int nc = p.col + delta[1];
                if (canAccess(nr, nc, p.number)) {
                    q.add(new Position(nr,nc,matrix[nr][nc]));
                    cnt++;
//                    map.remove(matrix[nr][nc]);
                    matrix[nr][nc] = VISITED;
                }
            }
        }
 
        if (cnt > maxCount) {
            maxCount = cnt;
            maxPosition = start;
        }
    }
 
    private static boolean canAccess(int row, int col, int number){
        return row >=0 && row < n && col >=0 && col < n && matrix[row][col] == number+1;
    }
 
 
}