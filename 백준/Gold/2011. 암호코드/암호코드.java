import java.util.*;
import java.io.*;
public class Main {

    static String number;
    static final int MOD = 1000000;
    static int[] dp;
    static int answer;
    static final int INIT = -1;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = br.readLine();
        dp = new int[number.length()];

        Arrays.fill(dp,INIT);

        answer = find(0);
        System.out.println(answer);
    }

    private static int find(int index){
        if(index >= number.length()){
            return 1;
        }

        if(dp[index] != INIT)
            return dp[index];


        int num = Integer.parseInt(number.substring(index,index+1));
        int count = 0;
        if(num == 0)
            return dp[index] = 0;

        count += find(index+1);
        count %= MOD;


        if(index+1 < number.length()){
            int two = Integer.parseInt(number.substring(index, index+2));
            if(two <= 26){
                count += find(index+2);
                count %= MOD;
            }
        }

        return dp[index] = count;

    }
}
