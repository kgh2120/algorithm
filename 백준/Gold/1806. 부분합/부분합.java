import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
            
        int l = 0;
        int r = 0;
        // r 커서에 닿는 거 먹고 ++ 하는게 맞을듯
        int acc = 0;
    
        while(l<=r && r <= n){
            if(acc < k){ // 먹기
                if(r == n) break;
                acc += arr[r++];
                continue;
            }
            
            // 뱉기
            int length = r-l;
            min = Math.min(min,length);
            acc -= arr[l++];
        }
        if(min == Integer.MAX_VALUE)
            min = 0;
        System.out.println(min);
    }
}
