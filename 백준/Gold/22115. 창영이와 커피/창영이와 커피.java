import java.util.*;
import java.io.*;

/**
    
    커피 N개 각각 Ci의 카페인 
    K 카페인을 섭취하려고 할 때 최소 몇개를 먹으면 가능한지
    
    N -> 100
    K -> 10만
    
    
**/

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] coffees;
    static int[] dp;
    
    static int numberOfCoffees;
    static int targetCaffeine;
    
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());
        numberOfCoffees = Integer.parseInt(st.nextToken());
        targetCaffeine = Integer.parseInt(st.nextToken());
        coffees = new int[numberOfCoffees];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<numberOfCoffees; i++)
            coffees[i] = Integer.parseInt(st.nextToken());
            
        dp = new int[targetCaffeine+1];
        Arrays.fill(dp, 101);
        dp[0] = 0;
        
        for(int coffee : coffees){
            for(int i = targetCaffeine; i >= 0; i--){
                if(i >= coffee){
                    dp[i] = Math.min(dp[i], dp[i-coffee] + 1);
                }
            }
        }
        
        int answer = dp[targetCaffeine] != 101 ? dp[targetCaffeine] : -1;
        System.out.println(answer);
        
        
        
    }
}
