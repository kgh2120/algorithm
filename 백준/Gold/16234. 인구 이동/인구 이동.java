import java.io.*;
import java.util.*;


/*
    필요한 것
    r*c matrix
    L,R 변수
    delta 배열
    각 bfs에서의 결과를 담을 자료구조
    각 나라를 저장할 자료구조
    visited 배열
    날짜가 얼마나 지났는지 변수

    1 <= N <= 50, 1 <= L <= R <= 100
    모든 인구수는 0 ~ 100

    예상 시간복잡도 O(N^2)

    작동 로직
    0. 날짜를 +1 해준다.
    1. 전체 matrix에 대해서 bfs를 진행해서 연합을 만든다.
    1-1 연합의 개수가 0개라면 종료한다.
    2. 연합별로 matrix의 값을 변경한다.
    1,2가 반복한다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int days;
    static int[][] matrix;
    static int n, l, r;
    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };
    static boolean [][] visited;
    static Queue<Country> unions;
    static Queue<Country> innerQueue;


    public static void main(String[] args) throws Exception {
        setVariables();
        move();
        System.out.println(days);

    }

    private static void move() {
        while (true) {
            createUnion();
            if(unions.isEmpty()) break;
            rebuildMatrix();
            days++;
        }
    }

    private static void log(){
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    private static void rebuildMatrix(){
        while (!unions.isEmpty()) {
            Country union = unions.poll();
            int avg = calcAvgPopulation(union.nOfPeople, union.nOfChains);
            while (union != null) {
                matrix[union.r][union.c] = avg;
                union = union.next;
            }
        }
    }

    private static int calcAvgPopulation(int nOfPeoples, int nOfChains) {
        return nOfPeoples / nOfChains;
    }

    private static void createUnion() {
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                Country union = bfs(i, j);
                if (union.nOfChains > 1) {
                    unions.add(union);
                }
            }
        }
    }

    private static Country bfs(int r, int c){
        int chains = 0;
        int nOfPeople = 0;
        Country head = new Country(r, c, null);
        visited[r][c] = true;
        innerQueue.add(head);
        while (!innerQueue.isEmpty()) {
            Country poll = innerQueue.poll();
            chains++;
            nOfPeople += matrix[poll.r][poll.c];
            for (int[] del : deltas) {
                int nr = poll.r + del[0];
                int nc = poll.c + del[1];
                if (isIn(nr, nc) && !visited[nr][nc] && canUnion(matrix[poll.r][poll.c], matrix[nr][nc])) {
                    visited[nr][nc] = true;
                    head = new Country(nr,nc,head);
                    innerQueue.add(head);
                }
            }
        }
        head.nOfChains = chains;
        head.nOfPeople = nOfPeople;
        return head;
    }



    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        visited = new boolean[n][n];
        unions = new ArrayDeque<>();
        innerQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean canUnion(int from, int to) {
        int diff = Math.abs(from - to);
        return diff >= l && diff <= r;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }


    static class Country{
        int r;
        int c;
        int nOfChains;
        int nOfPeople;

        Country next;

        public Country(int r, int c, Country next) {
            this.r = r;
            this.c = c;
            this.next = next;
        }
    }






}