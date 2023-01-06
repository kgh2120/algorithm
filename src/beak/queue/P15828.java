package beak.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P15828 {

    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfQ = Integer.parseInt(br.readLine());


        int command = 0;
        while (command != -1) {
            command = Integer.parseInt(br.readLine());
            switch (command){
                case 0 :
                    q.poll();
                    break;
                case -1 :
                    break;
                default:
                    if (q.size() != sizeOfQ) {
                        q.add(command);
                    }
                    break;
            }
        }

        if (q.isEmpty()) {
            sb.append("empty");
        } else {
            for (Integer integer : q) {
                sb.append(integer).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        new P15828().solution();
    }
}





