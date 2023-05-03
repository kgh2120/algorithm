package beak.prev.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스택을 구현하는 가장 기본문제
 * 근데 자주풀기엔 좀 귀찮을지도??
 */
public class p10828 {

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new p10828().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            command(stack, new StringTokenizer(br.readLine()));
        }
        System.out.println(sb.toString());
    }

    public void command(Stack s, StringTokenizer st) {
        String command = st.nextToken();
        switch (command) {
            case "push":
                int n = Integer.parseInt(st.nextToken());
                s.push(n);
                break;
            case "top":
                sb.append(s.top()).append("\n");
                break;
            case "size":
                sb.append(s.size()).append("\n");
                break;
            case "empty":
                sb.append(s.empty()).append("\n");
                break;
            case "pop":
                sb.append(s.pop()).append("\n");
                break;
        }
    }


    class Stack{
        int pointer;
        int[] s;
        int size;

        public Stack() {
            s = new int[10];
            Arrays.fill(s,-1);
            size = 10;

        }

        public void push(int n) {
            if (pointer == size) {
                size *=2;
                s = Arrays.copyOf(s, size);
            }
            s[pointer] = n;
            pointer++;

        }

        public int pop() {
            if(pointer == 0)
                return -1;
            pointer--;
            return s[pointer];

        }
        public int size() {
            return pointer;

        }
        public int empty() {
            return pointer == 0 ? 1 : 0;
        }

        public int top() {
            return pointer == 0 ? -1 : s[pointer-1];
        }



    }
}