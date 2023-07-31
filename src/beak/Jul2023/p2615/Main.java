package beak.Jul2023.p2615;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][][] matrix = new int[19][19][5];
	static int[][] deltas = {
			{1,0},
			{0,1},
			{1,1},
			{-1,1}
	};
	static final int NUM_IDX = 4;
	static final int END = 19;
	static final int VISITED = 1;

	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i<END; i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j = 0; j<END; j++) 
				matrix[i][j][NUM_IDX] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int j = 0; j<END; j++) {
			for(int i = 0; i<END; i++) {
				if(matrix[i][j][NUM_IDX] == 0)
					continue;
				int color = matrix[i][j][NUM_IDX];
				for(int delIdx = 0; delIdx < deltas.length; delIdx++) {
					if(matrix[i][j][delIdx] == VISITED)
						continue;
					int[]del = deltas[delIdx];
					int depth = 0;
					while(isIn(i+del[0] * depth, j + del[1 ]* depth) && matrix[i+del[0] * depth][j+del[1] * depth][NUM_IDX] == color) {
						matrix[i+del[0] * depth][j+del[1] * depth][delIdx] = VISITED;
						depth++;
					}
					if(depth == 5) {
						sb.append(color).append("\n")
							.append(i+1).append(" ").append(j+1);
						System.out.println(sb);
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
	
	private static boolean isIn(int row, int col) {
		return row >= 0 && row < END && col >= 0 && col < END;
	}
	

}