import java.util.*;

class Solution {
    public long solution(int[][] tasks) {

        long totalAmount = 0;
        long lastDate = 0;
        for(int i = 0; i< tasks.length; i++){
            lastDate = Math.max(lastDate, tasks[i][1]);
            totalAmount += tasks[i][2];
        }
        long power = totalAmount/ (lastDate - tasks[0][0] + 1);

        loop : while(true){
            int idx = 0;
            int day = 0;
            PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
                public int compare(Task t1, Task t2){
                    return t1.duedate - t2.duedate;
                }
            });

            while(idx < tasks.length || pq.isEmpty() ){

                long todayPower = power;
                while(idx < tasks.length && tasks[idx][0] == day){
                    pq.add(new Task(tasks[idx][1], tasks[idx][2]));
                    idx++;
                }

                while(todayPower > 0 && !pq.isEmpty()){
                    Task t = pq.poll();
                    if(t.amount > todayPower){
                        if(t.duedate <= day){
                            power++;
                            continue loop;
                        }
                        t.amount -= todayPower;
                        pq.add(t);
                    }
                    todayPower -= t.amount;
                }
                day++;
            }
            break;

        }
        return power;


    }
    class Task{
        int duedate;
        int amount;

        Task(int duedate, int amount){
            this.duedate = duedate;
            this.amount = amount;
        }

        public String toString(){
            return "{ "+duedate+" , "+ amount +"  }";
        }
    }
}