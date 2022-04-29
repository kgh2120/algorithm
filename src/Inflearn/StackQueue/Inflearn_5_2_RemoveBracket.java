package Inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Inflearn_5_2_RemoveBracket {
    public static void answer(String[] args) {
        Scanner sc = new Scanner(System.in);

        String con = sc.next();
        Stack<Character> stack = new Stack<>();
        for (Character c : con.toCharArray()) {
            if (c.equals(')')) {
                while (!stack.peek().equals('(')) {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        System.out.println(sb.toString());

    }

    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);

        String con = sc.next();
        Stack<Character> stack = new Stack<>();
        for (Character c : con.toCharArray()) {
            if (c.equals(')')) {
                while (!stack.pop().equals('('));
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        System.out.println(sb.toString());

    }
}
