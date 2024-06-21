import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aN = Integer.parseInt(br.readLine());

        int maxValue = 10_0000;
        boolean[] has = new boolean[maxValue + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aN; i++) {
            has[Integer.parseInt(st.nextToken())] = true;
        }

        int qN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] qArray = new int[qN];

        for (int i = 0; i < qN; i++) {
            qArray[i] = Integer.parseInt(st.nextToken());
        }

        int[] yaksu = new int[10_0001];


        for (int i = 1; i <= 10_0000 ; i++) {

            // 1은 contains 있는지 체크
            if(has[i])
                yaksu[i]++;

            if(yaksu[i] == 0)
                continue;
            for (int j = 2; j * i <= 10_0000 ; j++) {
                yaksu[j * i] += yaksu[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : qArray) {
            sb.append(yaksu[i]).append(" ");
        }
        System.out.println(sb);

    }




}