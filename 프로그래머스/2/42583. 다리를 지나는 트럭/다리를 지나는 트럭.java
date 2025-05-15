import java.util.*;

// 넣을 때 트럭 무게랑 내리는 시간? 계산해서 넣어주면 될듯한데 
// 내리는 시간이 들어가고 + bridge_length 잖아. 예시에서 1초에 7번이 올라가서 3초에 내리니까 
// 그러면 내리는 시간, weight 넣고 하면 되는거지 뭐
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int current = 0;
        Queue<Node> b = new ArrayDeque<>();
        int truckIndex = 0;
        int answer = 1;
        while(true){
            
            // 트럭을 넣을 수 있다면 넣고 1초 증가해
            // 못넣으면 트럭 빼고 그 시간으로 이동해
          
            if(truckIndex < truck_weights.length && current + truck_weights[truckIndex] <= weight && b.size() < bridge_length){
              int tw = truck_weights[truckIndex];
                b.add(new Node(answer + bridge_length, tw));
                current += tw;
                answer++;
                truckIndex++;
            } else {
                Node n = b.poll();
                answer = Math.max(answer, n.out);
                current -= n.weight;
            }
            
            if(truckIndex == truck_weights.length && b.isEmpty())
                break;
        }
        
        
        return answer;
    }
    static class Node{
        int out;
        int weight;
        public Node(int o, int w){
            this.out = o;
            this.weight = w;
        }
    }
}