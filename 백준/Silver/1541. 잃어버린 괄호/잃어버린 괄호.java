import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        StringTokenizer minusTokenizer = new StringTokenizer(br.readLine(), "-");
        int total = 0;
        
        StringTokenizer plusTokenizer = new StringTokenizer(minusTokenizer.nextToken(), "+");
        while(plusTokenizer.hasMoreElements()){
            total += Integer.parseInt(plusTokenizer.nextToken());
        }
        
        while(minusTokenizer.hasMoreElements()){
            plusTokenizer= new StringTokenizer(minusTokenizer.nextToken(), "+");
            int sum = 0;
            while(plusTokenizer.hasMoreElements()){
                sum += Integer.parseInt(plusTokenizer.nextToken());
            }
            total  -= sum;
            
        }
        
        System.out.println(total);
        
        
    }
}
