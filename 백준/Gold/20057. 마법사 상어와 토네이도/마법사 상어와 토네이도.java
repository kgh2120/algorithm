import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
    20057 마법사 상어와 토네이도.

    토네이도가 분다. 토네이도가 불면, 기존에 위치하던 모래가 날아간다.

    모래가 날아가는 규칙은 5*5 표에 따라서 특정 지역에 확률적으로 떨어지고, 남은 부분은 어떤 위치로 떨어진다.

    토네이도는 맵의 가운데에서 부터 0,0까지 이동을 한다.

    이 과정에서 흘린 모래의 수를 계산해보자.

    필요 변수. 토네이도의 이동 경로 계산.

    흩뿌려진 배열 4개.
 */
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] deltas = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    static List<List<Block>> ss;
    static int[][][] scattered = {
            {
                    {0, 0, 2, 0, 0},
                    {0, 10, 7, 1, 0},
                    {5, 0, 0, 0, 0},
                    {0, 10, 7, 1, 0},
                    {0, 0, 2, 0, 0},
            },
            {
                    {0, 0, 0, 0, 0},
                    {0, 1, 0, 1, 0},
                    {2, 7, 0, 7, 2},
                    {0, 10, 0, 10, 0},
                    {0, 0, 5, 0, 0},
            },
            {
                    {0, 0, 2, 0, 0},
                    {0, 1, 7, 10, 0},
                    {0, 0, 0, 0, 5},
                    {0, 1, 7, 10, 0},
                    {0, 0, 2, 0, 0},
            },
            {
                    {0, 0, 5, 0, 0},
                    {0, 10, 0, 10, 0},
                    {2, 7, 0, 7, 2},
                    {0, 1, 0, 1, 0},
                    {0, 0, 0, 0, 0},
            }
    };


    static int n;

    static int[][] map;

    static int currentX;
    static int currentY;
    static int index = 0;

    static int answer;

    public static void main(String[] args) throws Exception {

        ss = new ArrayList<>();

        ss.add(Arrays.asList(
                new Block(-2, 0, 2),
                new Block(-1, -1, 10),
                new Block(-1, 0, 7),
                new Block(-1, 1, 1),
                new Block(0, -2, 5),
                new Block(2, 0, 2),
                new Block(1, -1, 10),
                new Block(1, 0, 7),
                new Block(1, 1, 1)
        ));

        ss.add(Arrays.asList(
                new Block(0, -2, 2),
                new Block(-1, -1, 1),
                new Block(0, -1, 7),
                new Block(1, -1, 10),
                new Block(2, 0, 5),
                new Block(0, 2, 2),
                new Block(-1, 1, 1),
                new Block(0, 1, 7),
                new Block(1, 1, 10)
        ));
        ss.add(Arrays.asList(
                new Block(-2, 0, 2),
                new Block(-1, 1, 10),
                new Block(-1, 0, 7),
                new Block(-1, -1, 1),
                new Block(0, 2, 5),
                new Block(2, 0, 2),
                new Block(1, 1, 10),
                new Block(1, 0, 7),
                new Block(1, -1, 1)
        ));
        ss.add(Arrays.asList(
                new Block(0, -2, 2),
                new Block(1, -1, 1),
                new Block(0, -1, 7),
                new Block(-1, -1, 10),
                new Block(-2, 0, 5),
                new Block(0, 2, 2),
                new Block(1, 1, 1),
                new Block(0, 1, 7),
                new Block(-1, 1, 10)
        ));
        /*

                    {0,0,2,0,0},      {0,0,0,0,0},           {0,0,2,0,0},         {0,0,5,0,0},
                    {0,10,7,1,0},     {0,1,0,1,0},           {0,1,7,10,0},        {0,10,0,10,0},
                    {5,0,0,0,0},      {2,7,0,7,2},           {0,0,0,0,5},         {2,7,0,7,2},
                    {0,10,7,1,0},     {0,10,0,10,0},         {0,1,7,10,0},        {0,1,0,1,0},
                    {0,0,2,0,0},      {0,0,5,0,0},           {0,0,2,0,0},         {0,0,0,0,0},
         */

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        currentX = n / 2;
        currentY = n / 2;

        int dist = 1;
        int turn = 0;
        index = 0;
        while (currentX != 0 || currentY != 0) {


            // index % 2 == 0 이면 dist++


            // 이동하기
            int prev = map[currentX][currentY];
            map[currentX][currentY] = 0;
            int[] delta = deltas[index];
            currentX += delta[0];
            currentY += delta[1];
            // 흩뿌리기
            scatter(prev);
            turn++;

            // turn이 dist랑 같아지면 index++
            if (turn == dist) {
                if (++index == 4) {
                    index = 0;
                }
                if (index % 2 == 0) {
                    dist++;
                }
                turn = 0;
            }


        }

        System.out.println(answer);

    }

    static void scatter(int prevValue) {

        // index 방향으로 흩뿌리기
        // 있다면

        // 다음 인덱스
        int[] delta = deltas[index];
        int nextX = currentX + delta[0];
        int nextY = currentY + delta[1];

        int value = map[currentX][currentY];
        map[currentX][currentY] = prevValue;

        List<Block> blocks = ss.get(index);
        int ee = value;
        for (Block block : blocks) {
            int tempX = block.r + currentX;
            int tempY = block.c + currentY;
            int v = (value * block.value) / 100;
            ee -= v;
            if (isIn(tempX, tempY)) {
                map[tempX][tempY] += v;
            }else{
                answer += v;
            }
        }

        if (isIn(nextX, nextY)) {
            map[nextX][nextY] += ee;
        }else{
            answer += ee;
        }


    }


    static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    static class Block {

        int r;
        int c;
        int value;

        public Block(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }


}