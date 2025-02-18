import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Counter> map = new HashMap<>();
        
        for(String p : participant){
            Counter c = map.get(p);
            if(c == null){
                c = new Counter();
               map.put(p,c);
            }
            c.v++;
        }
        
        for(String p : completion){
            Counter c = map.get(p);
            if(--c.v == 0)
                map.remove(p);
        }
        
        for(String key : map.keySet()){
            answer = key;
        }
            
        
        return answer;
    }
    
    static class Counter{
        int v;
       
    }
}