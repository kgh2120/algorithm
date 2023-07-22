package beak.Sep2023.p1711;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		int i = n;
		while(true) {
			if(!isPrimeNumber(i)) {
				i++;
				continue;
			}
			if(isFel(i)) {
				System.out.println(i);
				return;
			}
			i++;
		}

	}
	
	private static boolean isFel(int k) {
		char[] target = Integer.toString(k).toCharArray();
		boolean isP = true;
		for(int l = 0, r = target.length-1; l<r; l++) {
			if(target[l] != target[r]) {
				isP = false;
				break;
			}
			r--;
		}
		return isP;
	}
	
	private static boolean isPrimeNumber(int target) {
		
		if(target <2)
			return false;
		for(int i = 2; i<= Math.sqrt(target); i++)
			if(target % i == 0)
				return false;
		return true;
	}
	
	
	
	

	
	


}