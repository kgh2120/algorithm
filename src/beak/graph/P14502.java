package beak.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/14502
    그래프 탐색 문제 + 브루트포스, 골드 4
    이걸 어뜨케 푸냐.. 라고 생가했는데 브루트포스 문제라는걸 보고
    가로 세로 길이를 보니 상당히 낮아서 되는구나 싶었따.
    브루트포스 조건은 조합식으로 풀었고,
    depth가 완료되면 bfs를 하도록 했다.
    앞으로는 문제 조건을 보고 판단하도록 해야겠다.
    그리고 Arrays.copyOf를 써봤는데, 2차원 배열의 경우 deepCopy가 되지 않아서
    초반에 답이 안나왔다.
 */

public class P14502 {

    /*
        7 7
        2 0 0 0 1 1 0
        0 0 1 0 1 2 0
        0 1 1 0 1 0 0
        0 1 0 0 0 0 0
        0 0 0 0 0 1 1
        0 1 0 0 0 0 0
        0 1 0 0 0 0 0
     */

    int[][] matrix;
    boolean[][] visited;
    List<Cor> virus;
    List<Cor> blank;
    int max = Integer.MIN_VALUE;

    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
         matrix = new int[row][col];
         visited = new boolean[row][col];
         virus = new ArrayList<>();
         blank = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                matrix[i][j] = k;
                if (k == 2) {
                    virus.add(new Cor(i, j));
                    visited[i][j] = true;
                } else if (k == 1) {
                    visited[i][j] = true;
                } else {
                    blank.add(new Cor(i, j));
                }
                j++;
            }
        }

        comb(0,0);
        System.out.println(max);
    }

    private void comb(int depth, int cur){
        if (depth == 3) {
            bfs();
            return;
        }

        for(int i = cur; i< blank.size(); i++){
            Cor cor = blank.get(i);
            visited[cor.row][cor.col] = true;
            comb(depth+1, i+1);
            visited[cor.row][cor.col] = false;
        }

    }

    private void bfs() {
        boolean [][]tempVisited = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++) {
            System.arraycopy(visited[i], 0, tempVisited[i], 0, visited[0].length);

        }

        int c = blank.size()-3;


        for (Cor vir : virus) {
            Queue<Cor> q = new LinkedList<>();
            q.add(vir);
            while (!q.isEmpty()) {

                Cor poll = q.poll();
                // 상 무빙
                if (poll.row != 0 && !tempVisited[poll.row - 1][poll.col]) {
                    tempVisited[poll.row - 1][poll.col] = true;
                    q.add(new Cor(poll.row - 1, poll.col));
                    c--;
                }
                // 하 무빙
                if (poll.row != visited.length - 1 && !tempVisited[poll.row + 1][poll.col]) {
                    tempVisited[poll.row + 1][poll.col] = true;
                    q.add(new Cor(poll.row + 1, poll.col));
                    c--;
                }
                // 좌 무빙
                if (poll.col != 0 && !tempVisited[poll.row][poll.col - 1]) {
                    tempVisited[poll.row][poll.col - 1] = true;
                    q.add(new Cor(poll.row, poll.col - 1));
                    c--;
                }
                if (poll.col != visited[0].length - 1 && !tempVisited[poll.row][poll.col + 1]) {
                    tempVisited[poll.row][poll.col + 1] = true;
                    q.add(new Cor(poll.row, poll.col + 1));
                    c--;
                }
            }
        }

        max = Math.max(max,c);


    }


    class Cor {

        int row;
        int col;

        public Cor(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) throws IOException {
        new P14502().solution();
    }

}
