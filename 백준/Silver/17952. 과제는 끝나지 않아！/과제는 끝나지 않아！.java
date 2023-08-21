import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

/**
 * 
 * �Ｚ �ٴϷ��� �������� �� �ؾ���..
 * ��~ ����ϱ� �ȴ�
 * 
 * ������ ���� �ֱٿ� �־��� ������� ���� , �� ������ �ٷ� ����, ������ ���� ������ �ٽ� �Ѵ� <- Stack�� ���� ��.
 * ��Ｚ�� ������ ������ ������ �޴´�. ������ �� ���� ����϶�
 * 
 * �Է�
 * N(��ü �ð�) <= 10^6 N-> 1ms
 * 1 A T // ������ ����. T�� �ҿ� �ð�.
 * 0 // ������ ���� ����. �ϴ��� ��� �ض�.
 *
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Deque<Task> taskStack = new ArrayDeque(); // ���� ������ Stack
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		
		
		int time = 0; // ��ü �ҿ� �ð�
		int score = 0; // ��ü ȹ�� ����
		while(time++ < N) { // �ð��� N(������ �ð�)�� �Ǳ� ������ �ݺ�
			getWork(); // ���� ȹ��
			if(taskStack.isEmpty())
				continue;
			Task task = taskStack.pollFirst(); // ���� �ֱٿ� ���� �� ������
			task.work(); // �۾� �ϱ� (���� �ð� -1)
			if(task.isClear()) { // ���� ���� �ߴٸ� (�ð� == 0)
				score += task.getScore(); // ������ ȹ���Ѵ�.
			}else {
				taskStack.addFirst(task); // �� ���ߴٸ� �ٽ� ���ÿ� �ִ´�.
			}
		}
		System.out.println(score); // ������ ����Ѵ�.
	}
	
	static void getWork() throws IOException {
		st = new StringTokenizer(br.readLine());
		if("0".equals(st.nextToken())) // ���� ���ָ� ���ư���.
			return;
		taskStack.addFirst(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); // ���ÿ� ���ο� �� �߰�
		return ;
		
	}
	
	static class Task{ // ���� ������ Ŭ����
		int amount;
		int score;

		public Task(int score, int amount) {
			this.amount = amount;
			this.score = score;
		}

		public void work() { // ���� �ϸ� ���� ���� -1 ���ش�.
			amount--;
		}
		public boolean isClear() { // ���� ������ �� üũ
			return amount == 0;
		}
		public int getScore() {
			return score;
		}
		
	}
}