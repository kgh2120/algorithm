import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
    @author 김규현
    @since 2023-08-11
    @see
    @performance
    @category #
    @note

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        int k = n/5;

        boolean flag = false;
        int cnt = 0;
        while (k >= 0) {
            int temp = n - 5*k;
            if (temp % 3 != 0) {
                k--;
                continue;
            }
            cnt = k + temp/3;
            flag = true;
            break;
        }


        if (flag) {
            System.out.println(cnt);
        }else
            System.out.println(-1);



    }
}