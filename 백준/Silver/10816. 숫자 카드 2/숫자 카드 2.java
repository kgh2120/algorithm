import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Map<Integer,Counter> counter;
    public static void main(String[] args) throws IOException {
        counter = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(counter.containsKey(num))
                counter.get(num).count++;
            else
                counter.put(num,new Counter());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(counter.containsKey(num))
                sb.append(counter.get(num).count).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }




    private static void setVaribles() throws IOException {

    }
    static class Counter{
        int count = 1;

    }

}