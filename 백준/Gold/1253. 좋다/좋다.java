import java.util.*;
import java.io.*;
public class Main {
    
    static int[] arr;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            Queue<Integer>q = map.get(arr[i]);
            if(q == null){
                q = new ArrayDeque<>();
                map.put(arr[i], q);
            }
            q.add(i);
        }
       
        int answer = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                
                int value = arr[i] + arr[j];
                
                Queue<Integer> q = map.get(value);
                if(q == null) continue;
                
                int size = q.size();
                
                while(size-->0){
                    int idx = q.poll();
                    if(idx == i || idx == j){
                        q.add(idx);
                        continue;
                    }
                    
                    answer++;
                }
                
            }
        }
        System.out.println(answer);
            
    }
   
}
