package beak.Jul2023.p1158;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<>();
		for(int i = 1; i<=n; i++)
			q.add(i);
		sb.append('<');
		int cursor = 0;
		int size = n;
		while(!q.isEmpty()) {
			cursor = (cursor + k-1) % size;
			int target = q.remove(cursor);
			if(size != 1)
				sb.append(target)
					.append(", ");
			else {
				sb.append(target);
			}
			size--;
		}
		sb.append('>');
		System.out.println(sb);
	}
}