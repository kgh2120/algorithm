import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int [][] matrix;
    static final int D = 4;
    static final int U = 2;
    static final int L = 3;
    static final int R = 1;
    static final int APPLE = -1;
//    static final Map<String,int[]> deltas = new HashMap<>();
    static int n,m,d;
    static int[] head;
    static int[] tail;
    static final int ROW = 0;
    static final int COL = 1;
    static int result = 0;

    static int[][] deltas = {
            {0,1,1},
            {-1,0,2},
            {0,-1,3},
            {1,0,4}
    };
    static int direction = 0;
    static int limit = 0;

    public static void main(String[] args) throws Exception {


        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        head = new int[2];
        tail = new int[2];
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            matrix[row-1][col-1] = APPLE;
        }

        d = Integer.parseInt(br.readLine());
        // 뱀 위치 0,0
        Queue<Move> q = new LinkedList<>();
         for(int i = 0; i<d; i++){
            st = new StringTokenizer(br.readLine());
            int limit = Integer.parseInt(st.nextToken());
            String di = st.nextToken();
            q.add(new Move(limit,di));
        }

        Move poll = q.poll();
        while (true){


            if(poll.time == result){
                rotate(poll.d);
                if(!q.isEmpty())
                    poll = q.poll();
            }
            if (move()){
                if(!hasApple()) {
                    int tailD = matrix[tail[ROW]][tail[COL]];
                    matrix[tail[ROW]][tail[COL]] = 0;// tail 위치 바꿔줘야 함.
                    moveTail(tailD);
                }
            }else{
                break;
            }
            result++;
        }


        System.out.println(result+1);

    }

    private static boolean hasApple(){
            return matrix[head[ROW]][head[COL]] == APPLE;
    }

    private static boolean move(){

        int[]del = deltas[Main.direction];
        if(isSafe(head[ROW] + del[ROW], head[COL] + del[COL] )){
            matrix[head[ROW]][head[COL]] = del[2];
            head[ROW] += del[ROW];
            head[COL] += del[COL];
            return true;
        }

        return false;

    }

    private static void rotate(String d){
        if("L".equals(d)){
            if(++direction > 3)
                direction = 0;
        }else if("D".equals(d)){
            if(--direction <0)
                direction = 3;
        }
    }

    private static boolean isSafe(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < n && matrix[row][col] <= 0;
    }

    private static void moveTail(int d){
        switch (d){
            case D :
                tail[ROW]++;
                break;
            case U :
                tail[ROW]--;
                break;
            case L :
                tail[COL]--;
                break;
            case R :
                tail[COL]++;
                break;
        }
    }


    static class Move{
        int time;
        String d;

        public Move(int time, String d) {
            this.time = time;
            this.d = d;
        }
    }


}