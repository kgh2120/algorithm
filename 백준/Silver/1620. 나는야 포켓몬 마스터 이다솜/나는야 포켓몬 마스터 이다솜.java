import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] idxName = new String[n+1];
        Map<String, Integer> nameIdx = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            idxName[i] = name;
            nameIdx.put(name, i);
        }
        
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            String text = br.readLine();
            if(Character.isDigit(text.charAt(0))){
                sb.append(idxName[Integer.parseInt(text)]).append("\n");
            } else {
                sb.append(nameIdx.get(text)).append("\n");
            }
            
        }
        
        System.out.println(sb);
        
    }
}
