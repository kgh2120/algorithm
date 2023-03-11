package beak.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    그리디 알고리즘 실버 1
    진짜 완벽하게 풀었다고 생각햇늗네 반례를 못구해서 틀림.
    반례를 좀 깊게 생각하는 연습을 해야겠다.
 */
public class P1946 {


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int k =Integer.parseInt(br.readLine());
            int target = 0;
            Map<Integer, Integer> maps = new HashMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int i1 = Integer.parseInt(st.nextToken());
                int i2 = Integer.parseInt(st.nextToken());
                maps.put(i2,i1);
                if(i1 == 1)
                    target = i2;
            }

            int count = 1;
            int max = Integer.MAX_VALUE;
            for (int j = 1; j < target; j++) {
                Integer integer = maps.get(j);
                if (max < integer) {
                    continue;
                }
                max = integer;
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }




    public static void main(String[] args) throws IOException {

        new P1946().solution();




    }

}
