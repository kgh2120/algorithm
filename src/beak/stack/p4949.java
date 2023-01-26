package beak.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class p4949 {

    StringBuilder sb = new StringBuilder();
    int s = 0;
    int b = 0;
    boolean flag = true;
    Stack<String> stack = new Stack<>();


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        String cons="";
        while (true) {
            flag = true;
            stack.clear();
            cons = br.readLine();
            if(cons.equals("."))
                break;


            for (int i = 0; i < cons.length(); i++) {
                if(!flag) break;
                try {
                    command(cons.charAt(i));
                } catch (EmptyStackException e) {
                    flag = false;
                    break;
                }
            }
            if(stack.size() == 0 && flag)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        br.close();
        System.out.println(sb.toString());
    }

    public boolean end() {
        if(s < 0) return false;
        if(b<0) return false;
        return true;
    }

    public void command(Character c) {
        switch (c) {
            case '(': stack.push("(");
                break;
            case ')':
                String pop = stack.pop();
                if(!pop.equals("("))
                    flag = false;
                break;
            case '[': stack.push("[");
                break;
            case ']':
                String pop2 = stack.pop();
                if(!pop2.equals("["))
                    flag = false;
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        new p4949().solution();
    }
}