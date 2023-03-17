import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(br.readLine());
        long mod = 1000000007;

        long r = 1;
        for (int i = 0; i < a-1; i++) {
            r *= (b % mod);
            r = r % mod;
        }
        System.out.println(r);
    }



    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
