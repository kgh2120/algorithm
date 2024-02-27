import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean['z' - 'a' + 1];

            char[] array = br.readLine().toCharArray();

            boolean flag = true;
            for (int j = 1; j < array.length; j++) {

                char cur = array[j];
                char prev = array[j - 1];
                if (visited[cur - 'a']) {
                    flag = false;
                    break;
                }


                if (cur != prev) {
                    visited[prev - 'a'] = true;
                }

            }

            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }


}