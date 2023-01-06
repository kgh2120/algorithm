package beak.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P18258 {

    StringBuilder sb = new StringBuilder();

    Queue<String> queue = new ArrayDeque<>();
    String end = "";

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfCommand = Integer.parseInt(br.readLine());
        for (int i = 0; i < nOfCommand; i++) {
            operator(br.readLine().split(" "));
        }

        System.out.println(sb.toString());

    }


    public void operator(String... args) {
        switch (args[0]) {
            case "push":
                push(args[1]);
                break;
            case "pop":
                pop();
                break;
            case "size":
                size();
                break;
            case "empty":
                empty();
                break;
            case "front":
                front();
                break;
            case "back":
                back();
                break;
        }
    }

    public void push(String num) {
        queue.add(num);
        end = num;
    }

    public void pop() {
        if (queue.isEmpty()) {
            sb.append(-1)
                    .append("\n");
        } else {
            sb.append(queue.poll())
                    .append("\n");
        }
    }

    public void size() {
        append(String.valueOf(queue.size()));
    }

    public void empty() {
        append(queue.isEmpty() ? "1" : "0");

    }

    public void front() {
        append(queue.isEmpty() ? "-1" : queue.peek());

    }

    public void back() {
        append(queue.isEmpty() ? "-1" : end);

    }

    public void append(String str){
        sb.append(str).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new P18258().solution();
    }
}





