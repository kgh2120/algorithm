import java.util.*;
import java.io.*;

/*

    합집합 -> 0 a b // union
    포함 -> 1 a b // find가 동일한 경우

*/

public class Main {
    
    static int[] parents;
    
    
    public static void main(String[] args)  throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parents = new int[n+1];
        for(int i = 0; i< n+1; i++)
            parents[i] = i;
            
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(action == 0)
                union(a,b);
            else {
                boolean same = find(a) == find(b);
                String ans = same? "YES" :"NO";
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
    
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        parents[pb] = pa;
        
    }
    
    static int find(int a){
        if(a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }
}
