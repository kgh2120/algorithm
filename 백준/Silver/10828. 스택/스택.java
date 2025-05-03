import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static CustomStack stack = new CustomStack();
    static StringBuilder answer = new StringBuilder();

    static final String PUSH_COMMAND = "push";
    static final String POP_COMMAND = "pop";
    static final String SIZE_COMMAND = "size";
    static final String EMPTY_COMMAND = "empty";
    static final String TOP_COMMAND = "top";


    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());

            String operation = st.nextToken();

            switch(operation){
                case PUSH_COMMAND  :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case POP_COMMAND :
                    answer.append(stack.pop()).append("\n");
                    break;
                case SIZE_COMMAND :
                    answer.append(stack.size()).append("\n");
                    break;
                case EMPTY_COMMAND :
                    answer.append(stack.empty()).append("\n");
                    break;
                case TOP_COMMAND :
                    answer.append(stack.top()).append("\n");
                    break;
            }
        }

        System.out.print(answer);


    }



    static class CustomStack{
        private final Deque<Integer> stack = new ArrayDeque<>();

        public void push(int x) {
            stack.push(x);
        }

        public int pop(){
            if(stack.isEmpty())
                return -1;
            return stack.pop();
        }

        public int size(){
            return stack.size();
        }
        public int empty(){
            return stack.isEmpty() ? 1 : 0;
        }

        public int top(){
            if(stack.isEmpty())
                return -1;
            return stack.peekFirst();
        }
    }

}
