import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int number : arr){
            if(!q.isEmpty() && q.peekLast().equals(number)) continue;
            q.addLast(number);
        }
        
        answer = new int[q.size()];
        for(int i = 0; i< answer.length; i++)
            answer[i] = q.poll();

        return answer;
    }
}