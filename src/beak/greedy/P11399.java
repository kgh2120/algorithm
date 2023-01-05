package beak.greedy;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = 0;
        while (k!=n) {
            array[k] = Integer.parseInt(st.nextToken());
            k++;
        }
        Arrays.sort(array);

        long r = 0;
        long p = 0;
        for (int i : array) {
           p += i;
           r +=p;
        }
        System.out.println(r);
    }




    public static void main(String []args) throws Exception {
        new P11399().solution();
    }
}





