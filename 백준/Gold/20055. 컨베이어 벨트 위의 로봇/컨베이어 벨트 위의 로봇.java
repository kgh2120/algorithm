import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    20055 컨베이너 벨트 위의 로봇

    주어진 벨트는 2n의 길이를 갖는다.

    각 벨트는 오른쪽으로 회전하는데, 2n의 위치에서는 1로 돌아간다.

    로봇은 n 위치에 오면 내린다.

    각 턴마다 다음과 같은 행동을 반복한다
    1. 벨트는 오른쪽으로 한칸씩 이동한다. (로봇도 함께 이동)
    2. 첫번째 로봇부터 이동가능 하다면 한칸씩 이동한다. 이동할 수 없다면 가만히 있는다.
     2-1 이동 조건은 다음 벨트에 로봇이 없고, 내구도가 1이상이어야 한다.
    3. 올리는 위치(index 0)에 내구도가 0이 아니라면 로봇을 올리낟.
    4. 내구도 0의 개수가 k개가 되면 종료한다.

    벨트 길이 N : 1 <= N <= 100
    각 벨트의 내구도 : 1 <= a <= 1000


    일단 다 돌리는 거로 풀어보자.

    벨트 전체를 돌리고, 로봇이 다음 벨트로 이동할 수 있는지를 체크하려면
    벨트 -> 로봇, 로봇 -> 벨트 의 양방향 연관관계가 필요해보임.

    벨트 인덱스를 한칸씩 조정하고, n번 위치에 로봇이 있다면 삭제해줌. -> 그런데 어떻게?? 리스트 순회하면서 찾아..? 아니면 로봇 linkedlist를 만들어서
    끊어줘??

    아니면 로봇마다 번호를 부여해서 꺼내??
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Robot head;
    static Robot tail;

    static int n;
    static Block[] blocks;
    static int nOfZeroBlock = 0;
    static int nOfRobot = 0;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        blocks = new Block[2 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            blocks[i] = new Block(Integer.parseInt(st.nextToken()), i);
        }



        int turn = 0;
        while (nOfZeroBlock < k) {
            turn++;
            // rotate

            // n check
            // robot move
            // n check
            // load robot
            rotate();
            nCheck();
            moveRobot();
            nCheck();
            loadRobot();
        }
        System.out.println(turn);


    }
    static void moveRobot(){

        Robot robot = head;

        while (robot != null) {
            int nextIndex = nextIndex(robot.block.index);
            if (blocks[nextIndex].canMove()) {
                robot.move(blocks[nextIndex]);
                if(blocks[nextIndex].hp == 0)
                    nOfZeroBlock++;
            }
            robot = robot.next;
        }
    }

    static int nextIndex(int index){
        if(++index == blocks.length)
            return 0;
        return index;
    }

    static void loadRobot() {
        if (!blocks[0].canLoad()) {
         return;
        }

        if (--blocks[0].hp == 0) {
            nOfZeroBlock++;
        }

        tail = new Robot(blocks[0], tail);
        blocks[0].robot = tail;
        nOfRobot++;
        if (head == null) {
            head = tail;
        }
    }

    static void nCheck() {
        if (blocks[n - 1].robot != null) {
            deleteRobot(blocks[n - 1].robot);
        }
    }

    private static void deleteRobot(Robot robot) {
        if (robot == head)
            head = robot.next;
        if (robot == tail)
            tail = robot.prev;
        robot.deleted();
        nOfRobot--;
    }

    static void rotate() {

        int length = blocks.length;
        Block last = blocks[length - 1];

        for (int i = length - 1; i >= 1; i--) {
            blocks[i] = blocks[i - 1];
            blocks[i].index = i;
        }
        blocks[0] = last;
        last.index = 0;
    }

    static class Block {
        int hp;
        int index;
        Robot robot;

        public Block(int hp, int index) {
            this.hp = hp;
            this.index = index;
        }

        public boolean canMove() {
            return robot == null && hp > 0;
        }


        public boolean canLoad() {
            return hp > 0;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "hp=" + hp +
                    ", index=" + index +
                    ", robot=" + robot +
                    '}';
        }
    }

    static class Robot {
        Block block;
        Robot prev;
        Robot next;

        public Robot(Block block, Robot prev) {
            this.block = block;
            if (prev != null) {
                this.prev = prev;
                prev.next = this;
            }

        }

        public void deleted() {

            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
            this.block.robot = null;
        }

        public void move(Block block) {
            this.block.robot = null;
            this.block = block;
            block.robot = this;
            block.hp--;
        }

    }
}