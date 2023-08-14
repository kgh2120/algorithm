import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 아래 3개의 정적변수는 입출력을 위한 변수이다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	
	// 전체 사이즈를 나타내는 변수
	static int k;
	public static void main(String[] args) throws Exception {

		// 변수 설정
		int[][] deltas = setVariables();


		// 모든 매트릭스가 동일한 규칙으로 구멍이 나기 때문에, 그 규칙대로 값을 넣는다.
		for(int r = 0; r<Math.pow(2, k); r++) {
			for(int c = 0; c<Math.pow(2, k); c++) {
				// 현재 매트릭스의 위치를 규칙에 따라서 찍는다.
				// 규칙이란 처음 구멍이 찍힌 사분면의 값에 따라서 모든 매트릭스에 동일하게 찍히는 것.
				sb.append(deltas[r%2][c%2]).append(" ");
			}
			sb.append("\n");
		}

		// 연산이 끝난 후 결과를 출력한다.
		System.out.println(sb);
	}
	private static int[][] setVariables() throws IOException {
		k = Integer.parseInt(br.readLine());
		// 명령어들을 받는다. 이때 가장 마지막으로 받은 L,R // D,U를 통해 몇 사분면에 위치하는 것인지 찾는다.
		// 그리고 받는 뚫는 것을 통해 찾음.
		int pos = 0;

		
		// 현재 구멍이 뚫린 위치가 몇사분면에 위치하는지 체크
		st = new StringTokenizer(br.readLine());
		boolean isR = false; // 마지막 좌우 명령이 R인지 체크
		boolean isD = false; // 마지막 상하 명령이 D인지 체크
		for (int i = 0; i < Math.pow(2, k); i++) {
			switch (st.nextToken()) {
			case "R":
				isR = true;
				break;
			case "L":
				isR = false;
				break;
			case "U":
				isD = false;
				break;
			case "D":
				isD = true;
				break;
			}
		}
		// 마지막 UD / LR을 통해서 뚫을 위치가 0~3 사분면 중 어디에 속하는지 체크
		// 아래 그림처럼 우측에 있다면 1을 추가하고, 하단에 있다면 2를 추가한다.
		// 0 1   
		// 2 3
		if (isR)
			pos += 1;
		if (isD)
			pos += 2;


		
		
		// pos 값을 통해 2차원 배열에서 그 위치를 표현
		// 0 -> 0,0   1 -> 0,1   2 -> 1,0   3 -> 1,1로 변환
		int row = 0;
		int col = 0;
		if (pos > 1)
			row = 1;
		if (pos % 2 == 1)
			col = 1;

		// 구멍을 뚫는 위치를 찾는다. 그리고 그 와 구멍이 뚫린 장소의 사분면을 통해 인근에 구멍이 어떻게 뚫렸는지 찾음.
		int blankPosition = Integer.parseInt(br.readLine());
		int[][] deltas = new int[2][2];
		deltas[row][col] = blankPosition;
		// 구멍이 뚫린 위치 기준 좌우는 +- 2, 위 아래는 +- 1의 규칙을 갖고 있다.
		// 좌 우에서 내가 더 큰 값이라면 상대는 나보다 1 작은 값, 내가 더 작다면 상대는 나보다 1 더 큰 값 (0 1 2 3 기준)
		int side = blankPosition % 2 == 1 ? blankPosition - 1 : blankPosition + 1;
		// 상하에서 내가 더 큰 값이라면 상대는 나보다 2 작은 값, 내가 더 작다면 상대는 나보다 2 더 큰 값
		int ud = blankPosition > 1 ? blankPosition - 2 : blankPosition + 2;
		// 현재 사분면에 위치에 따라서 상하,좌우 대칭되는 위치를 2차원 배열 상에서 찾는다.
		int i = 0;
		int j = 0;
		// 현재가 우측에 있다면, 대칭되는 위치는 좌측에 있음.
		if (col == 1)
			i = -1;
		else
			// 현재가 좌측에 있으면 대칭되는 위치는 우측에 있음.
			i = 1;
		
		// 현재가 하단에 있다면 대칭되는 위치는 상단에 있음
		if (row == 1)
			j = -1;
		// 현재가 상단에 있다면 대칭되는 위치는 하단에 있음.
		else
			j = 1;
		// 상하, 좌우, 대각에 넣을 값을 채워준다.
		deltas[row][col + i] = side;
		deltas[row + j][col] = ud;
		// 대각에 위치한 값은 좌우,상하 대칭한 값 - 현재 위치의 값이다.
		deltas[row+j][col+i] = side + ud - blankPosition;
		return deltas;
	}
}