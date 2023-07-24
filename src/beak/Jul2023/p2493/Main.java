package beak.Jul2023.p2493;


import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] list;
	static int [] answer;
	static PriorityQueue<Tower> pq;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		list = new int[n];
		answer = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>(new Comparator<Tower>() {
			public int compare(Tower left, Tower right) {
				return left.height - right.height;
			}
		});
		
		pq.add(new Tower(list.length-1, list[list.length-1]));
		
		for(int i = list.length-2; i>=0; i--) {
			while(!pq.isEmpty() && pq.peek().height < list[i]) {
				Tower t = pq.poll();
				answer[t.idx] = i+1;
			}
			pq.add(new Tower(i, list[i]));
		}
		
		for (int i : answer) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	
	}


	static class Tower{
		
		int idx;
		int height;
		public Tower(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
		
		
	}

}