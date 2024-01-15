import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;



class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] matrix;

    static int[][] deltas = {{-1,0},{0,-1} , {1,0}, {0,1}};

    static int[][] answer;

    static int r;
    static int c;


    static int startR;
    static int startC;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new int[r][c];
        answer = new int[r][c];
        for (int[] ints : answer) {
            Arrays.fill(ints,-1);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 2) {
                    startR = i;
                    startC = j;
                }else if(matrix[i][j] == 0)
                    answer[i][j] = 0;
            }
        }


        // BFS

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {startR, startC});
        answer[startR][startC] = 0;

        int turn = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            turn++;
            while (size-- > 0) {

                int[] poll = q.poll();

                for (int[] delta : deltas) {
                    int nr = poll[0] + delta[0];
                    int nc = poll[1] + delta[1];

                    if (canMove(nr, nc) && answer[nr][nc] == -1) {
                            q.add(new int[]{nr,nc});
                            answer[nr][nc] = turn;
                    }

                }

            }

        }

        StringBuilder sb = new StringBuilder();

        for (int[] ints : answer) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean canMove(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c && matrix[row][col] != 0;
    }



}