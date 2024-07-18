import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int cnt;

    static int div = 1000000007;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long start = Integer.MAX_VALUE+1L;

        long answer = multi( start % div, c - 1) % div;
        System.out.println(answer);

    }

    static long multi(long n, int c){

        if(c == 0)
            return 1;
        long x = multi(n, c / 2);
        if (c % 2 == 0) {
            return (x % div * x % div) % div ;
        } else {
            return (n % div * ((x * x) %div)) % div;
        }

    }


}