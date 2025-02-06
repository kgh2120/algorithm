import java.util.*;
import java.io.*;

/* 
    A를 B번 곱한 수 -> A^B
    B의 횟수가 너무 크다. Integer.MAX_VALUE
    그냥 반복문으로는 불가능.
    분할정복 거듭제곱 방법을 이용해야 할 듯.
*/
public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        st = new StringTokenizer(input.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long ans = pow(a,b,c);
        System.out.println(ans);
        
    }
    
    static long pow(int a, int b, int c){
        
        if(b == 1)
            return a % c;
        
        if(b%2 == 0){
            long k = pow(a,b/2, c) % c;
            return (k * k) % c;
        } else {
            long k = pow(a,(b)/2, c) % c;
            return (((k * k) % c) * a) % c;
        }
        
        
        
    }
}
