import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Node> stack = new ArrayDeque<>();
        
        for(int i = 0; i< prices.length; i++){
            int cur = prices[i];
      
            // 비교하기
            while(!stack.isEmpty() && stack.peekLast().cost > cur){
                Node n = stack.pollLast();
                answer[n.index] = i - n.index;
            }
            stack.addLast(new Node(i, cur));
        }
        
          while(!stack.isEmpty()){
                Node n = stack.pollLast();
                answer[n.index] = answer.length-1 - n.index;
            }
        
        
        return answer;
    }
    static class Node{
        int index;
        int cost;
        public Node(int i, int c){
            this.index = i;
            this.cost = c;
        }
    }
}