import java.io.*;
import java.util.*;

/**

    매개변수 탐색
    
    left -> 길이 1
    right -> 모든 강의의 합
    
    M을 만족하는 것 중에서 가장 짧은 테잎의 길이

**/

public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] arr;
    
    static int n;
    static int k;
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(input.readLine());
        int sum = 0;
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        
        int left = 1;
        int right = sum;
        int ans = Integer.MAX_VALUE;
        
        while(left<=right){
            int mid = (left + right) / 2;
            
            int cnt = 1;
            int size = 0;
            
            for(int movie : arr){
                
                if(size + movie <= mid){
                    size += movie;
                    continue;
                }
                // 이미 초과한 상황
                size = movie;
                cnt++;
                // 불가능한 케이스도 있다.
                if(size > mid)
                    cnt+=100;
            }

            
            // 길이 늘려
            if(cnt> k){
                left = mid+1;
            } else{
                ans = Math.min(ans, mid);
                right = mid-1;
            } 

        }
        
        System.out.println(ans);
        
    }
}
