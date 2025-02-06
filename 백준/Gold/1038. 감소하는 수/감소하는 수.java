import java.util.*;
import java.io.*;
public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    static List<Long> list;
    static Set<Long> set = new HashSet<>();
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int n = Integer.parseInt(input.readLine());
        comb(9, 0);
        list = new ArrayList<>(set);
        Collections.sort(list);
        long ans;
        if(n >= list.size()){
            ans = -1;
        } else {
            ans = list.get(n);
        }
        System.out.println(ans);
    }
    
    // 1과 10의 차이를 구분을 줘야 함. 
    private static void comb(int i, long cur){
        
        for(int k = i; k>= 0; k--){
            long next = cur * 10 + k;
            set.add(next);
            comb(k-1, next);
        }
    }
}
