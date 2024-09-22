import java.util.*;
import java.io.*;



public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
            
        Arrays.sort(arr);
        
        int cnt = 0;
        int left = 0;        
        for(int i = n-1; i>0; i--){
            if(arr[i-1] == 0) break;            
            if(--arr[left] == 0){
                left++;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
