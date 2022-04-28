package Inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Infleran_5_1_ValidBracket {
    public static void answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String con = sc.next();

        char[] chars = con.toCharArray();
        int nOfOpen = 0;
        int nOfClose = 0;
        for (char aChar : chars) {
            if(aChar == 40)
                nOfOpen++;
            else
                nOfClose++;

            if (nOfOpen < nOfClose) {
                System.out.println("NO");
                return;
            }
        }
        if(nOfOpen!=nOfClose)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        String con = sc.next();

        char[] chars = con.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (Character character : chars) {
            if (character.equals('(')) {
                stack.push(character);
            } else {
                if (stack.empty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        String result = stack.empty() ? "YES" : "NO";
        System.out.println(result);
    }
}
