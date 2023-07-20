package beak.Jul2023.p11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                if (Math.abs(i1) == Math.abs(i2))
                    if(i1 < i2)
                        return -1;

                if(Math.abs(i1) < Math.abs(i2))
                    return -1;
                return 1;
            }
        });

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command!=0)
                absHeap.add(command);
            else {
                if(absHeap.isEmpty())
                    append(0);
                else
                    append(absHeap.poll());
            }
        }

        System.out.println(sb);
    }
    private static void append(Integer num){
        sb.append(num)
                .append("\n");
    }

}