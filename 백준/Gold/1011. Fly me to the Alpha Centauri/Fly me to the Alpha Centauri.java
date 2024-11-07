import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int t = 0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            int diff = to - from;
            
            int root = (int)Math.sqrt(diff);
            
            int turn = root*2 -1;
            diff -= root * root;
            
                
            int d = diff / root;
            int mod = diff % root;
                
            if(mod > 0)
                turn++;
            turn += d;
            answer.append(turn).append("\n");
        }
        System.out.println(answer);
        
        
    }
}
