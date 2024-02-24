import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws Exception {


        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 1; i < n; i++) {
            String prev = arr[i-1];
            String cur = arr[i];
            if (prev.length() > cur.length()) {
                count++;
                continue;
            }
            if (cur.startsWith(prev)) {
                continue;
            }
            count++;
        }
        System.out.println(count+1);


    }



}