package zerobase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class P16459 {

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String comment = br.readLine();
            if("0".equals(comment))
                break;
            sb.append(comment).append("\n");
        }

        final String WHO = br.readLine();
        final String WHERE = br.readLine();
        final String WHAT = br.readLine();


        String answer = sb.toString().replace("WHAT",WHAT)
                .replace("WHERE",WHERE)
                .replace("WHO",WHO);
        System.out.println(answer);

    }



}