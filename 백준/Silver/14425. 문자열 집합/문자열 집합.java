import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<String> s = new HashSet<>();
        
        while(n-->0){
            s.add(br.readLine());
        }
        int ans = 0;
        while(m-->0){
            if(s.contains(br.readLine()))
                ans++;
        }
        
        System.out.print(ans);
        
    }
}
