import java.io.*;
import java.util.*;

/*
    
    선수과목을 이수해야, 다음 과목을 이수할 수 있는 문제.
    한번의 학기에서 모든 과목을 다 들을 수 있음.
    
    위상정렬 기본 문제같은 느낌임.
    
*/
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int [] score = new int[n+1];
        int [] childs = new int[n+1];
        
        Edge[] edges = new Edge[n+1];
        
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            edges[from] = new Edge(to, edges[from]);
            childs[to]++;
        }
        
        Queue<Integer> subjects = new ArrayDeque<>();
        for(int i = 1; i<=n; i++){
            if(childs[i] == 0)
                subjects.add(i);
        }
        
        int level = 0;
        
        while(!subjects.isEmpty()){
            level++;
            int size = subjects.size();
            while(size-->0){
                int subject = subjects.poll();
                score[subject] = level;
                
                for(Edge e = edges[subject]; e != null; e = e.next){
                    if(--childs[e.to] == 0){
                        subjects.add(e.to);
                    }
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i<=n; i++)
            answer.append(score[i]).append(" ");
            
        System.out.println(answer);
        
        
    }
    static class Edge{
        int to;
        Edge next;
        
        public Edge(int to, Edge next){
            this.to = to;
            this.next = next;
        }
    }
}
