package beak.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {

    StringBuilder sb = new StringBuilder();

    Queue<Integer> container = new LinkedList<>();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nOfC = Integer.parseInt(br.readLine());

        for (int i = 0; i < nOfC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nOfCase = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            Integer[] weightArray = new Integer[nOfCase];
            Queue<Case> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());


            int index = 0;
            while (st.hasMoreTokens()) {
                int weight = Integer.parseInt(st.nextToken());
                weightArray[index] = weight;
                q.add(new Case(weight, index));
                index++;
            }
            Arrays.sort(weightArray, Collections.reverseOrder());


            int wIdx = 0;
            int count = 0;
            while (true) {
                Case c = q.poll();
                if (c.weight == weightArray[wIdx]) {
                    wIdx++;
                    count++;
                    if (c.originIndex == targetIndex) {
                        sb.append(count).append("\n");
                        break;
                    }
                }else{
                    q.add(c);
                }
            }

        }

        System.out.println(sb.toString());
    }


    class Case{
        private int weight;
        private int originIndex;

        public Case(int weight, int originIndex) {
            this.weight = weight;
            this.originIndex = originIndex;
        }
    }


    public static void main(String[] args) throws Exception {
        new P1966().solution();
    }
}





