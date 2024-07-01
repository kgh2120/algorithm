import java.util.*;
import java.io.*;

public class Main {

    static public void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long answer = (long) n * (m/2);
        if(m==0 ||  m%2 == 1)
            answer += n/2;
        System.out.println(answer);




    }


}