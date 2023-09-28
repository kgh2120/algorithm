import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;



/**

    @author 규현
    @since 2023-09-28
    @url https://www.acmicpc.net/problem/17244
    @level G2
    @try
    @performance
    @category #
    @note

    경재는 약속을 가기 전 물건을 챙기고 가야 한다.
    근데 모든 물건을 챙겨야 함.
    그래서 S에서 시작해서 물건들 X를 챙기고, E로 나가야 함.

    그때 최소한의 걸음을 계산해야 함.

    얼매나 걸리까?

    물건은 총 5개가 있다고 함.

    결국 최소한의 걸음이기 때문에 BFS를 적용시키면 될 듯 하다.

    달차간이랑 비슷한 느낌이었는데 물건의 종류가 구분이 없기 때문에 비트마스킹은 안해도 될 듯 싶다.

    물건을 중복으로 챙기는 케이스가 발생해서 처리를 해줘야겠음.

 트  매트릭스를 입력받을 때, X의 개수를 새고, 3차원 visited를 만든 후, E에 도착한 시점에 물건의 개수가 충족이 된 경우를
    체크하면 될 듯 싶다.

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[][] matrix;
    static int r,c,n;
    static int [][] deltas = { {-1,0},{1,0},{0,-1},{0,1}};
    static Queue<Node> q;
    static boolean [][][] visited;


    static final char WALL = '#', ITEM = 'X', END = 'E';
    static List<Item> items;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];


        q = new ArrayDeque<>();
        items = new ArrayList<>();
//        items.add(null);

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = line.charAt(j);
                if (c == 'S') {
                    q.add(new Node(i,j, 0));
                    c = '.';
                } else if (c == ITEM) {
                    items.add(new Item(i,j));
                }
                matrix[i][j] = c;
            }
        }

        visited = new boolean[1 << items.size()][r][c];
      
        bfs();


    }

    private static void bfs() {

        int time = 0;
        while (!q.isEmpty()) {

            time++;
            int size = q.size();
            while (size-- > 0) {
                Node poll = q.poll();


                int count = poll.count;

                for (int[] delta : deltas) {
                    int nr = poll.row + delta[0];
                    int nc = poll.col + delta[1];
                    if (canMove(nr, nc) && !visited[count][nr][nc]) {
                        visited[count][nr][nc] = true;
                        if (matrix[nr][nc] == ITEM) {
                            int index = items.indexOf(new Item(nr,nc));
                            visited[count | 1 << index][nr][nc] = true;
                            q.add(new Node(nr,nc,count | 1 << index));
                        } else if (matrix[nr][nc] == END && (count+1) == (1 << items.size())) {
                            System.out.println(time);
                            return;
                        } else if (matrix[nr][nc] == '.') {
                            q.add(new Node(nr,nc,count));
                        }
                    }
                }
            }
        }
    }


    private static boolean canMove(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c && matrix[row][col] != WALL;
    }

    static class Item {
        int row;
        int col;

        public Item(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Item item = (Item) o;
            return row == item.row && col == item.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Node{
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", count=" + count +
                    '}';
        }
    }

}