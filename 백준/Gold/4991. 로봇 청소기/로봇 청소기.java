import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int maxRowSize;
    static int maxColSize;

    static int[][]deltas = new int[][]{
            {-1,0}, {0,-1},{0,1},{1,0}
    };

    static final char BLOCK = 'x';

    public static void main(String[] args) throws Exception{
        StringBuilder answer = new StringBuilder();

        while (true) {
            st = new StringTokenizer(input.readLine());

            maxColSize = Integer.parseInt(st.nextToken());
             maxRowSize = Integer.parseInt(st.nextToken());


            if(maxRowSize == 0 && maxColSize == 0)
                break;


            int sR=0;
            int sC=0;

            char[][] map = new char[maxRowSize][maxColSize];

            char dirt = 'a';

            for (int i = 0; i < maxRowSize; i++) {
                String line  = input.readLine();
                for (int j = 0; j < maxColSize; j++) {
                    char c = line.charAt(j);
                    if (c == 'o') {
                        sR=i;
                        sC=j;
                        c='.';
                    }

                    if (c == '*') {
                        c = ++dirt;
                    }
                    map[i][j] = c;
                }
            }


            int numberOfDirt =  dirt - 'a';
            boolean[][][]visited = new boolean[1 << (numberOfDirt+1)][maxRowSize][maxColSize];

            Queue<Robot> q = new ArrayDeque<>();
            q.add(new Robot(numberOfDirt, 1, sR, sC));
            visited[1][sR][sC] = true;

            if (numberOfDirt == 0) {
                answer.append(0).append("\n");
                continue;
            }


            int turn = 0;
            boolean find = false;
            loop: while (!q.isEmpty()) {
                turn++;
                int size = q.size();
                while (size-- > 0) {

                    Robot robot = q.poll();

                    for (int[] delta : deltas) {
                        int nr = robot.row + delta[0];
                        int nc = robot.col + delta[1];
                        if (isIn(nr, nc) && map[nr][nc] != BLOCK && !visited[robot.dimension][nr][nc]) {
                            visited[robot.dimension][nr][nc] = true;
                            if (Character.isAlphabetic(map[nr][nc])) {
                                int nD = map[nr][nc] - 'a';
                                if ((robot.dimension & (1 << nD)) == 0) {
                                    Robot nextRobot = new Robot(robot.numberOfDirt - 1,robot.dimension | (1 << nD),  nr, nc);
                                    q.add(nextRobot);
                                    visited[nextRobot.dimension][nr][nc] = true;
                                    if (nextRobot.numberOfDirt == 0) {
                                        find = true;
                                        break loop;
                                    }
                                }
                                q.add(new Robot(robot.numberOfDirt,robot.dimension,  nr, nc));
                            }else {
                                q.add(new Robot(robot.numberOfDirt,robot.dimension,  nr, nc));
                            }
                        }

                    }

                }

            }

            answer.append(find ? turn : -1).append("\n");
        }
        System.out.println(answer);




    }



    static boolean isIn(int row, int col) {
        return row>= 0 && row < maxRowSize && col >= 0 && col < maxColSize;
    }

    static class Robot{
        int numberOfDirt;
        int dimension;
        int row;
        int col;

        public Robot(int numberOfDirt, int dimension, int row, int col) {
            this.numberOfDirt = numberOfDirt;
            this.dimension = dimension;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "numberOfDirt=" + numberOfDirt +
                    ", dimension=" + Integer.toBinaryString(dimension) +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

}
