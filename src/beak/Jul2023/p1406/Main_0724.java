package beak.Jul2023.p1406;

import java.io.*;
import java.util.*;

public class Main_0724 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static MyStack left, right;
	public static void main(String[] args) throws Exception {
		String init = br.readLine();
		left= new MyStack(init);
		right = new MyStack();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			operation(st);
		}
		
		left.toStringLeft(sb);
		right.toStringRight(sb);
		System.out.println(sb);
	
	
	}
	
	private static void operation(StringTokenizer st) {
		switch (st.nextToken()) {
		case "L":
			char leftPop = left.pop();
			if(Character.isAlphabetic(leftPop))
				right.push(leftPop);
			break;
		case "D":
			char rightPop = right.pop();
			if(Character.isAlphabetic(rightPop))
				left.push(rightPop);
			break;
		case "B" :
			left.pop();
			break;
		case "P":
			left.push(st.nextToken().charAt(0));
			break;
		default:
			break;
		}
	}


	static class MyStack{
		char [] stack;
		int size;
		
		public MyStack() {
			stack = new char[600_000];
		}
		public MyStack(String prev) {
			stack = new char[600_000];
			
			for(int i = 0; i<prev.length(); i++) {
				stack[i] = prev.charAt(i);
				size++;
			}
		}
		
		public char pop() {
			if(size == 0)
				return ' ';
			char pop = stack[--size];
			stack[size] = ' ';
			return pop;
		}
		public void push(char c) {
			stack[size++] = c;
		}
		
		public void toStringLeft(StringBuilder sb) {
			for(int i = 0; i<size; i++) 
				sb.append(stack[i]);
		}
		public void toStringRight(StringBuilder sb) {
			for(int i = size-1; i>=0; i--)
				sb.append(stack[i]);
		}
	}

}