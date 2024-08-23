import java.util.*;
import java.io.*;
/*

    내가 몇 H를 짜를지를 선택해야 함.
    그리고 그 H에 따라서 적어도 M보다는 커야해.
    근데 만약에 내가 짤랐는데 M보다 더 많이 짤랐다면
    M보다는 크고, 지금보다는 적은 H를 선택해봐야함.
    
    일단은 binary search를 통해 M을 넘기는 H를 찾은 후,
    거기서 작은 값을 찾아봅시다.
    
    얻을 수 있는 나무의 길이 = max(0, 길이 - H);
    
*/
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        
        int l = 0;
        int r = -1;
        for(int i = 0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, trees[i]);
        }
        int ans = -1;
        while(l<=r){
            int mid = (l+r) /2;
            long height = cut(mid);
            
            // 만약에 height가 m보다 적다면? mid를 낮춰야지
            if(height < m){
                r = mid-1;
            } else { // 충분하다면? mid를 높히면서 간을 보자
                l = mid+1;
                ans = Math.max(ans , mid);
            }
        }
        
        
        System.out.println(ans );
    }
    
    static long cut(int h){
        long total = 0;
        for(int tree: trees){
            total += Math.max(0, tree-h);
        }
        return total;
    }
}
