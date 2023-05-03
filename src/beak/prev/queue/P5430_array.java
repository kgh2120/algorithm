package beak.prev.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5430_array {

    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        int n = Integer.parseInt(br.readLine());

       loop: for (int i = 0; i < n; i++) {

            // 명령 받기
            String commands = br.readLine();
            // 배열 개수
            int nOfArray = Integer.parseInt(br.readLine());
            // 배열 받기
            String[] arrays = br.readLine().replace('[', ' ').replace(']', ' ').trim().split(",");

            int l = 0;
            int r = nOfArray-1;

            boolean reverse = false;
            for (int j = 0; j < commands.length(); j++) {
                if (commands.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (r < l) {
                        sb.append("error").append("\n");
                        continue loop;
                    }
                    if (reverse) {
                        r--;
                    } else {
                        l++;
                    }

                }
            }
            sb.append("[");
            if (reverse) {
                for (int j = r; j >= l; j--) {
                    sb.append(arrays[j]);
                    if (j != l) {
                        sb.append(",");
                    }
                }
            }else{
                for (int j = l; j <= r; j++) {
                    sb.append(arrays[j]);
                    if (j != r) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]").append("\n");

        }
        System.out.println(sb.toString());
    }




    public static void main(String[] args) throws Exception {
        new P5430_array().solution();
    }
}





