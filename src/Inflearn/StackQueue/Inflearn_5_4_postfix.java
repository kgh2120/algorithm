package Inflearn.StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Inflearn_5_4_postfix {
    public static void answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String con = sc.next();


        Deque<String> postfix = new ArrayDeque<String>();
        Stack<String> temp = new Stack<>();

        for (String c : con.split("")) {
            postfix.add(c);
        }

        while (!postfix.isEmpty()) {
            String s = postfix.pollFirst();
            if (isOperator(s)) {
                int a = Integer.parseInt(temp.pop());
                int b = Integer.parseInt(temp.pop());
                int result = calculator(b,a, s);
                if (postfix.isEmpty()) {
                    System.out.println(result);
                    return;
                }
                postfix.addFirst(Integer.toString(result));
                while(!temp.empty())
                    postfix.addFirst(temp.pop());
            }else
                temp.push(s);
        }




    }

    private static boolean isOperator(String c) {
        if(c.equals("+"))
            return true;
        if (c.equals("-"))
            return true;
        if (c.equals("*"))
            return true;
        return c.equals("/");
    }

    private static int calculator(int a, int b, String c) {
        switch (c) {
            case "+":
                return a+b;
            case "-" :
                return a-b;
            case "*" :
                return a*b;
            case "/" :
                return a/b;
        }
        return -1;
    }

    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        String con = sc.next();

        Stack<Integer> stack = new Stack<>();
        for (String s : con.split("")) {
            if (isOperator(s)) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                int result = calculator(a2, a1, s);
                stack.push(result);
            }else
                stack.push(Integer.parseInt(s));
        }
        System.out.println(stack.pop());
    }
}
