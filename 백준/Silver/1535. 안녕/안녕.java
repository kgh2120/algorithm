import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        Hello [] hells = new Hello[n];
        for(int i = 0; i<n; i++){
            hells[i] = new Hello(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
        }
        
     
        int [][] dp = new int[n][101];
        
        for(int [] d : dp)
            Arrays.fill(d, -1);
        
        int result = happy(dp, n-1, 100, hells);
        
        System.out.println(result);
        
    }
    
    static int happy(int [][] dp, int index, int health, Hello[] hells){
        if(index < 0 || health < 0) return 0;
        if(dp[index][health] != -1)
            return dp[index][health];
        // 먹냐 마냐
        
        Hello cur = hells[index];
        if(health > cur.minus){
            dp[index][health] = Math.max(happy(dp, index-1, health - cur.minus, hells) + cur.plus, happy(dp, index-1, health, hells));
        } else {
            dp[index][health] = happy(dp, index-1, health, hells);
        }
        
        return dp[index][health];
        
    }
    
    static class Hello{
        int minus;
        int plus;
        
        public Hello(int m, int p){
            this.minus = m;
            this.plus = p;
        }
        
    }
}
