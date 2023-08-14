import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
    @author 김규현
    @since 2023-08-14
    @see
    @git
    @youtube
    @performance
    @category #
    @note

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, r,c;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursive(0,0,0,n);

    }

    private static void recursive(int startValue, int sr, int sc, int n){
        // r과 c가 몇 사분면에 속하는 지 체크하고 startValue를 넘긴다

        if (sr == r && sc == c) {
            System.out.println(startValue);
            return;
        }
        if(n == 0)
            return;
        int nValue = (int)Math.pow(2, 2 * (n-1));

        int size = (int) Math.pow(2, n-1);
//        if(sr + size >= r)
        // 1사분면
        if (sr + size > r && sc + size > c) {
            recursive(startValue, sr,sc,n-1);
        }
        // 2사분면
        if (sr + size > r && sc + size <= c) {
            recursive(startValue + nValue, sr,sc+size,n-1);
        }
        // 3사분면
        if (sr + size <= r && sc + size > c) {
            recursive(startValue + nValue * 2, sr+size,sc,n-1);
        }
        // 4
        if (sr + size <= r && sc + size <= c) {
            recursive(startValue + nValue * 3, sr+size,sc+size,n-1);
        }

    }



}