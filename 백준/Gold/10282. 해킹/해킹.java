import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder();
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		int TC = readInt();
		while (TC-- > 0) {
			int n = readInt();
			int d = readInt();
			int c = readInt();
			ArrayList<Node>[] graph = new ArrayList[n + 1]; 
			for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
 			for (int i = 0; i < d; i++) {
				int n1 = readInt();
				graph[readInt()].add(new Node(n1, readInt()));
			}
 			
 			Queue<Node> q = new PriorityQueue<>();
 			q.add(new Node(c, 0));
 			
 			boolean[] visited = new boolean[n + 1];
 			
 			int[] list = new int[n + 1];
 			Arrays.fill(list, INF);
 			list[c] = 0;
 			
 			while(!q.isEmpty()) {
 				Node cur = q.poll();
 				visited[cur.n] = true;
 				if (cur.w > list[cur.n]) continue;
 				for (Node next : graph[cur.n]) {
 					if(list[next.n] < list[cur.n] + next.w) continue;
 					if(visited[next.n] && next.w == 0) continue;
 					list[next.n] = list[cur.n] + next.w;
 					q.add(new Node(next.n, list[next.n]));
 				}
 			}
 			int cnt = 0;
 			int time = 0;
 			for (int t : list) {
 				if (t == INF) continue;
 				cnt++;
 				time = Math.max(time, t);
 			}
 			res.append(String.format("%d %d\n", cnt, time));
 		}
		System.out.println(res);
 	}
	
	static class Node implements Comparable<Node> {
		int n, w;
	
		Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Main.Node o) {
			return this.w - o.w;
		}
	}

	static int readInt() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
