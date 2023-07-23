package beak.Jul2023.p5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_CustomStack {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static final int MAX = 1_000_000;

    static CustomStack left, right;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());


        for(int i = 0; i<n; i++){
            left = new CustomStack(MAX);
            right = new CustomStack(MAX);
            String text = br.readLine();
            for(int j = 0; j<text.length(); j++){
                char c = text.charAt(j);
                switch (c){
                    case '<':
                        char leftPop = left.pop();
                        if(leftPop != ' ')
                            right.push(leftPop);
                        break;
                    case '>':
                        char rightPop = right.pop();
                        if(rightPop != ' ')
                            left.push(rightPop);
                        break;
                    case '-':
                        left.pop();
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }
            left.append(sb);
            right.appendRight(sb);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static class CustomStack{
        char [] stack;
        int top;

        public CustomStack(int size) {
            this.stack = new char[size];
        }

        public void push(char c){
            stack[top++] = c;
        }
        public char pop(){
            if(top == 0)
                return ' ';
            char pop = stack[--top];
            stack[top] = ' ';
            return pop;
        }

        public void append(StringBuilder sb) {
            for (char c : stack) {
                if(!Character.isLetterOrDigit(c))
                    break;
                sb.append(c);
            }
        }
        public void appendRight(StringBuilder sb){
            StringBuilder sbb = new StringBuilder();
            for (char c : stack) {
                if(!Character.isLetterOrDigit(c))
                    break;
                sbb.append(c);
            }
            sb.append(sbb.reverse());
        }
    }
}