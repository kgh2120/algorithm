import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aN = Integer.parseInt(br.readLine());

        Set<Integer> aNumber = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aN; i++) {
            aNumber.add(Integer.parseInt(st.nextToken()));
        }

        int qN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] qArray = new int[qN];
        int maxValue = -1;
        for (int i = 0; i < qN; i++) {
            qArray[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, qArray[i]);
        }

        int[] yaksu = new int[maxValue + 1];
        Arrays.fill(yaksu, -1);

        for (int i = 0; i < qN; i++) {
            int number = qArray[i];
            fill(yaksu, number, aNumber);
        }


        StringBuilder sb = new StringBuilder();
        for (int i : qArray) {
            sb.append(yaksu[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static int fill(int [] dp, int curValue, Set<Integer> aNumber){
        if (curValue <= 0) {
            return 0;
        }

        if(dp[curValue] != -1) return dp[curValue];
        dp[curValue] = 0;
        for (int i = 1; i <= Math.sqrt(curValue) ; i++) {
            if(curValue % i != 0)
                continue;
            int bigger = curValue / i;
            if (bigger == curValue) {
                if(aNumber.contains(bigger))
                    dp[curValue] += 1;
            }else
                dp[curValue] += fill(dp, bigger, aNumber);
            if(bigger == i)
                continue;
            dp[curValue] += fill(dp, i, aNumber);
        }

        return dp[curValue];
    }


}