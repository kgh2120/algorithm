package beak.prev.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021_2 {

    StringBuilder sb = new StringBuilder();

    LinkedList<String> c = new LinkedList<>();

    int count = 0;
    int target;
    String[] arrays;



    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arrays = new String[target];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        for (int j = 1; j <= size; j++) {
            c.add(String.valueOf(j));
        }

        while (st.hasMoreTokens()) {
            arrays[i++] = st.nextToken();
        }

        for (int j = 0; j < target; j++) {

            String t = arrays[j];

            if (t.equals(c.peek())) {
                c.poll();
                continue;
            }
            
            int index = c.indexOf(t);
            int containerSize = c.size();

            int half = containerSize / 2;

            if (index <= half) {
                // left
                while (true) {
                    count++;
                    c.add(c.poll());
                    if (t.equals(c.peek())) {
                        c.poll();
                        break;
                    }
                }
            }else{
                // right
                while (true) {
                    count++;
                    c.addFirst(c.pollLast());
                    if (t.equals(c.peek())) {
                        c.poll();
                        break;
                    }
                }
            }
        }
        System.out.println(count);



    }




    public static void main(String[] args) throws Exception {
        new P1021_2().solution();
    }
}





