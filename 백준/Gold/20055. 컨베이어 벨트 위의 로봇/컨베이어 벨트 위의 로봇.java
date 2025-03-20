import java.io.*;
import java.util.*;

/**

 동작 순서
 1. 벨트가 시계방향으로 회전함.
 2. 놓인 순서대로 로봇이 시계방향으로 이동함.(가능하면)
 다음 위치에 로봇이 있거나, 내구도가 0 이 아니라면 이동
 3. 시작 위치에 로봇 올리기(내구도가 0이 아니라면)
 4. 종료조건 체크(내구도 0인 칸 개수 체크)


 우선은.. 로봇 순서 체크해줘야함. -> 리스트로 관리
 칸은 배열로 관리해주고, 배열 이동에 대해서는 포인터로 시작, 끝 위치만 조정해주면서 원형 배열처럼 쓰면 될듯함.

 로봇은 칸 인덱스만 가지고 있으면 될듯.

 **/

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static Block[] belt;
    static int startIdx;

    static int n;
    static int k;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        belt = new Block[n*2];
        List<Robot> robots = new ArrayList<>();
        for(int i = 0; i<n*2; i++){
            belt[i] = new Block(Integer.parseInt(st.nextToken()));
        }

        int numberOfZeroBelt = 0;

        int level = 0;
        int endIdx;
        while(numberOfZeroBelt < k){
            level++;
            // 벨트 이동
            startIdx = rotateBelt(startIdx);
            endIdx = moveForward(startIdx + n - 2);
            // 이동 후 라스트 벨트에 있는 로봇은 삭제.
            Block lastBlock = belt[endIdx];
            if(lastBlock.hasRobot()){
                lastBlock.deleteRobot();
            }
            // 로봇 이동
            for(Robot robot : robots){
                if(robot.isDeleted) continue;

                int nextIdx = moveForward(robot.blockIndex);
                if(belt[nextIdx].hasRobot() || belt[nextIdx].health <= 0) continue;


                belt[robot.blockIndex].deleteRobot();
                belt[nextIdx].registerRobot(robot);
                robot.blockIndex = nextIdx;

                belt[nextIdx].health--;
            }

            if(lastBlock.hasRobot()){
                lastBlock.deleteRobot();
            }

            for(int i = robots.size()-1; i>=0; i--){
                Robot robot = robots.get(i);
                if (robot.isDeleted) {
                    robots.remove(i);

                }
            }
            // 로봇 올리기
            if(belt[startIdx].health > 0){
                Robot newRobot = new Robot(startIdx);
                belt[startIdx].registerRobot(newRobot);
                robots.add(newRobot);
                belt[startIdx].health--;
            }

            // 카운팅 후 종료
            numberOfZeroBelt = 0;
            for (Block block : belt) {
                if(block.health <= 0)
                    numberOfZeroBelt++;
            }
        }
        System.out.println(level);


    }
    static int moveForward(int index){
        return (index+1) % (2*n);
    }

    static int rotateBelt(int index){
        if(index == 0)
            return 2*n-1;
        return index-1;
    }

    static class Robot{
        int blockIndex;
        boolean isDeleted;


        public Robot(int index){
            this.blockIndex = index;
        }

        public void deleted(){
            this.isDeleted = true;
            this.blockIndex = -1;
        }
    }
    static class Block{
        int health;
        Robot robot;


        public Block(int health){
            this.health = health;
        }

        public boolean hasRobot(){
            return robot != null;
        }

        public void deleteRobot(){
            this.robot.deleted();
            this.robot = null;
        }
        public void registerRobot(Robot robot){
            this.robot = robot;
            robot.isDeleted = false;
        }
    }
}
