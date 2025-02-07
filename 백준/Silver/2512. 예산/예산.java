import java.util.*;
import java.io.*;

/**
    주어진 예산이 요청액보다 많다면 요청액 중에 max값 리턴.
    그렇지 않다면 상한액을 설정해야 함.
    
    각 요청액의 범위 1 <= <= 100,000
    총 에산액의 범위 -> 1 <= a <= 10억
    
    상한액의 범위는 ... max값 or 총 예산값
**/

public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int totalBudget;
    
    public static void main(String[] args) throws Exception{
        
        int n = Integer.parseInt(input.readLine());
        arr = new int[n];
        st = new StringTokenizer(input.readLine());
        
        int total = 0;
        int max = -1;
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            max = Math.max(max, arr[i]);
        }
        totalBudget = Integer.parseInt(input.readLine());
        
        int ans = 0;
        if(total <= totalBudget)
            ans = max;
        else {
            
            int left = 0;
            int right = max;
            
            while(left <= right){
                int mid = (left + right) / 2;
                
                // 모든 구간이 mid보다 작은지 체크
                int sum = 0;
                for(int budget : arr){
                    sum += Math.min(budget, mid);
                }
                
                
                // 새로 짜인 값이 가능한가?
                if(sum > totalBudget){
                    // 돈 덜줘야해
                    right = mid - 1;
                } else {
                    // 돈 더 쓰자
                    ans = Math.max(ans, mid);
                    left = mid + 1;
                }
            
                
            }
        }
        System.out.println(ans);
    }
}
