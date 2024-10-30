import java.util.*;
import java.io.*;
public class Main {
    
    static int[] arr;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i = n-1; i>=0; i--){
            int origin = arr[i];
            for(int j = n-1; j>=0; j--){
                if(i == j) continue;
                int num = arr[j];
                int target = origin - num;
                
                int index = binarySearch(target, i, j);
                if(index == -1) continue;
                answer++;
                break;
            }
        }
        System.out.println(answer);
            
    }
    
    static int binarySearch(int target, int i, int j){
        
        int l = 0;
        int r = arr.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            int find = arr[mid];
            
            if(target > find){
                l = mid+1;
            }else if(target == find){
                if(mid == i || mid == j)
                    l = mid+1;
                else
                    return mid;
            }else 
                r = mid-1;
        }
        return -1;
    }
   
}
