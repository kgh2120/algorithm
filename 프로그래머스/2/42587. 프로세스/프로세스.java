import java.util.*;
/* 
    큐 + 정렬된 리스트를 갖는 것이 좋을지? 
    
*/
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new ArrayDeque<>();
        List<Integer> pp = new ArrayList<>();
        for(int i = 0; i< priorities.length; i++){
            q.add(new Process(i, priorities[i]));
            pp.add(priorities[i]);
        }
        Collections.sort(pp, Collections.reverseOrder());
        
        int priorityIndex = 0;
        int turn = 0;
        while(!q.isEmpty()){
            
            Process process = q.poll();
            
            if(process.priority == pp.get(priorityIndex)){
                turn++;
                priorityIndex++;
                if(process.index == location){
                    return turn;
                }
            } else {
                q.add(process);
            }
        }
        
        
        
        return -1;
    }
    
    static class Process{
        int index;
        int priority;
        
        public Process(int i, int p){
            this.index = i;
            this.priority = p;
        }
    }
}