import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = -1;
        for (int i = 1; i <= k ; i++) {
            max = Math.max(max, Integer.parseInt(new StringBuilder(Integer.toString(n * i)).reverse().toString()));
        }
        System.out.println(max);
    }
}