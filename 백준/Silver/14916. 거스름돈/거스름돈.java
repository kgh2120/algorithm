import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int coin = Integer.parseInt(br.readLine());




        int temp = coin;
        int max = coin / 5;
        while (max >= 0) {
            temp = coin;
            temp -= max * 5;
            if (temp % 2 == 0) {
                System.out.println(max + temp/2);
                return;
            }
            max--;
        }
        System.out.println(-1);

    }
}