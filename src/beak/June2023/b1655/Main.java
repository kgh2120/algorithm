package beak.June2023.b1655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x,y)-> x-y);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);

        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(k);

            }
            else{
                minHeap.add(k);
            }

            if(!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
                int min = minHeap.poll();
                int max = maxHeap.poll();
                minHeap.add(max);
                maxHeap.add(min);
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);


    }






}