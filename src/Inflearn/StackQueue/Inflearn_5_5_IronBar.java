package Inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 정답률이 굉장히 높았는데, 푸는데 너무 오래 걸렸던 문제.
 * 규칙을 찾아내는데 처음에 잘못 생각해서 너무 헤메었다.
 */
public class Inflearn_5_5_IronBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String con = sc.next();
        Stack<Character> stack = new Stack<>();
        boolean prev = false;
        int result = 0;
        for (char c : con.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                prev = false;
            }else{
                stack.pop();
                if (prev) {
                    result++;
                }else{
                    result += stack.size();
                }
                prev = true;
            }
        }
        System.out.println(result);

    }
}
