import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

 class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }

            Arrays.sort(arr);

            boolean result = false;
            for (int j = 0; j < n-1; j++) {
                String prev = arr[j];
                String next = arr[j+1];
                if(prev.length() > next.length())
                    continue;
                if (next.startsWith(prev)) {
                    result = true;
                    break;
                }
            }

            sb.append(result ? "NO" : "YES").append("\n");
        }

        System.out.print(sb);
    }




}