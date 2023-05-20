package swea.May23.s1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int height = Integer.parseInt(st.nextToken());
                maxHeap.add(height);
                minHeap.add(height);
            }

            int count = 0;
            while(count < n){
                count++;
                Integer max = maxHeap.poll();
                maxHeap.add(max-1);
                minHeap.add(minHeap.poll()+1);
            }

            System.out.println("#"+i +" " + (maxHeap.poll() - minHeap.poll()));

        }
    }


}