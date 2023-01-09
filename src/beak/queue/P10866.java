package beak.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {

    StringBuilder sb = new StringBuilder();

    Deque<String> container = new LinkedList<>();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ops(st);
        }

        System.out.println(sb.toString());
    }

    public void ops(StringTokenizer stringTokenizer){
        switch (stringTokenizer.nextToken()) {
            case "push_front" :
                container.offerFirst(stringTokenizer.nextToken());
                break;
            case "push_back" :
                container.offer(stringTokenizer.nextToken());
                break;
            case "pop_front" :
                if (container.isEmpty()) {
                    append("-1");
                } else {
                    append(container.pollFirst());
                }
                break;
            case "pop_back" :
                if (container.isEmpty()) {
                    append("-1");
                } else {
                    append(container.pollLast());
                }
                break;
            case "size" :
                append(String.valueOf(container.size()));
                break;
            case "empty" :
                append(container.isEmpty() ? "1" : "0");
                break;
            case "front" :
                append(container.isEmpty() ? "-1" : container.peekFirst());
                break;
            case "back" :
                append(container.isEmpty() ? "-1" : container.peekLast());
                break;


        }

    }

    public void append(String str) {
        sb.append(str).append("\n");
    }







    public static void main(String[] args) throws Exception {
        new P10866().solution();
    }
}





