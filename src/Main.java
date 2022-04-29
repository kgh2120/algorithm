
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Deque<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stacks.add(new ArrayDeque<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int con = sc.nextInt();
                if (con == 0)
                    continue;
                stacks.get(j).add(con);
            }
        }

        Queue<Integer> logic = new ArrayDeque<>();
        int nOfLogic = sc.nextInt();
        for (int i = 0; i < nOfLogic; i++) {
            logic.add(sc.nextInt());
        }
        // 로직 시작

        int result = 0;
        Stack<Integer> answerStack = new Stack<>();
        while (logic.size() != 0) {
            Integer stackNo = logic.poll();
            Deque<Integer> stack = stacks.get(stackNo-1);
            if(stack.isEmpty())
                continue;
            Integer pop = stack.pop();
            if (!answerStack.empty() &&pop.equals(answerStack.peek())) {
                answerStack.pop();
                result += 2;
            } else {
                answerStack.push(pop);
            }
        }
        System.out.println(result);
    }
}
