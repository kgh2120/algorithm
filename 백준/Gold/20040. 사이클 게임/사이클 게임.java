import java.io.*;
import java.util.*;

/**
    사이클이 형성이 되는 턴을 리턴한다.
    사이클이 생성되지 않는다면 0을 리턴한다.
    
    사이클의 유무는 유니온 파인드로 체크해볼까 한다.
    더 낮은 애를 기준으로 유니온을 묶는데,
    이미 둘의 부모가 같다면 사이클이라고 생각해도 좋아보인다.
**/
public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] parents;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxTurn = Integer.parseInt(st.nextToken());
        
        parents = new int[n];
        for(int i =0; i<n; i++)
            parents[i] = i;
        
        for(int i = 1; i<=maxTurn; i++){
            st = new StringTokenizer(input.readLine());
            int l =Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            if(union(l,r)){
                System.out.println(i);
                return;
            }
                
        }
        System.out.println(0);
        
    }
    
    static boolean union(int l, int r){
        int lp = find(l);
        int rp = find(r);
        
        if(lp == rp)
            return true;
        
        if(lp <= rp)
            parents[rp] = lp;
        else
            parents[lp] = rp;
        return false;    
        
    }
    
    static int find(int n){
        if(parents[n] == n)
            return n;
        return parents[n] = find(parents[n]);
    }
}
