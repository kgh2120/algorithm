import java.util.*;
import java.io.*;

/**

 게임 규칙
 - 먹을 수 있는 것이 없으면 게임 종료
 - 먹는다 : 내 크기보다 작으면 먹기 가능
 - 먹기 위해선 인접한 위치로 이동해가며 물고기를 먹는다.
 - 물고기를 먹을 땐 아래의 규칙을 따른다.
 1. 가장 가까운 물고기를 먹는다.
 2. 가장 가까운 물고기가 1개가 아니라면, 위쪽, 왼쪽 순으로 우선순위를 주고 먹는다. // 이동 경로를 짤 때, 상,좌,우,하 순으로 이동하면 될듯? 아니면 PQ사용
 - 이동을 할 때엔 나와 크기가 같거나, 작은 물고기로만 이동이 가능하다.

 **/
public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;



    static int mapSize;

    static int[][] map;

    static Shark shark;


    static int[][] deltas = {{-1,0}, {0,-1}, {0,1}, {1,0}};

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        initialize();
        int result = hungryShark();
        System.out.println(result);


    }

    static int hungryShark(){

        int totalCost = 0;

//        System.out.println("START---");
//        printMap();

        int turn = 0;
        while (true) {
            int cost = eatFish();

//            System.out.println(++turn);
//            printMap();


            if(cost == -1)
                return totalCost;
            totalCost += cost;
        }
    }

    static void printMap(){
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }


    static int eatFish(){

        Queue<Shark> q = new ArrayDeque<>();
        q.add(shark);

        boolean[][] visited = new boolean[mapSize][mapSize];
        visited[shark.row][shark.col] = true;

        Queue<Fish> fishPq = new PriorityQueue<>();


        int cost = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            boolean findTargetFish = false;
            cost++;
            while (size-- > 0) {
                Shark current = q.poll();

                // 일단 움직여

                for (int[] delta : deltas) {
                    int nr = current.row + delta[0];
                    int nc = current.col + delta[1];

                    if (isIn(nr, nc)) {
                        int targetSize = map[nr][nc];
                        if (current.canMove(targetSize) && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            if (current.canEat(targetSize)) {
                                findTargetFish = true;
                                fishPq.add(new Fish(nr, nc));
                            } else {
                                q.add(new Shark(nr, nc));
                            }

                        }
                    }
                }

            }

            if (findTargetFish) {
                Fish fish = fishPq.poll();
                shark = shark.eat(fish);
                map[fish.row][fish.col] = 0;
                return cost;
            }
        }
        return -1;
    }




    // 입력 받기
    static void initialize() throws Exception{
        mapSize = Integer.parseInt(input.readLine());

        map = new int[mapSize][mapSize];

        for(int i = 0; i<mapSize; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j<mapSize; j++){
                int value = Integer.parseInt(st.nextToken());

                map[i][j] = value;

                if(value == 9){
                    map[i][j] = 0;
                    shark = new Shark(i,j);
                }
            }
        }
    }

    // 주어진 값이 2차원 배열의 범위 내에 있는지 체크
    static boolean isIn(int row, int col){
        return row >= 0 && row < mapSize && col >= 0 && col < mapSize;
    }


    static class Fish implements Comparable<Fish>{
        int row;
        int col;

        public Fish(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Fish o) {
            int rowCompare = Integer.compare(row, o.row);
            if(rowCompare == 0)
                return Integer.compare(col, o.col);
            return rowCompare;
        }
    }


    static class Shark{
        int row;
        int col;
        static int size = 2;
        static int eatCount;

        public Shark(int row, int col){
            this.row = row;
            this.col = col;
        }



        public Shark eat(Fish fish){
            if(++eatCount == size){
                size++;
                eatCount = 0;
            }
            return new Shark(fish.row, fish.col);
        }

        public boolean canMove(int targetSize){
            return size >= targetSize;
        }

        public boolean canEat(int targetSize){
            return targetSize > 0 && size > targetSize;
        }
    }

}
