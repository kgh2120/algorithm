import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static char [] arr;
    static boolean result = true;
    static int index;
    static int n;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }


        long[] fraction = fraction();



        if (fraction == null || index != n-1) {
            System.out.println(-1);
        } else {

            long gcd = gcd(fraction[0], fraction[1]);
            // 다 나눠줘야 함.
            System.out.println(fraction[0]/gcd + " " + fraction[1]/gcd);

        }


    }

    static long gcd(long big, long small){


        big = big % small;
        if(big == 0)
            return small;

        return gcd(small, big);

    }

    static long[] fraction(){
        if(index == n)
            return null;

        // 5개 씩 사용한다.
        // 0 -> (, 1 -> a, 2 -> b, 3 -> c, 4 -> )
        long [] a = null;
        long [] b = null;
        long [] c = null;

        if (arr[index] != '(') {
            return null;
        }

        a = calc();
        b = calc();
        c = calc();

        if(a == null || b == null || c == null)
            return null;



        index++;
        if (index == n || arr[index] != ')') {
            return null;
        }

        // 이제 계산
        // a + ( b * c + c)

        // b * c -> b = x/y, c = a/b 일 때 x*b/y*b + a*y/b*y

        long x = b[0] * c[1];
        long y = b[1] * c[0];

        // a + x/y
        // a -> q/w
        return new long[]{ a[0]*y + a[1]*x, a[1]*y };
    }

    static long [] calc(){
        index++;
        if(index == n){
            return null;
        }
        if (arr[index] == '(') {
            return fraction();
        } else if (arr[index] == ')'){
            return null;
        } else {
            return new long[]{arr[index] - '0', 1};
        }
    }


}