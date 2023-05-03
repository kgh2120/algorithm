package beak.prev.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021 {

    StringBuilder sb = new StringBuilder();

    Deque<String> c = new LinkedList<>();
    Deque<String> l = new LinkedList<>();
    Deque<String> r = new LinkedList<>();
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


        logic(0);



        System.out.println(count);



    }

    public void logic(int depth){
        if (depth == target) {
            return;
        }

        if (arrays[depth].equals(c.peekFirst())) {
            c.pollFirst();
            logic(depth+1);
        }else{
            int right = right(depth);
            int left = left(depth, right);
            if (right > left) {
                c = new LinkedList<>(l);
                count += left;
            }else {
                c = new LinkedList<>(r);
                count += right;
            }
            logic(depth+1);
        }
    }

    public Deque<String> copy(){
        return new LinkedList<>(c);
    }

    public int right(int  depth){
        r = copy();
        String targetNum = arrays[depth];
        int count = 1;
        while (true) {

            String poll = r.pollLast();
            r.addFirst(poll);


            if (!targetNum.equals(poll)) {
                count ++;
            } else {
                r.pollFirst();
                break;
            }

        }
        return count;

    }

    public int left(int depth, int right){
        l = copy();
        String targetNum = arrays[depth];
        int count = 1;
        while (true) {
            if (count >= right) {
                return Integer.MAX_VALUE;
            }
            String poll = l.poll();
            l.add(poll);

            if (!targetNum.equals(l.peek())) {
                count ++;
            } else {
                l.poll();
                break;
            }
        }
        return count;
    }




    public static void main(String[] args) throws Exception {
        new P1021().solution();
    }
}





