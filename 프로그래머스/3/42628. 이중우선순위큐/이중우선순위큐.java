import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        Queue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return Integer.compare(o2.value, o1.value);
            }
        });
        
        Queue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return Integer.compare(o1.value, o2.value);
            }
        });
        
        for(String ops : operations){
            StringTokenizer st = new StringTokenizer(ops);
            String command = st.nextToken();
            Integer value = Integer.parseInt(st.nextToken());
            
            if(command.equals("I")){
                Node node = new Node(value);
                maxHeap.add(node);
                minHeap.add(node);
                
            } else {
                
                Queue<Node> targetHeap = minHeap;
                if(value == 1){
                    targetHeap = maxHeap;
                } 
                
                while(!targetHeap.isEmpty()){
                    Node top = targetHeap.poll();
                    if(top.isDeleted)
                        continue;
                    top.isDeleted = true;
                    break;
                }
                
            }
        }
        
        int max = getValue(maxHeap);
        int min = getValue(minHeap);
        

        return new int[]{max,min};
    }
    
    private int getValue(Queue<Node> heap){
       while(!heap.isEmpty()){
            Node top = heap.poll();
            if(top.isDeleted)
                continue;
         
           return top.value;
        }
        return 0;
    }
    
    static class Node{
        int value;
        boolean isDeleted;
        
        public Node(int v){
            this.value = v;
        }
    }
}