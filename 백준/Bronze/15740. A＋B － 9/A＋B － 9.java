import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        BigInteger result = new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken()));
        System.out.println(result.toString());
    }




}