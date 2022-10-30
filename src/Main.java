import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        boolean flag = true;
        while (n-- > 0) {
            int v = Integer.parseInt(br.readLine());

            for (int i = start+1; i <=v ; i++) {
                s.push(i);
                sb.append("+").append("\n");
                start = i;
            }

            Integer pop = s.pop();
            sb.append("-").append("\n");
            if (!pop.equals(v)) {
                flag = false;
                break;
            }

        }

        System.out.println(flag ? sb.toString() : "NO");
    }






    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}