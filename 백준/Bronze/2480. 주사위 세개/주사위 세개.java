import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int result = 0;
		if(a==b && b == c)
			result = 10000 + a * 1000;
		else if(a != b && b != c && a != c)
			result = Math.max(a, Math.max(b, c)) * 100;
		else {
			int same = 0;
			if(a==b)
				same = a;
			else if(b == c)
				same = b;
			else
				same = c;
			result = 1000 + same * 100;
		}
		System.out.println(result);
	}
}