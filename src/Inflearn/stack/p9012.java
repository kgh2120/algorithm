package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * stack의 원리르 사용해서 문자열을 분석하는 문제.
 * 이미 한 번 풀어봐서 좀 쉽게 풀 수 있었다.
 */
public class p9012 {

    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new p9012().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String vps = br.readLine();
            int flag = 0;
            for (int j = 0; j < vps.length(); j++) {
                flag += vps.charAt(j)=='(' ? 1 : -1;
                if(flag<0)
                    break;
            }
            if(flag == 0)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        br.close();


        System.out.println(sb.toString());
    }


}