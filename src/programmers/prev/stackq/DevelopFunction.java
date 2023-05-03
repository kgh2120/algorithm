package programmers.prev.stackq;

import java.util.Arrays;
import java.util.Stack;

public class DevelopFunction {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int [] duedate = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int p = 100 - progresses[i];
            int s = speeds[i];
            duedate[i] = p / s;
            if(p % s != 0)
                duedate[i]++;

        }
        String s = "herll";
        



        Stack<Integer> q = new Stack<>();

        int big = duedate[0];
        q.add(0);
        for(int due : duedate){
            Integer poll = q.pop();
            if(due > big){
                big = due;
                q.add(poll);
                q.add(1);
                continue;
            }
            q.add(poll+1);
        }

        answer = new int[q.size()];
        int index = 0;
        for(int c : q){
            answer[index++] = c;
        }
        return answer;
    }




    public static void main(String[] args) {

        int [] a = {95, 90, 99, 99, 80, 99};
        int [] b = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(new DevelopFunction().solution(a,b)));
    }
}