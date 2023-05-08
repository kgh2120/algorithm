package goorm.may23.q1;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = 0;
        if(input == 1)
            answer = 0;
        else if(input == 2)
            answer = 1;
        else{
            int l = 0;
            int r = 1;
            for(int i = 3; i <= input; i++){
                int temp = r;
                r = (l% 1000000007 + r% 1000000007) % 1000000007;
                l = temp% 1000000007;
            }
            answer = r % 1000000007;
        }


        System.out.println(answer);
    }


}