import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {



    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int[] n = new int [value.length()];

        boolean flag = false;
        for(int i = 0; i<value.length();i++){
            int v = value.charAt(i) - 48;
            if(v == 0){
                flag = true;
            }
            n[i] = v;
        }

        if(!flag){
            return -1;
        }

        int sum = Arrays.stream(n).sum();
        if(sum % 3 != 0)
            return -1;

        Arrays.sort(n);
        StringBuilder sb = new StringBuilder();
        for(int i = n.length-1 ; i>=0; i--)
            sb.append(n[i]);

        return Integer.parseInt(sb.toString());
    }




    public static void main(String[] args) throws IOException {


        System.out.println(((new Solution().solution())));



    }
}