import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static int n, m;
    static int[] inputStatus, status;

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputStatus = new int[n + 1];
        status = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inputStatus[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException {

        int a, b, k;
        while( m-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            status[a] += k;
            status[b + 1] -= k;
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += status[i];
            inputStatus[i] += sum;
            sb.append(inputStatus[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}