package beak.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P2164 {

    StringBuilder sb = new StringBuilder();

    Queue<Integer> q = new ArrayDeque<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfCommand = Integer.parseInt(br.readLine());
        for (int i = 1; i <= nOfCommand; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek());
    }


    public static void main(String[] args) throws Exception {
        new P2164().solution();
    }
}





