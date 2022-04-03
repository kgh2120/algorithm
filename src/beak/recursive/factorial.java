package beak.recursive;

import java.io.*;

public class factorial {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int fNumber = Integer.parseInt(br.readLine());
            String rs = Integer.toString(factorial(1, fNumber, 1));
            bw.write(rs);
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int factorial(int count, int finish, int result){
        if(finish == 0) return 1;
        if(count == finish) return result;
        return factorial(count+1, finish, result * (count + 1));
    }

}
