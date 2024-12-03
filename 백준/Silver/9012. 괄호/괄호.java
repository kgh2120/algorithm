import java.io.*;
import java.util.*;

public class Main {
    
    static final char OPEN = '(';
    static final String SUCCESS = "YES";
    static final String FAIL = "NO";
    
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        int tc = Integer.parseInt(input.readLine());
        
        while(tc-->0){
            int numberOfOpen = 0;
            boolean result = true;
            for(char word : input.readLine().toCharArray()){
                if(word == OPEN)
                    numberOfOpen++;
                else {
                    if(--numberOfOpen < 0){
                        result = false;
                        break;
                    } 
                }
            }
            
            if(numberOfOpen != 0)
                result = false;
            String ans = result ? SUCCESS : FAIL;
            answer.append(ans).append("\n");    
        }
        System.out.println(answer);
    }
}
