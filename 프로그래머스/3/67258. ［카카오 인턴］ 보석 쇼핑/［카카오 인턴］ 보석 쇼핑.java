import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
      
        Map<String, Counter> counterMap = new HashMap<>();
        Set<String> has = new HashSet<>();
        
        for(String s : gems){
            if(counterMap.containsKey(s)) continue; 
            counterMap.put(s, new Counter());
        }
        int fullSize = counterMap.size();
        
        int left = 0;
        int right = 0;
        
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;
        
        while(left <= right && right < gems.length){
            // 지금 꽉 찼어? 그러면 left 전진. 아니면 right 전진
                    
            // 아니라면 오른쪽 ㄱㄱ
            String rightGem = gems[right++];
            
            Counter counter = counterMap.get(rightGem);
            if(counter.value++ == 0)
                has.add(rightGem);
            
            
            
              while(left <= right && isFull(has, fullSize)){
              int currentLength = right - left;
                if(minLength > currentLength){
                    minLength = currentLength;
                    minLeft = left;
                    minRight = right;
                }
        
                String leftGem = gems[left++];
                Counter leftCounter = counterMap.get(leftGem);
                if(--leftCounter.value == 0){
                    has.remove(leftGem);
                }
            }
        }
        
        return new int []{minLeft+1, minRight};
    }
    
    static boolean isFull(Set<String> has, int fullSize){
        return has.size() == fullSize;
    
    }
    
    static class Counter{
        int value;
        
        @Override
        public String toString(){
            return value + "";
        }
    
    }
}