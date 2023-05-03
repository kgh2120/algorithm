package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {

    StringBuilder sb = new StringBuilder();
    int day = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] matrix = new int [h][n][m];
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int tomatoRow = Integer.parseInt(st.nextToken());
                    matrix[i][j][k] = tomatoRow;
                    if(tomatoRow == 1)
                        q.add(new Tomato(i,j,k,0));

                    k++;
                }
            }
        }
        if (isFull(matrix)) {
            System.out.println(0);
            return;
        }
        bfs(matrix,q);
        if (isFull(matrix)) {
            System.out.println(day);
            return;
        }
        System.out.println(-1);

    }

    public void bfs(int[][][]matrix, Queue<Tomato> q){

        while (!q.isEmpty()) {
            Tomato poll = q.poll();
            day = Math.max(day, poll.day);

            // move
            move(matrix,q,poll);
        }
    }

    public void move(int[][][] matrix, Queue<Tomato> q , Tomato cur){


        // 6방향 무빙
        moveIfYouCan(matrix,q,cur,+1,0,0); // 위
        // 아래
        moveIfYouCan(matrix,q,cur,-1,0,0);

        // 앞
        moveIfYouCan(matrix,q,cur,0,-1,0);

        // 뒤
        moveIfYouCan(matrix,q,cur,0,1,0);

        //좌\
        moveIfYouCan(matrix,q,cur,0,0,-1);

        //우
        moveIfYouCan(matrix,q,cur,0,0,1);

//||
//        matrix[cur.h + hd][cur.n + nd][cur.m + md] > cur.day

    }

    public void moveIfYouCan(int[][][] matrix, Queue<Tomato> q , Tomato cur, int hd, int nd, int md){
        if (cur.h + hd >= 0 && cur.h + hd < matrix.length &&
                cur.n + nd >= 0 && cur.n + nd < matrix[0].length &&
                cur.m + md >= 0 && cur.m + md < matrix[0][0].length &&(
                matrix[cur.h + hd][cur.n + nd][cur.m + md] == 0 )
        ) {
            matrix[cur.h + hd][cur.n + nd][cur.m + md] = cur.day+1;
            q.add(new Tomato(cur.h + hd, cur.n + nd, cur.m + md, cur.day+1));
        }
    }




    public boolean isFull(int[][][]matrix){
        for (int[][] ints : matrix) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if(i == 0)
                        return false;
                }
            }
        }
        return true;
    }






    class Tomato {

        int h;
        int n;
        int m;
        int day;

        public Tomato(int h, int n, int m, int day) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.day = day;
        }
    }


    public static void main(String[] args) throws Exception {
        new P7569().solution();
    }
}





