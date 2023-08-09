import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] matrix;

    static Queue<Log> q = new LinkedList<>();
    static int minTurn = Integer.MAX_VALUE;
    static int targetRow;
    static int targetCol;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        targetRow = Integer.parseInt(st.nextToken());
        targetCol = Integer.parseInt(st.nextToken());

        matrix = new int[targetRow + 1][targetCol + 1];

        for (int i = 1; i <= targetRow; i++) {
            String[] blocks = br.readLine().split("");
            int c = 1;
            for (String block : blocks) {
                matrix[i][c++] = Integer.parseInt(block);
            }
        }

        if (targetRow == 1 && targetCol == 1) {
            System.out.println(1);
            return;
        }


        bfs();

        System.out.println(minTurn == Integer.MAX_VALUE ? -1 : minTurn);

    }

    public void bfs() {
        q.add(new Log(1, 1, 1, true));
        while (!q.isEmpty()) {
            Log log = q.poll();
            findPath(log);
        }
    }

    public void findPath(Log log){
        // 4방
        // 위
        if (log.row - 1 > 0 && matrix[log.row - 1][log.col] >= 0) {
            if (matrix[log.row - 1][log.col] == 1) {
                if (log.canDestory) {
                    q.add(new Log(log.row - 1, log.col, log.turn + 1, false));
                    finish(log.row - 1, log.col, log.turn + 1);
                }
            } else {

                boolean canDestory = log.canDestory;
                if (matrix[log.row - 1][log.col] == 0) {
                    q.add(new Log(log.row - 1, log.col, log.turn + 1, log.canDestory));
                    finish(log.row-1, log.col,log.turn+1);
                    matrix[log.row-1][log.col]= canDestory ? 2 : 3;
                }
                if (matrix[log.row -1 ][log.col] == 3) {
                    if (canDestory) {
                        q.add(new Log(log.row - 1, log.col, log.turn + 1, log.canDestory));
                        finish(log.row-1, log.col,log.turn+1);
                        matrix[log.row-1][log.col] = 2;
                    }

                }
            }
        }
        // 아래
        if (log.row + 1 <= targetRow && matrix[log.row + 1][log.col] >= 0) {
            if (matrix[log.row + 1][log.col] == 1) {
                if (log.canDestory) {
                    q.add(new Log(log.row + 1, log.col, log.turn + 1, false));
                    finish(log.row + 1, log.col, log.turn + 1);
                }
            } else {

                boolean canDestory = log.canDestory;
                if (matrix[log.row + 1][log.col] == 0) {
                    q.add(new Log(log.row + 1, log.col, log.turn + 1, canDestory));
                    finish(log.row+1, log.col,log.turn+1);
                    matrix[log.row+1][log.col]  = canDestory ? 2 : 3;
                }
                if (matrix[log.row + 1][log.col] == 3) {
                    if (canDestory) {
                        q.add(new Log(log.row + 1, log.col, log.turn + 1, canDestory));
                        finish(log.row+1, log.col,log.turn+1);
                        matrix[log.row+1][log.col] = 2;
                    }

                }
            }
        }

        // 좌
        if (log.col - 1 > 0 && matrix[log.row][log.col - 1] >= 0) {
            if (matrix[log.row][log.col - 1] == 1) {
                if (log.canDestory) {
                    q.add(new Log(log.row, log.col - 1, log.turn + 1, false));
                    finish(log.row, log.col - 1, log.turn + 1);
                }
            } else {

                boolean canDestory = log.canDestory;
                if (matrix[log.row][log.col - 1] == 0) {
                    q.add(new Log(log.row, log.col - 1, log.turn + 1, canDestory));
                    finish(log.row, log.col-1,log.turn+1);
                    matrix[log.row][log.col - 1] = canDestory ? 2 : 3;
                }
                if (matrix[log.row][log.col - 1] == 3) {
                    if (canDestory) {
                        q.add(new Log(log.row, log.col - 1, log.turn + 1, canDestory));
                        finish(log.row, log.col-1,log.turn+1);
                        matrix[log.row][log.col - 1] = 2;
                    }

                }

            }
        }

        // 우
        if (log.col + 1 <= targetCol&& matrix[log.row][log.col + 1]>= 0) {
            if (matrix[log.row][log.col + 1] == 1) {
                if (log.canDestory) {
                    q.add(new Log(log.row, log.col + 1, log.turn + 1, false));
                    finish(log.row, log.col + 1, log.turn + 1);
                }
            } else {
                boolean canDestory = log.canDestory;
                if (matrix[log.row][log.col + 1] == 0) {
                    q.add(new Log(log.row, log.col + 1, log.turn + 1, canDestory));
                    finish(log.row, log.col+1,log.turn+1);
                    matrix[log.row][log.col + 1] = canDestory ? 2 : 3;
                }
                if (matrix[log.row][log.col + 1] == 3) {
                    if (canDestory) {
                        q.add(new Log(log.row, log.col + 1, log.turn + 1, canDestory));
                        finish(log.row, log.col+1,log.turn+1);
                        matrix[log.row][log.col + 1] = 2;
                    }

                }


            }
        }


    }

    public void finish(int r, int c, int turn){
        if (r == targetRow && c == targetCol) {
            minTurn = Math.min(minTurn, turn);
            q.clear();


        }
    }


    class Log {
        private int row;
        private int col;
        private int turn;
        private boolean canDestory;

        public Log(int row, int col, int turn, boolean canDestory) {
            this.row = row;
            this.col = col;
            this.turn = turn;
            this.canDestory = canDestory;
        }


    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}





