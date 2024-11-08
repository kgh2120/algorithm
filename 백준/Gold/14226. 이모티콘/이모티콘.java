import java.util.*;
import java.io.*;

/*

연산은 총 3가지. 이 3가지를 최소한으로만 사용해서 S개를 만들려고 함.
1. 이모티콘을 모두 복사해 클립보드에 저장. 이때 클립보드의 내용은 덮어쓰기 된다.
2. 클립보드에 있는 이모티콘을 붙혀넣기함.
3. 이모티콘 1개를 삭제함. 수를 줄이낟.

각각의 연산은 1초가 든다. 클립보드가 비어있는 상태면 붙여넣기를 할 수 없음.
즉 1을 안했을 때, 2를 할 수는 없음.
그리고 클립보드에 있는 걸 임의로 수정할 수 없음.

*/
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Set<Integer>> visited = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        int s = Integer.parseInt(br.readLine());
        
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 1));
       
        
        


        
        int turn = 0;
        while(!q.isEmpty()){
            turn++;
            int size = q.size();
            
            while(size-->0){
                Node cur = q.poll();
                
                // 복
                if(!isVisited(cur.value, cur.value)){
                    visit(cur.value, cur.value);
                    q.add(new Node(cur.value, cur.value));
                }
                
                // 붙
                if(cur.clipboard != 0 && !isVisited(cur.clipboard, cur.value + cur.clipboard)){
                    
                    if(cur.value + cur.clipboard == s){
                        System.out.println(turn);
                        return;
                    }
                    
                    visit(cur.clipboard, cur.value + cur.clipboard);
                    q.add(new Node(cur.clipboard, cur.value + cur.clipboard));
                }
                
                // 빼기
                if(cur.value > 1 && !isVisited(cur.clipboard, cur.value -1)){
                    
                    if(cur.value-1 == s){
                        System.out.println(turn);
                        return;
                    }
                    
                    visit(cur.clipboard, cur.value -1);
                    q.add(new Node(cur.clipboard, cur.value -1));
                }
                
                
            }
            

                
                

            
        }
        
    }
    
    static boolean isVisited(int value, int clipboard){
        
        
        Set<Integer> v = visited.get(value);
        
        if(v == null){
            visited.put(value, new HashSet<>());
            return false;
        }
        
        return v.contains(clipboard);
    }
    
    static void visit(int value, int clipboard){
        visited.get(value).add(clipboard);
    }
    
    static class Node {
        int clipboard;
        int value;    
        public Node(int n, int v){
            clipboard= n;
            value = v;
        }
        
    }
}
