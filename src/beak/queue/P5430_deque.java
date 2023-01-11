package beak.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P5430_deque {

    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        loop:
        for (int i = 0; i < n; i++) {

            // 명령 받기
            String commands = br.readLine();
            // 배열 개수
            int nOfArray = Integer.parseInt(br.readLine());
            // 배열 받기
            String[] arrays = br.readLine().replace('[', ' ').replace(']', ' ').trim().split(",");
            Deque<String> d = new LinkedList<>();
            d.addAll(Arrays.asList(arrays));

            boolean reverse = false;
            for (int j = 0; j < commands.length(); j++) {
                if (commands.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (nOfArray == 0) {
                        sb.append("error").append("\n");
                        continue loop;
                    }

                    if (reverse) {
                        if (d.pollLast() == null) {
                            sb.append("error").append("\n");
                            continue loop;
                        }
                    } else {
                        if (d.pollFirst() == null) {
                            sb.append("error").append("\n");
                            continue loop;
                        }
                    }
                }
            }

            sb.append("[");
            if (reverse) {
                while (!d.isEmpty()) {
                    sb.append(d.pollLast()).append(",");

                    if (d.size() == 0) {
//                        System.out.println(sb.charAt(sb.length() - 1));
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }

            } else {
                while (!d.isEmpty()) {
                    sb.append(d.pollFirst()).append(",");

                    if (d.size() == 0) {
//                        System.out.println(sb.charAt(sb.length() - 1));
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
            sb.append("]").append("\n");

        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) throws Exception {
        new P5430_deque().solution();
    }
}





