import java.util.*;
import java.io.*;
public class Main {
    
    static int[] parents;
    static boolean[] truth;
    static int[][] party;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Node [] p = new Node[n+1];
        int[][] party = new int[m][];
        boolean [] selected = new boolean[n+1];
        boolean[] isClean = new boolean[m];
        
        
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        
        if(count == 0){
            System.out.println(m);
            return;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i<count; i++){
            int number = Integer.parseInt(st.nextToken());
            
            q.add(number);
            selected[number] = true;
        }
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            count = Integer.parseInt(st.nextToken());
            party[i] = new int[count];
            for(int j = 0; j<count; j++){
                 int number = Integer.parseInt(st.nextToken());
                 p[number] = new Node(i, p[number]);
                 party[i][j] = number;
            }
        }
        
        while(!q.isEmpty()){
            int b = q.poll();
            
            for(Node e = p[b];  e != null; e = e.next){
                if(isClean[e.num]) continue;
                isClean[e.num] = true;
                
                for(int friend : party[e.num]){
                    if(selected[friend]) continue;
                    selected[friend] = true;
                    q.add(friend);
                }
            }
        }
        int answer = 0;
        for(boolean v : isClean){
            if(!v) answer++;
        }
        
        System.out.println(answer);
       
        
        
        
    }
    
    static class Node{
        int num;
        Node next;
        
        public Node(int num, Node next){
            this.num = num;
            this.next = next;
        }
    }

}
