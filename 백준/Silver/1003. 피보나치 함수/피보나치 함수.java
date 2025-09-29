import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int[][] fibo = new int[41][2];
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int n = Integer.parseInt(br.readLine());
        
        
        fibo[0][0] = 1;
        fibo[1][1] = 1;
        fibo[2][0] = 1;
        fibo[2][1] = 1;
        
        for(int i = 3; i<= 40; i++){
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-1][0];
        }
        
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            
            
            int k = Integer.parseInt(br.readLine());
            
            sb.append(fibo[k][0]).append(" ").append(fibo[k][1]).append("\n");
            
        }
        
        System.out.print(sb);
        
        
    }
}
