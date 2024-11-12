import java.io.*;
import java.util.*;
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        visited = new boolean[10_0001];
        
        if(n >= k){
            System.out.println(n-k);
            return;
        }
        
        visited[n] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        int turn = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                
                
                int current = q.poll();
           
               
              
                if(current >= k){
                  
                    min = Math.min(min, turn + current-k);
                    continue;
                }
                
                // -1
                action(current-1, q);
                // +1
                action(current+1, q);
                // *2
                action(current*2, q);
        
            }
            turn++;
        }
        
        System.out.println(min);
    }
    static void action(int next, Queue<Integer>q){
        if(next < 0 || next > 100000) return;
        if(visited[next]) return;
        visited[next] = true;
        q.add(next);
    }
}
