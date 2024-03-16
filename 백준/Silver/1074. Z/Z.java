import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * - @author 규현
 * - @since 2024-03-16
 * - @limit memory :  time :
 * - @performance
 * - @category
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());

        System.out.println(findValue(0, 0, 0, targetR, targetC, n));

    }

    static int findValue(int value, int startR, int startC, int targetR, int targetC, int n){
        if(n == 0)
            return value;

        int a = (int) Math.pow(2, n - 1);
        int b = (int) Math.pow(4, n-1);

        if (targetR >= startR + a) {
            value += b*2;
            startR += a;
        }
        if (targetC >= startC + a) {
            value += b;
            startC += a;
        }
        return findValue(value, startR, startC, targetR, targetC, n-1);


    }




}