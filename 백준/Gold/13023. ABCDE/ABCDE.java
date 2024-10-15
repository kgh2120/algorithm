import java.util.*;
import java.io.*;

public class Main {
    
    static Node[] graph;
    static boolean [] visited;
    
    static boolean find = false;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new Node[n];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a] = new Node(b, graph[a]);
            graph[b] = new Node(a, graph[b]);
            
            
        }
        
        int ans = 0;
        for(int i = 0; i<n; i++){
            visited = new boolean[n];
            findFriend(i, 0);
            
            if(find){
                ans = 1;
                break;
            }
        }
        System.out.println(ans);
    }
    
    static void findFriend(int index, int depth){
        if(depth == 4){
            find = true;
            return;
        }
        
        visited[index] = true;
        
        for(Node n  = graph[index]; n != null; n = n.next){
            if(find) return;
            if(visited[n.to]) continue;
            
            visited[n.to] = true;
            findFriend(n.to, depth+1);
            visited[n.to] = false;
        }
    }
    
    static class Node    {
        int to;
        Node next;
        public Node(int to, Node next){
            this.to = to;
            this.next = next;
        }
    }
}
