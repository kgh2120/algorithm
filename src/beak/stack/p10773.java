package beak.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스텍을 활용한 기본적인 계산 문제.
 */
public class p10773 {
    public static void main(String[] args) throws IOException {
        new p10773().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                stack.pop();
            }else
                stack.push(k);
        }

        br.close();
        int total = 0;
        for (Integer integer : stack) {
            total += integer;
        }

        System.out.println(total);
    }


}