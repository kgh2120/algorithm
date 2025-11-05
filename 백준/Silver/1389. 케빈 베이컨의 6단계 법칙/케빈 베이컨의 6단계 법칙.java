import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Node [] graph = new Node[n+1];
        
        while(m-->0){
            
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a] = new Node(b, graph[a]);
            graph[b] = new Node(a, graph[b]);
            
        }
        
        boolean [] visited = new boolean[n+1];
        
        int min = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i<= n; i++){
            
            Arrays.fill(visited, false);
            
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            visited[i] = true;
            
            int turn = 0;
            int cost = 0;

            while(!q.isEmpty()){
                int size = q.size();
                turn++;
                while(size-->0){
                    int cur = q.poll();
                    
                    for(Node node = graph[cur]; node != null; node = node.next){
                        if(visited[node.value]) continue;
                        q.add(node.value);
                        cost += turn;
                        visited[node.value] = true;
                    }
                }
            }
            
            if(min > cost){
                min = cost;
                answer = i;
            }
        
        }
        
        System.out.println(answer);
        
        
    }
    
    static class Node{
        int value;
        Node next;
        
        public Node(int v, Node n){
            this.value = v;
            this.next = n;
        }
    }
}
