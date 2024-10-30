import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        Queue<Problem> pq = new PriorityQueue<>();
        Problem[] problems = new Problem[n];
        int max = -1;
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int dead = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            Problem problem = new Problem(dead,value);
            problems[i] = problem;
            max = Math.max(dead, max);
        }
        
        Arrays.sort(problems, new Comparator<Problem>(){
            @Override
            public int compare(Problem p1, Problem p2){
                return Integer.compare(p1.deadLine, p2.deadLine) * -1;
            }
        });
        
        int index = 0;
        int answer = 0;
        while(max != 0){
            while(index < n && problems[index].deadLine == max){
                pq.add(problems[index]);
                index++;
            }
            
            max--;
            if(pq.isEmpty()){
                continue;
            }
            Problem problem = pq.poll();
            answer += problem.value;
        }
        System.out.println(answer);
        
    }
    
    static class Problem implements Comparable<Problem>{
        int deadLine;
        int value;
        
        public Problem(int d, int v){
            this.deadLine = d;
            this.value = v;
        }
        
        @Override
        public int compareTo(Problem o){
            return Integer.compare(value, o.value) * -1;
        }
    }
}
