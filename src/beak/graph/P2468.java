package beak.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
    그래프 탐색 문제 실버 1
    시간이 1초에 메모리도 적어서 내가 짠 알고리즘으로 풀리는건가... 싶었는데
    막상 해보니까 낭낭하게 풀렸다.

    중간에 메서드에 넣은 값을 잘못 넣어서 틀렸는데, 테스트케이스는 전부 통과했던게 소름이었음.
    실제엿다면 무조건 틀릴 문제였다.
    그리고 모두 잠기지 않는 케이스도 체크해야했는데 이거도 나중에 추가했음.

    인텔리제이로 안풀었다면 아마 못맞췄을 것이다.
 */

public class P2468 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j =0;
            while (st.hasMoreTokens()) {
                int c = Integer.parseInt(st.nextToken());
                matrix[i][j++] = c;
                set.add(c);
            }
        }
        set.add(0);

        for (Integer integer : set) {
            boolean[][] visited = createVisitedArray(matrix, integer, n);
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if(visited[i][j])
                        continue;
                    c++;
                    Queue<Cor> q = new LinkedList<>();
                    q.add(new Cor(i,j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Cor poll = q.poll();

                        move(q, poll.row-1,poll.col , visited,n);
                        move(q, poll.row+1,poll.col , visited,n);
                        move(q, poll.row,poll.col-1 , visited,n);
                        move(q, poll.row,poll.col+1 , visited,n);



                    }

                }
            }
            max = Math.max(c,max);
        }

        System.out.println(max);
    }

    private void move(Queue<Cor>q, int row, int col, boolean[][] visited, int n){
        if (row >= 0 && row < n && col >= 0 && col < n && !visited[row][col]) {
            visited[row][col] = true;
            q.add(new Cor(row,col));
        }

    }


    private boolean[][] createVisitedArray(int[][]arr, int k, int n){
        boolean[][] vi = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vi[i][j] = arr[i][j] <=k ;
            }
        }
        return vi;
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
        new P2468().solution();
    }

}
