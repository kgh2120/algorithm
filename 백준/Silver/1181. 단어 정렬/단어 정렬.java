import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		for(int i = 0; i<n; i++)
			arr[i] = br.readLine();
		
		
		Arrays.sort(arr,new Comparator<String>() {
			
			public int compare(String left, String right) {
				if(left.length() == right.length())
					return left.compareTo(right);
				return left.length() - right.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		String prev = "";
		for (String string : arr) {
			if(prev.equals(string))
				continue;
			sb.append(string).append("\n");
			prev = string;
		}
				
		System.out.println(sb);
		
	}
	

}