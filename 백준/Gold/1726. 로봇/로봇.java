import java.util.*;
import java.io.*;


/*

    이동 명령 GO -> 최대 3칸
    방향 틀기 명령 왼쪽, 오른쪽

    이 명령들을 섞어서 최소한의 턴으로 원하는 위치에 원하는 방향으로 만들어야함.

    그리고 0이면 갈 수 있고, 1이면 못간다.

    가장 간단하게 생각하면 BFS형태로 진행이 가능해보임.
    그런데 Visited 체크를 할 때, 위치 + 방향까지 기록하는 것이 맞아보인다.

    전체 판의 크기는 100 * 100으로 앵간하면 1만회 안에는 도달할 것으로 보임.
    시간 문제는 없어보인다.

    왼쪽과 오른쪽을 고려한 delta 세팅을 만들어준다면 큰 어려움이 없지 않을까 싶음.
*/
public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int maxRow;
    static int maxCol;
    static boolean [][][] visited;
    static int[][] map;

    static Queue<Robot> robotQueue = new ArrayDeque<>();

    static final boolean TURN_LEFT_SIGN = false;
    static final boolean TURN_RIGHT_SIGN = true;

    static final int PATH = 0;

    static int[][] deltas = {{1, 0}, {0,-1}, {-1,0}, {0,1}}; // 남 서 북 동

    static Robot start;
    static Robot end;

    static boolean findShortestPathSign;
    static int turn = 1;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        initialize();
        int answer = findShortestPath();
        System.out.println(answer);

    }


    static int findShortestPath(){

        robotQueue.add(start);
        visited[start.direction][start.row][start.col] = true;
//        int turn = 1;

        if(end.isSame(start))
            return 0;

        while(!robotQueue.isEmpty()){

            int size = robotQueue.size();

            while(size-->0){

                Robot current = robotQueue.poll();

                // 왼쪽으로 비비고
                registerTurningAction(current, TURN_LEFT_SIGN);
                // 오른쪽으로 비비고
                registerTurningAction(current, TURN_RIGHT_SIGN);
                // 1,2,3으로 이동하고
                registerMovingAction(current);

            }

            if(findShortestPathSign)
                break;
            turn++;

        }
        return turn;
    }

    static void registerMovingAction(Robot robot){

        int currentDirection = robot.direction;
        int currentRow = robot.row;
        int currentCol = robot.col;


        for(int i = 1; i<=3 ; i++){

            int nextRow = currentRow + deltas[currentDirection][0] * i;
            int nextCol = currentCol + deltas[currentDirection][1] * i;

            if(!canAccess(nextRow, nextCol))
                break;

            if(isFirstAccess(currentDirection, nextRow, nextCol)){
                registerRobotToQueue(nextRow, nextCol, currentDirection);
            }

        }

    }

    static void registerTurningAction(Robot robot, boolean turnSign){
        int currentDirection = robot.direction;
        int currentRow = robot.row;
        int currentCol = robot.col;

        // 왼쪽로 비비고
        int nextDirection = turnDirection(currentDirection,turnSign);
        if(isFirstAccess(nextDirection, currentRow, currentCol)){
            registerRobotToQueue(currentRow, currentCol, nextDirection);
        }
    }

    static void registerRobotToQueue(int row, int col, int direction){


        Robot robot = new Robot(row, col, direction);



        if(end.isSame(robot)){
            findShortestPathSign = true;
            return;
        }

        robotQueue.add(robot);
        visited[direction][row][col] = true;


    }

    static boolean isFirstAccess(int direction, int row, int col){
        return !visited[direction][row][col];
    }

    static boolean canAccess(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol &&
                map[row][col] == PATH;
    }


    // 방향은 동쪽이 1, 서쪽이 2, 남쪽이 3, 북쪽이 4로 주어진다
    static int setDirection(int origin){
        switch(origin){
            case 1 : return 3;
            case 2 : return 1;
            case 3 : return 0;
            case 4 : return 2;
            default :
                return -1;
        }
    }

    static void initialize() throws Exception{

        st = new StringTokenizer(input.readLine());
        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());

        map = new int[maxRow][maxCol];
        visited = new boolean[4][maxRow][maxCol];

        for(int row = 0; row < maxRow; row++){
            st = new StringTokenizer(input.readLine());
            for(int col = 0; col < maxCol; col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }


        start = parseRobotFromInput(input.readLine());
        end = parseRobotFromInput(input.readLine());
    }

    static Robot parseRobotFromInput(String input){
        st = new StringTokenizer(input);
        int row = Integer.parseInt(st.nextToken()) -1;
        int col = Integer.parseInt(st.nextToken()) -1;
        int direction = Integer.parseInt(st.nextToken());

        return new Robot(row,col, setDirection(direction));

    }

    static int turnDirection(int currentDirection, boolean turnSign){

        int nextNumber = turnSign ? 1 : -1;
        int nextDirection = currentDirection+ nextNumber;

        return adjustDirection(nextDirection);
    }

    static int adjustDirection(int direction){
        if(direction== -1)
            return 3;
        if(direction== 4)
            return 0;
        return direction;
    }

    static class Robot {
        int row;
        int col;
        int direction;

        public Robot(int row, int col, int direction){
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        public boolean isSame(Robot other){
            return row == other.row && col == other.col && direction == other.direction;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "row=" + row +
                    ", col=" + col +
                    ", direction=" + direction +
                    '}';
        }
    }
}