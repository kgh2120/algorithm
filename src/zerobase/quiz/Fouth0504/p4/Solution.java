package zerobase.quiz.Fouth0504.p4;

import java.util.*;

class Solution {
    public int[] solution(int[] start, int[] time) {
        int[] answer = new int[time.length];

        PriorityQueue<Task> taskList = new PriorityQueue<Task>(new Comparator<Task>(){
            public int compare(Task t1, Task t2){
                return t1.start-t2.start;
            }
        });

        PriorityQueue<Task> taskPq = new PriorityQueue<Task>(new Comparator<Task>(){
            public int compare(Task t1, Task t2){
                if(t1.time == t2.time)
                    return t1.idx-t2.idx;
                return t1.time-t2.time;
            }
        });

        for(int i = 0; i< start.length; i++)
            taskList.add(new Task(start[i],time[i],i));


        int now = 0;
        int k = 0;
        while( !(taskPq.isEmpty() && taskList.isEmpty()) ){
            while(!taskList.isEmpty() && taskList.peek().start <= now){
                taskPq.add(taskList.poll());
            }
            if(!taskPq.isEmpty()){
                Task task = taskPq.poll();
                answer[k++] = task.idx;
                now += task.time;
                continue;
            }
            now++;
        }

        return answer;
    }

    class Task{
        int start;
        int time;
        int idx;
        Task(int start, int time, int idx){
            this.start = start;
            this.time = time;
            this.idx = idx;
        }
        public String toString(){
            return start + " " + time + " " + idx;
        }
    }
}