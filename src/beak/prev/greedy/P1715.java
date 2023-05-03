package beak.prev.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *  그리디 알고리즘 골드 4
 *  규칙은 좀 일찍 안거 같은데.. 시간초과 및 메모리 이슈가 발생함.
 *  그래서 우선순위 큐를 적용해서 풀어보니 풀렸다.
 */
public class P1715 {


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }


        long total = 0;
        while(pq.size() != 1){
            Long p1 = pq.poll();
            Long p2 = pq.poll();
            total += p1+p2;
            pq.add(p1+p2);
        }

        System.out.println(total);



    }




    public static void main(String[] args) throws IOException {

        new P1715().solution();




    }

}
