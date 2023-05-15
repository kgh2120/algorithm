package programmers.May23.w2.p133502;

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 새로운 게 추가되었을 때
        // 자기로부터 -4 부터 자기까지가
        // 1이 들어왔을 때
        // 자기 전에가 3, 2, 1 이 되면
        // 지운다.
        int[]reverseOrder = {1,3,2,1};
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<ingredient.length ;i++){
            int k = ingredient[i];
            stack.push(k);
            if(k == 1 && stack.size() >= 4){
                Stack<Integer>reverseStack = new Stack<>();
                boolean p = true;
                for(int j = 0; j<4; j++){
                    int pop = stack.pop();
                    reverseStack.push(pop);
                    if(reverseOrder[j] != pop){
                        p = false;
                        break;
                    }
                }
                if(!p){
                    while(!reverseStack.isEmpty())
                        stack.push(reverseStack.pop());
                }else
                    answer++;

            }

        }

        return answer;
    }
}