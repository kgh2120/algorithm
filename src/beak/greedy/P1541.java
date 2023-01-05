package beak.greedy;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1541 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sick = br.readLine();
        String[] splits = sick.split("-");
        for (int i = 0; i < splits.length; i++) {
            String num = splits[i];
            if (num.contains("+")) {
                String[] s2 = num.split("\\+");
                int r = 0;
                for (String s : s2) {
                    r += Integer.parseInt(s);
                }
                splits[i] = Integer.toString(r);
            }
        }


        int result = Integer.parseInt(splits[0]);
        for (int i = 1; i < splits.length; i++) {
            result -= Integer.parseInt(splits[i]);
        }

        System.out.println(result);


    }




    public static void main(String []args) throws Exception {
        new P1541().solution();
    }
}





