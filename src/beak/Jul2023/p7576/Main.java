package beak.Jul2023.p7576;
import java.io.*;
import java.util.*;

public class Main {
	static int n,m, nOfTarget;
	static List<int[]> startPoint;
	static int[][] matrix;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		startPoint = new ArrayList<>();
		
		matrix = new int[n][m];
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<m;j++) {
				int to = Integer.parseInt(st.nextToken());
				matrix[i][j] = to;
				if(to == 0)
					nOfTarget++;
				if(to == 1) {
					nOfTarget++;
					startPoint.add(new int[]{i,j});
				}
					
			}
		}
		
		
		System.out.println(bfs());
		
		
	}
	private static int bfs() {
		int[][] deltas = {
				{-1,0},{1,0},{0,-1},{0,1}
		};
		int last = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		for (int[] is : startPoint) {
			queue.add(new int[] {is[0],is[1]});
		}
		
			
		
		while(!queue.isEmpty()) {
			
			int[] point = queue.poll();
			last = Math.max(matrix[point[0]][point[1]], last);
			nOfTarget--;
			if(nOfTarget == 0)
				break;

			for(int[] del : deltas) {
				if(point[0]+del[0] >=0 && point[0]+del[0] <n && point[1]+del[1] >=0 && point[1]+del[1] < m && matrix[point[0]+del[0]][point[1]+del[1]] == 0) {
					queue.add(new int[] {point[0]+del[0], point[1]+del[1]});
					matrix[point[0]+del[0]][point[1]+del[1]] = matrix[point[0]][point[1]]+1;
					
				}
			}
		}
		
		if(nOfTarget != 0)
			return -1;
		else 
			return last-1;
		
	}
	


}