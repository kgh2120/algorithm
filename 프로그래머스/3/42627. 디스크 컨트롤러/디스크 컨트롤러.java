import java.util.*;

class Solution {
    
    /*
        우선순위 -> 소요시간, 요청시간, 번호
        answer -> 모든 job에 대해서 종료 시간 - 요청 시간의 평균
        그럼 내가 구성해야 하는 정보
        번호, 요청 시간, 소요시간을 클래스로 만든다.
        Comparable을 구현해 우선순위 큐에서 사용 가능하도록 설정.
        
        그렇다면 어떻게 넣어줄 생각인지? 
        
        대기큐에 그냥 다 넣고 꺼내서 작업하면 되는건가?
        그건 아님. 다 넣어두게 된다면 우선순위가 깨질 수 있음.
        요청 시간이 결국은 1000이라서 그냥 루프 돌아도 깰 수 있을듯.
        
        그런데 jobs에서 s를 기준으로 정렬되어서 준다는 말이 있는가? 따로 없긴한데, 그냥 해도 이상은 없을지도?
    */
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int totalCostTime = 0;
        
        
        Queue<Job> pq2 = new PriorityQueue<>(new Comparator<Job>(){
            
            @Override
            public int compare(Job o1, Job o2){
                return Integer.compare(o1.startTime, o2.startTime);

            }
            
        });
        int idx = 0;
        for(int[] job : jobs){
            pq2.add(new Job(idx++, job[0], job[1]));
        }
        
        
        
        
        int time = 0;
        int index = 0;
        Queue<Job> pq = new PriorityQueue<>();
        Job currentJob = null;
        while(true){
            
            while(!pq2.isEmpty()){
                Job j = pq2.peek();
                if(j.startTime <= time){
                    pq2.poll();
                    pq.add(new Job(j.index, j.startTime, j.cost));
                    continue;
                }
                break;
            }

            
            if(currentJob == null){
                if(pq.isEmpty()){
                    if(pq2.isEmpty())
                        break;
                    time++;
                    continue;
                }
                currentJob = pq.poll();
                currentJob.pollTime = time;
            }
            
            if(currentJob.pollTime + currentJob.cost == time){
                totalCostTime += time - currentJob.startTime;
                System.out.println(currentJob.index + " " + time + " " + currentJob.startTime + " " + currentJob.pollTime);
                currentJob = null;
                continue;
            }
            
            
            time++;
        }
        
        answer = totalCostTime / jobs.length;
        
        return answer;
    }
    
    static class Job implements Comparable<Job>{
        int index;
        int startTime;
        int cost;
        int pollTime;
        
        public Job(int index, int startTime, int cost){
            this.index = index;
            this.startTime = startTime;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Job o){
            
            if(cost == o.cost){
                if(startTime == o.startTime){
                    return Integer.compare(index, o.index);
                }
                return Integer.compare(startTime, o.startTime);
            }
            return Integer.compare(cost, o.cost);
        }
        
    }
}