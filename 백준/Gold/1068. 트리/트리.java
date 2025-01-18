import java.util.*;
import java.io.*;

/*

    2번째 줄에서 주어진 parent에 대한 정보를 토대로
    Tree를 구성할 수 있을 것임. 
    그러면 루트부터 타고 내려가면서 체크가 가능함.
    
    트리를 만들고, 제거하기로 선택한 애한테 접근을 못하게 하면 크게 어렵지 않게 풀 수 있을듯?

*/

public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        int n = Integer.parseInt(input.readLine());
        
        st = new StringTokenizer(input.readLine());
        
        
        Node[] tree = new Node[n];
        int rootIndex = 0;
        for(int i = 0; i<n; i++){
            int v = Integer.parseInt(st.nextToken());
            
            if(v == -1){
                rootIndex = i;
            } else {
                tree[v] = new Node(i, tree[v]);
            }
        }
        
        
        int deletedTree = Integer.parseInt(input.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(rootIndex);
        
        int leafNodeCount = 0;
        
        while(!q.isEmpty() && rootIndex != deletedTree ){
            int treeIndex = q.poll();
            
            int count = 0;
            
            for(Node node = tree[treeIndex]; node  != null; node  = node .next){
                if(node.v == deletedTree) continue;
                q.add(node.v);
                count++;
            }
            
            if(count == 0)
                leafNodeCount++;
        }
        
        System.out.println(leafNodeCount);
        
    }
    
    static class Node{
        int v;
        Node next;
        
        public Node(int v, Node n){
            this.v = v;
            this.next = n;
        }
    }
}
