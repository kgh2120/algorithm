import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> bridge = new ArrayDeque<>();
        int curWeight = 0 ;
        
        int time = 0;
        for(int truckWeight : truck_weights){
            time++;
            if(!bridge.isEmpty() && bridge.peek().endTime == time){
                curWeight -= bridge.poll().weight;
            }
                
            
            // 못 넣을 때 대기
            while(weight - curWeight < truckWeight){
                Truck head = bridge.poll();
                time = head.endTime;
                curWeight -= head.weight;
            } 
            curWeight += truckWeight;
            bridge.add(new Truck(time + bridge_length, truckWeight));
        }
        
        while(!bridge.isEmpty())
            answer = bridge.poll().endTime;
        
        return answer;
    }
    
    static class Truck{
        int endTime;
        int weight;
        
        public Truck(int e, int w){
            endTime = e;
            weight = w;
        }
    }
    
    
}