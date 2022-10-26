package Inflearn.integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 답지 보고 풀었음. 조합을 사용하면 풀 수 있었는데..
 * 수학적 규칙을 먼제 파악할 수 있어야 하는 거 같다.
 */
public class p9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int n2 = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                String type = st.nextToken();
                if (map.containsKey(type)) {
                    map.put(type,map.get(type)+1);
                }else
                    map.put(type,1);


            }
            int m = 1;
            for (int kn : map.values()) {
                m *= (kn+1);
            }
            sb.append(m).append("\n");

        }

        System.out.println(sb.toString());


    }




}