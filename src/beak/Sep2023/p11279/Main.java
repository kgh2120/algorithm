package beak.Sep2023.p11279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {

    static  StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                if (maxHeap.isEmpty()) {
                    append(0);
                } else {
                    append(maxHeap.poll());
                }
            } else {
                maxHeap.add(command);
            }
        }
        System.out.println(sb);
    }

    private static void append(Object o){
        sb.append(o)
                .append("\n");
    }
}