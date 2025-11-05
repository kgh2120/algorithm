import java.util.*;
import java.io.*;

/**
    어떻게 보면 최단 경로와 비슷한 케이스이다.
    무조건 감소하는 경우지만, 특정 케이스에서는 /2보다 -1 /3이 더 멀리 갈 수 있음.
    BFS형태로 동작하면서 turn내에 1에 도달하는 것이 가장 짧을 것.
    다만 visited체크를 해주면서, 이미 true에 다시 도달하면 그건 큐에 안넣도록 써보자.
**/

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean [] visited = new boolean[n+1];
        q.add(n);
        visited[n] = true;
        
        int turn = 0;
        while(!q.isEmpty()){
            int size = q.size();        
            while(size-->0){
                Integer location = q.poll();                
                
                if(location == 1){
                    System.out.println(turn);
                    return;
                }
                
                action(location, 3, visited, q);
                action(location,2, visited, q);
                q.add(location-1);
                
            }
            turn++;
        }
        
    }
    
    private static void action(int cur, int number, boolean [] visited, Queue<Integer> q){
        
        if(cur % number == 0 && !visited[cur/number] ){
            visited[cur/number] = true;
            q.add(cur/number);
        }        
    }
}
