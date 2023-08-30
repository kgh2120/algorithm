import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[][] combMatrix;
    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        combMatrix = new int[30][30];
        for (int i = 0; i < 30; i++) {
            combMatrix[i][0] = 1;
            combMatrix[i][i] = 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(comb(n,r)).append("\n");
        }
        System.out.println(sb);
    }

    private static int comb(int n,int r) {
        if(combMatrix[n][r] != 0) return combMatrix[n][r];
        return combMatrix[n][r] = comb(n-1,r-1) + comb(n-1,r);
    }



}