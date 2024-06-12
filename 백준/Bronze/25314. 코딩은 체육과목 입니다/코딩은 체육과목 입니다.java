import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = number/4;
        for (int i = 0; i < n; i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }



}