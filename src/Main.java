import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {


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

        new Main().solution();




    }

}
