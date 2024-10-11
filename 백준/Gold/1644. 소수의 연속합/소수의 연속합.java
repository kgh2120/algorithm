import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        boolean [] filter = new boolean[n+1];
        
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i<= n; i++){
            if(filter[i]) continue;
            
            primeNumbers.add(i);
            for(int j = 2; i*j <= n; j++)
                filter[i*j] = true;
        }
        
        int l = 0;
        int r = 0;
        int end = primeNumbers.size();
        int acc = 0;
        int answer = 0;
        while(l<=r){
            if(acc < n){
                if(r >= end)
                    break;
                acc += primeNumbers.get(r++);
                continue;
            }
            
            if(acc == n){
                answer++;
            }
            
            acc -= primeNumbers.get(l++);
        }
        System.out.println(answer);
        
    }
}
