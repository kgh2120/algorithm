import java.io.*;
import java.util.*;

public class Main {
    
    static int [] arr;
    static int [] dp;
    static int n;
    static int k;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
            
        dp = new int[n];
        Arrays.fill(dp, -1);
        
        int answer = dp(0);
        System.out.println(answer);
        
    }
    
    static int dp(int index){
        if(index >= n) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        // index를 먹기 vs 안먹기
        
        // 먹기
        int v = arr[index];
        int i = index;
        while(v < k && i < n-1){
            v += arr[++i];
        }
        
        dp[index] = Math.max(v- k + dp(i+1), dp(index+1));
        
        return dp[index];
    }
}
