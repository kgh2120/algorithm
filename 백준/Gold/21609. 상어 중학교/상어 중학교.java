import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author 규현
 * @url
 * @level
 * @try
 * @performance
 * @category #
 * @note n * n 칸 블록이 있다. 블록은 검, 무, 일반이 있다. 일반 블록은 M가지 색상이 있고, M 이하의 수로 표현한다. 검은색 블록은 -1, 무지개는 0으로
 * 표현함.
 * <p>
 * 블록그룹 연결 조건. 1. 일반 블록이 1개 이상 있어야 한다. 2. 일반 블록은 색이 모두 같아야 한다. 3. 검은색 블록은 있으면 안된다. 4. 무지개 블록은 상관없다.
 * 5. 그룹의 블록 개수는 2개 이상이어야 한다. 6. 모든 그룹은 인접한 칸으로 있어야 한다.
 * <p>
 * 기준 블록 : 일반 블록 중에서 R이 가장 작고, C도 가장 작은 블록.
 * <p>
 * 플레이 기능 - 블록 그룹이 있으면 반복 1. 크기가 가장 큰 그룹을 찾는다. -> N*N  BFS 1-1 크기가 같다면 무지개가 많은 블록을 찾는다. 1-2 기준 블록 중
 * R, C가 큰 것을 찾는다. 2. 1의 그룹을 제거한다. 제거한 블록의 수의 제곱만큼 점수를 획득한다. 3. 중력 작용  N*N 그냥 구현 4. 왼쪽으로 회전 N*N 배열
 * 복사 후 돌리기 5. 중력 작용 N*N
 * <p>
 * 중력 : 가장 아래 R 혹은 -1이 있는 위치까지 떨군다.
 * <p>
 * 1 <= N <= 20 1 <= M <= 5
 * <p>
 * 시간 : 1초 메모리 1024mb
 * <p>
 * 1번 작동 시 5 * N^2 (400) 2000정도 ?? 그럼 뭐... 걍 해도 될 듯?
 * <p>
 * 메모리가 넉넉한 것을 보아 하니.. 배열은 마음껏 복사해도 될 듯 싶다..
 * @since 2023-08-27
 */

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 맵 배열
    static String[][] matrix;
    // 점수
    static int score;
    //  bfs 델타 배열
    static int[][] deltas = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    // 무지개
    static final String RAINBOW = "0";
    // 검정색
    static final String BLACK = "9";
    // 빈 칸
    static final String BLANK = "8";


    static int n;
    static int m;
    static Queue<Block> q, maxGroup, tempGroup;

    static int nOfRainbow, tempRainBow;
    static boolean[][] visited;

    static int r,c;

    public static void main(String[] args) throws Exception {
        setVariables();
        playGame();
        System.out.println(score);


    }

    private static void playGame() {
        while (true) {
            // best group 찾기
            if (findBestGroup()) {
                getScoreAndRemoveGroup();
                // 중력 작용
                gravity();
                rotateLeft();
                gravity();
                continue;
            }
            break;
        }
    }



    private static void printGroup() {
        System.out.println("-- score : " + score + " --");
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + "\t");
            }
            System.out.println();
        }
        System.out.println();


    }

    private static void rotateLeft() {
        String[][] rotated = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = matrix[j][n-i-1];
            }
        }
        matrix = rotated;
    }

    private static void gravity() {
        for (int col = 0; col < n; col++) {
            for (int row = n-2; row >= 0 ; row--) {
                if(matrix[row][col].equals(BLACK) || matrix[row][col].equals(BLANK)) continue;
                int d = 1;
                int nr = row + d;
                // 이동 가능하다면...
                while (isIn(nr, col) && matrix[nr][col].equals(BLANK)) {
                    nr += d;
                }
                //
                String temp = matrix[row][col];
                matrix[row][col] = BLANK;
                matrix[nr-1][col] = temp;
            }
        }
    }

    private static void getScoreAndRemoveGroup() {
        int nOfGroup = maxGroup.size();
        while (!maxGroup.isEmpty()) {
            Block block = maxGroup.poll();
            matrix[block.r][block.c] = BLANK;
        }
        score += nOfGroup * nOfGroup;
    }

    private static boolean findBestGroup() {
        nOfRainbow = -1;
        visited = new boolean[n][n];
        maxGroup = new ArrayDeque<>();
        r = -1;
        c = -1;
        for (int i = 0; i  < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j].equals(BLACK) || matrix[i][j].equals(RAINBOW)
                || matrix[i][j].equals(BLANK)) {
                    continue;
                }
                makeGroup(i, j);
                if (tempGroup.size() > maxGroup.size()) {
                    maxGroup = tempGroup;
                    nOfRainbow = tempRainBow;
                    r = i;
                    c = j;
                } else if (tempGroup.size() == maxGroup.size() ) {
                    if (tempRainBow > nOfRainbow) {
                        maxGroup = tempGroup;
                        nOfRainbow = tempRainBow;
                        r = i;
                        c = j;
                    } else if (tempRainBow == nOfRainbow) {
                        if (i > r) {
                            maxGroup = tempGroup;
                            r = i;
                            c = j;
                        } else if (i == r && c < j) {
                            maxGroup = tempGroup;
                            r = i;
                            c = j;
                        }
                    }

                }
            }
        }

        return maxGroup.size()  >= 2;
    }

    private static void makeGroup(int r, int c) {
        q.add(new Block(r, c));
        tempRainBow = 0;
        tempGroup = new ArrayDeque<>();
        tempGroup.add(new Block(r,c));
        Queue<Block> rainbows = new ArrayDeque<>();
        visited[r][c] = true;
        while (!q.isEmpty()) {
            Block block = q.poll();

            for (int[] delta : deltas) {
                int nr = block.r + delta[0];
                int nc = block.c + delta[1];

                if ( isIn(nr, nc) && !visited[nr][nc] &&(matrix[nr][nc].equals(matrix[r][c]) || matrix[nr][nc].equals(RAINBOW))) {
                    visited[nr][nc] = true;
                    Block next = new Block(nr, nc);
                    q.add(next);
                    tempGroup.add(next);
                    if (matrix[nr][nc].equals(RAINBOW)) {
                        tempRainBow++;
                        rainbows.add(next);
                    }
                }
            }
        }

        while (!rainbows.isEmpty()) {
            Block rainbow = rainbows.poll();
            visited[rainbow.r][rainbow.c] = false;
        }


    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new String[n][n];
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = st.nextToken();
                if(s.equals("-1")) s = BLACK;
                matrix[i][j] = s;
            }
        }
    }

    static class Block {

        int r;
        int c;

        public Block(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }


}