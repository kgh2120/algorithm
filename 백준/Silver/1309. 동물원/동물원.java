import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int mod = 9901;
        int answer = 3;
        int prev = 1;
        for(int i = 1; i < n; i++){
            int temp = answer;
            answer = 2 * answer + prev;
            answer %= mod;
            prev = temp;
        }

        System.out.println(answer);



    }


}
