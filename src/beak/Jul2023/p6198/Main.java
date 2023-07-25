package beak.Jul2023.p6198;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) throws Exception {
    	n = Integer.parseInt(br.readLine());
    	PriorityQueue<Building> pq = new PriorityQueue<>(new Comparator<Building>() {
    		public int compare(Building b1, Building b2) {
    			return Integer.compare(b1.height, b2.height);
    		}
    	});
    	
    	long result = 0;
    	for(int i = 0; i<n; i++) {
    		int height = Integer.parseInt(br.readLine());
    		while(!pq.isEmpty() && pq.peek().height <= height) {
    			Building poll = pq.poll();
    			result += i - poll.idx - 1;
    		}
    		pq.add(new Building(i, height));
    	}
    	
    	while(!pq.isEmpty()) {
    		Building poll = pq.poll();
			result += n - poll.idx - 1;
    	}
    	
    	System.out.println(result);

    }
    static class Building{
    	int idx;
    	int height;
		public Building(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
    	
    	
    }