import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        TreeSet<Integer> doublePq = new TreeSet<>();
        
        StringTokenizer st;
        for(String ops : operations){
            st = new StringTokenizer(ops);
            
            if("I".equals(st.nextToken())){
                doublePq.add(Integer.parseInt(st.nextToken()));
            } else {
                if("1".equals(st.nextToken())){
                    if(!doublePq.isEmpty())
                     doublePq.pollLast();
                } else {
                     if(!doublePq.isEmpty())
                     doublePq.pollFirst();
                }
            }
        }
               
        if(doublePq.isEmpty()){
            answer = new int[]{0,0};
        } else {
            answer = new int[]{doublePq.last(), doublePq.first()};
        }
               
        
        return answer;
    }
}