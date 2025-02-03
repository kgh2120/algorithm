import java.io.*;
import java.util.*;

/**
 * 고려할 점.
 * <p>
 * 1. 루프에 대한 중첩 상황 -> 루프 시작 좌표를 스택에 넣어서 관리하는 것이 맞아보임.
 * 루프를 탈출하면 스택에서 빼는 걸로 하자. 다시 들어가면 peek로만 사용히고
 * <p>
 * 2. 무한루프 체크하기
 * 50,000,000번 이상 수행한 경우 무한루프 or 종료
 * 전체 카운팅이 5천만이 넘는 상황에서 루프에 있는데, 루프가 또 돌았다? 그럼 무한루프. 그 외엔 종료 체크
 * <p>
 * 3. 명령어 체크하기
 * 무시해도 되는거 -> .
 * , 에 대해서는 EOF만 체크해줘. charArray로 받고, 인덱스 나가면 255 넣어주기.
 * - + 에 대해서 범위 체크해주기.
 * > < 에 대해서 범위 체크해주기.
 * [와 ]가 나오는 경우 루프로 묶이면 해당 루프를 끝까지 탔는지, 시작 루프에 대한 주소를 체크해주기.
 */

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] memory;
    static char[] commands;
    static char[] inputData;

    static int memoryPointer;
    static int commandPointer;
    static int inputPointer;

    static final int EOF = 255;

    static int memorySize;
    static int programSize;
    static int inputSize;

    static final int MAX_COUNT = 50_000_000;

    static Deque<Integer> loopStack;

    static int nOfOps;

    static final String END = "Terminates";
    static final String INF_LOOP = "Loops";

    static Map<Integer, Integer> loopPair;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            init();
            boolean isTerminated = false;
            while (nOfOps++ <= MAX_COUNT) {
                // 일단 커서대로 움직여
                char action = commands[commandPointer];

                action(action);
                if (++commandPointer == programSize) {
                    sb.append(END).append("\n");
                    isTerminated = true;
                    break;
                }
            }

            if (isTerminated)
                continue;


            int min = commandPointer;
            int max = commandPointer;
            int k = 0;
            while (k++ <= MAX_COUNT) {
                char action = commands[commandPointer];
                action(action);
                min = Math.min(min, commandPointer++);
                
                max = Math.max(max, commandPointer);
                
            }
            sb.append(INF_LOOP)
                    .append(" ")
                    .append(min)
                    .append(" ")
                    .append(max)
                    .append("\n");

        }
        System.out.print(sb);


    }

    private static void action(char action) {
        switch (action) {
            case '+':
                add();
                break;
            case '-':
                minus();
                break;
            case '<':
                moveLeft();
                break;
            case '>':
                moveRight();
                break;
            case '[':
                openLoop();
                break;
            case ']':
                closedLoop();
                break;
            case ',':
                comma();
                break;
        }
        
    }

    private static void add() {
        memory[memoryPointer] = (++memory[memoryPointer]) % 256;
    }

    private static void minus() {

        if (--memory[memoryPointer] == -1) {
            memory[memoryPointer] = EOF;
        }
    }

    private static void moveRight() {
        if (++memoryPointer == memorySize) {
            memoryPointer = 0;
        }
    }

    private static void moveLeft() {
        if (--memoryPointer == -1) {
            memoryPointer = memorySize - 1;
        }
    }

    private static void openLoop() {


        if (!loopPair.containsKey(commandPointer)) {
            int tmp = commandPointer;
            int k = 1;
            while (true) {
                char c = commands[++tmp];
                if (c == '[') {
                    k++;
                } else if (c == ']' && --k == 0) {
                    break;
                }
            }
            loopPair.put(commandPointer, tmp);

        }


        if (memory[memoryPointer] == 0) {
            commandPointer = loopPair.get(commandPointer);
        } else {
            loopStack.push(commandPointer);
        }
    }


    private static void closedLoop() {
        if (memory[memoryPointer] != 0) {
            commandPointer = loopStack.peek();
        } else {
            loopStack.poll();
        }
    }

    private static void comma() {
        if (inputPointer < inputSize) {
            memory[memoryPointer] = inputData[inputPointer];
        } else {
            memory[memoryPointer] = EOF;
        }
        inputPointer++;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(input.readLine());

        memorySize = Integer.parseInt(st.nextToken());
        programSize = Integer.parseInt(st.nextToken());
        inputSize = Integer.parseInt(st.nextToken());

        commands = input.readLine().toCharArray();
        inputData = input.readLine().toCharArray();

        memory = new int[memorySize];
        memoryPointer = 0;
        commandPointer = 0;
        inputPointer = 0;
        nOfOps = 0;

        loopStack = new ArrayDeque<>();
        loopPair = new HashMap<>();


    }


}