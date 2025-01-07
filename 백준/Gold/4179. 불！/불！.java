import java.util.*;
import java.io.*;

/**
 지훈이는 불이 난 곳은 못간다.
 지훈이는 맵 밖으로 나가면 탈출을 한다.
 맵 밖으로 못나가게 될 경우 IMPOSSIBLE을 출력하면 된다.

 지훈이가 나갈 수 있는 경우 몇초만에 나가는지를 출력해라.
 그러니까 BFS를 섞어서 진행하면 될듯하다.



 **/
public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int maxRow;
    static int maxCol;

    static char[][] matrix;
    static boolean[][] visited;

    static int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    static final char WALL = '#';
    static final char FIRE = 'F';
    static final char JIHOON = 'J';

    static final String FAIL = "IMPOSSIBLE";


    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(input.readLine());

        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());

        matrix = new char[maxRow][maxCol];
        visited = new boolean[maxRow][maxCol];



        Queue<Node> jiQ = new ArrayDeque<>();
        Queue<Node> fQ = new ArrayDeque<>();

        for(int i = 0; i<maxRow; i++){
            String line = input.readLine();
            for(int j = 0; j<maxCol; j++){
                char block = line.charAt(j);
                matrix[i][j] = block;

                if(block == JIHOON){
                    jiQ.add(new Node(i,j,true));
                    visited[i][j] = true;
                }else if(block == FIRE){
                    fQ.add(new Node(i,j,false));
                }
            }
        }



        int turn = 0;
        while(!jiQ.isEmpty()){
            turn++;
            move(fQ);
            if(move(jiQ)){
                System.out.println(turn);
                return;
            }
        }

        System.out.println(FAIL);

    }

    static boolean move(Queue<Node> queue){
        int size = queue.size();
        while(size-->0){
            Node current = queue.poll();

            for(int[] delta : deltas){
                int nextRow = current.row + delta[0];
                int nextCol = current.col + delta[1];
                // 지훈인지
                if(current.isJihoon){
                    if(isExit(nextRow, nextCol)){
                        return true;
                    }
                    if(isIn(nextRow, nextCol) && matrix[nextRow][nextCol] != WALL && matrix[nextRow][nextCol] != FIRE && !visited[nextRow][nextCol]){
                        queue.add(new Node(nextRow, nextCol, true));
                        visited[nextRow][nextCol] = true;
                    }
                    continue;
                }

                if(isIn(nextRow, nextCol) && matrix[nextRow][nextCol] != WALL && matrix[nextRow][nextCol] != FIRE){
                    matrix[nextRow][nextCol] = FIRE;
                    queue.add(new Node(nextRow, nextCol, false));
                }
            }

        }
        return false;
    }

    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    static boolean isExit(int row, int col){
        return row < 0 || row >= maxRow || col < 0 || col >= maxCol;
    }

    static class Node{
        int row;
        int col;
        boolean isJihoon;

        public Node(int row, int col, boolean isJihoon){
            this.row = row;
            this.col = col;
            this.isJihoon = isJihoon;
        }
    }
}