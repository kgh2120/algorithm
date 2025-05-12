import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static long answer;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Counter> map;

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            answer = 1L;

            int k = Integer.parseInt(br.readLine());

            map = new HashMap<>();
            for(int i = 0; i < k; i++){

                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                Counter counter = map.get(kind);
                if(counter == null){
                    counter = new Counter();
                    map.put(kind, counter);
                }
                counter.v++;

            }

            for(Counter c : map.values())
                answer *= c.v;

            sb.append(answer-1).append("\n");
        }
        System.out.print(sb);

    }



    static class Counter{
        int v = 1;
    }
}
