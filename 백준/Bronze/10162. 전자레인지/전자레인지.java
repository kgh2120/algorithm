import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * ����ŷ�� �ϴ� ������ 1�� �ְ�, �ð� ���̾� ��ư A(5�� - 300��) B(1�� - 60��) C(10��)�� �ִ�.
 * ��ư�� ������ ������ T �ʸ� ������ �Ѵ�. �ٵ� �ּҷ� ������ �;�.
 * ��Ȯ�� �� ���ߴ� ��쵵 �ִ�.
 * 
 * �ּҷ� ��ư�� Ŭ������ ��, �� ��ư�� ��� ������ ���� ǥ���϶� (������ �ʾҵ��� 0���� ǥ���ϰ� ���� �� ���ٸ� -1)
 *
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int FAIL = -1;
	static int[] clicked;
	static int[] buttons; // �� ��ư���� �ð� �� ��
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine()); // �ð� T(��)
		buttons = new int[] {300,60,10}; // A, B, C ��ư�� �� �Է�
		clicked = new int[3]; // A,B,C ��ư�� ��� ���ȴ� �� ����
		if(isFailed(T)) { // �����ϴ� ���. �ּ� �ð��� 10���̱� ������, 1�� ���� �ʰ� ���´ٸ� �ð��� ���� �� ����.
			System.out.println(FAIL);
			return;
		}
		bake(T); // �� ��ư�� Ȱ���ؼ� ������ ã�´�.
		printResult(); // ��� ���
		
	}
	private static boolean isFailed(int T) {
		return T % 10 != 0;  // �����ϴ� ���. �ּ� �ð��� 10���̱� ������, 1�� ���� �ʰ� ���´ٸ� �ð��� ���� �� ����.
	}
	private static void printResult() {
		for(int count : clicked) // �� ��ư�� Ŭ���� ī��Ʈ�� ��¹��� �����Ѵ�.
			sb.append(count).append(" ");
		System.out.println(sb);
	}
	// �� ��ư�� Ȱ���ؼ� ������ ã�´�.
	private static void bake(int T) {
		int idx = 0;
		while(T > 0) { // ���� �ð��� 0���� Ŭ ���� �ش� �ݺ����� �����Ѵ�.
			clicked[idx] = T / buttons[idx];// ���� �ð� ���� �ش� ��ư�� ��� Ŭ���� �� �ִ��� üũ
			T %= buttons[idx++]; // ���� ��ư�� Ŭ���ؼ� ���ʰ� ���Ҵ��� üũ 
		}
	}
}