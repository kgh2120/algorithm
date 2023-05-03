package beak.prev.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {

    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> container = new LinkedList<>();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            container.add(i);
        }

        while (!container.isEmpty()) {
            int k = 0;
            while (k != c-1) {
                container.add(container.poll());
                k++;
            }
            q.add(container.poll());
        }


        System.out.println(q.toString().replace('[','<').replace(']','>'));
    }


    public static void main(String[] args) throws Exception {
        new P11866().solution();
    }
}





