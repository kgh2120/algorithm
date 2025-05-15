import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            answer++;
            
            int size = q.size();
            while(size-->0){
                String cur = q.poll();
                
                for(int i =0;i < words.length; i++){
                    if(visited[i]) continue;
                    String trans = words[i];
                    if(canConvert(cur, trans)){
                        visited[i] = true;
                        q.add(trans);
                        if(trans.equals(target)){
                            return answer;
                        }
                    }
                }
                
            }
            
        }
        
        return 0;
    }
    
    private boolean canConvert(String from, String to){
        
        int count = 0;
        for(int i = 0; i< from.length(); i++){
            
            if(from.charAt(i) != to.charAt(i))
                count++;
        }
        
        return count == 1;
    }
}