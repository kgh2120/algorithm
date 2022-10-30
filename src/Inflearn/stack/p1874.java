package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *  스택의 개념을 활용해서 푸는 문제였음.
 *  근데 문제 방향을 잘못 생각해서 레퍼런스를 본 후에야 풀었다.
 *  알고리즘은 역시 방법을 빨리 생각해 내는 것이 중요한 것 같다.
 */
public class p1874 {

    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        boolean flag = true;
        while (n-- > 0) {
            int v = Integer.parseInt(br.readLine());

            for (int i = start+1; i <=v ; i++) {
                s.push(i);
                sb.append("+").append("\n");
                start = i;
            }

            Integer pop = s.pop();
            sb.append("-").append("\n");
            if (!pop.equals(v)) {
                flag = false;
                break;
            }

        }

        System.out.println(flag ? sb.toString() : "NO");
    }






    public static void main(String[] args) throws IOException {
        new p1874().solution();
    }
}