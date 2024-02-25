import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final char BLOCK = 'X';
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Coord[] deltas = {
            new Coord(-1, 0), new Coord(1, 0), new Coord(0, -1), new Coord(0,1)
    };


    static Coord[] targets;
    static int r;
    static int c;

    static char[][] matrix;

    static int turn;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        targets = new Coord[n];

        matrix = new char[r][c];

        Coord start = null;

        for (int i = 0; i < r; i++) {
            char[] cols = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                char word = cols[j];
                matrix[i][j] = word;
                if (Character.isDigit(word)) {
                    targets[word - '0' - 1] = new Coord(i, j);
                } else if (word == 'S') {
                    start = new Coord(i,j);
                }
            }
        }

        for (Coord target : targets) {
            bfs(start, target);
            start = target;
        }
        System.out.println(turn);
    }


    static void bfs(Coord start, Coord target){

        Queue<Coord> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];

        q.add(start);
        visited[start.row][start.col] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            turn++;
            while (size-->0) {
                Coord poll = q.poll();

                for (Coord delta : deltas) {
                    int nr = poll.row + delta.row;
                    int nc = poll.col + delta.col;
                    if (canAccess(nr, nc) && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if(target.row == nr && target.col == nc)
                            return;
                        q.add(new Coord(nr, nc));
                    }
                }
            }
        }

    }

    static boolean canAccess(int row ,int col){
        return row >=0 && row < r && col >= 0 && col < c && matrix[row][col] != BLOCK;
    }


    static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }



}