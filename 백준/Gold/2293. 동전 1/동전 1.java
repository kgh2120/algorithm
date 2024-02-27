import java.io.*;
import java.util.*;

public class Main {

	static int k,n;
	static int[]arr;
	static int[][]memo;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// k+1의 memo를 만들고, 각 위치에서 n으로 이동한 경우만큼 +1 하기..? 같은 것을 어떻게 걸러줘야 하지?
		// 그럼 for문에서 i를 넣어주는 식으로 하면..
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		memo = new int[k+1][n];
		for(int i = 0; i<n; i++) {
			int m =Integer.parseInt(br.readLine());
			arr[i] = m;
		}
		Arrays.sort(arr);
		
		for(int i = 0; i<n; i++) {
			int m = arr[i];
			if(m > k)
				break;
			memo[m][i]++;
		}
		comb(1);
			
		int total = 0;
		for(int data : memo[k])
			total += data;
		System.out.println(total);

		
	}
	
	private static void comb(int weight) {
		if(weight >= k)
			return;
		
		for(int i = 0; i<n; i++) {
			for(int j = i; j<n; j++) {
				if(weight + arr[j] > k)
					break;
				memo[weight + arr[j]][j] += memo[weight][i];
			}
		}
		comb(weight+1);
			
	}
}