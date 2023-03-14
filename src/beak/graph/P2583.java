package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/2583
    그래프 탐색 실버 1
 */
public class P2583 {


    boolean[][] visited;
    public void solution() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int nOfR = Integer.parseInt(st.nextToken());


        visited = new boolean[r][c];

        for (int i = 0; i < nOfR; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    visited[k][j] = true;
                }
            }
        }
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visited[i][j])
                    continue;
                counts.add(bfs(i,j,r,c));
            }
        }
        Collections.sort(counts);
        printAnswer(counts);
    }

    private void printAnswer(List<Integer> counts) {
        StringBuilder sb = new StringBuilder();
        sb.append(counts.size()).append("\n");
        for (Integer count : counts) {
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    public int bfs(int row, int col, int maxR, int maxC){
        Queue<Cor> q = new LinkedList<>();
        q.add(new Cor(row,col));
        visited[row][col] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Cor cor = q.poll();
            count +=move(cor.x -1,cor.y,maxR,maxC ,q);
            count +=move(cor.x +1,cor.y,maxR,maxC ,q);
            count +=move(cor.x ,cor.y-1,maxR,maxC ,q);
            count +=move(cor.x,cor.y+1,maxR,maxC ,q);
        }
        return count;
    }
    public int move(int row, int col, int mr, int mc, Queue<Cor> q){
        if(row >= 0 && row < mr && col >= 0 && col < mc){
            if (!visited[row][col]) {
                q.add(new Cor(row,col));
                visited[row][col] = true;
                return 1;
            }
        }
        return 0;
    }

    class Cor{
        int x;
        int y;

        public Cor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }




    public static void main(String[] args) throws Exception {
        new P2583().solution();
    }

}
