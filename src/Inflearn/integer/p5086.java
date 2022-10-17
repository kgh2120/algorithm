package Inflearn.integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class p5086 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String command = "";
            while (true) {
                command = br.readLine();
                if(command.equals("0 0"))
                    break;
                StringTokenizer st = new StringTokenizer(command, " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if (n1 < n2) {
                    if (n2 % n1 == 0) {
                        sb.append("factor\n");
                    }else
                        sb.append("neither\n");
                }else
                    if (n1 % n2 == 0)
                        sb.append("multiple\n");
                    else
                        sb.append("neither\n");
            }

        }
        out.println(sb.toString());
    }

}