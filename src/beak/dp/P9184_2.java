package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9184_2 {


    int[][][] memo = new int[21][21][21];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1)
                break;

            sb.append("w(").append(a).append(", ").append(b).append(", ")
                    .append(c).append(") = ").append(w(a,b,c))
                    .append("\n");
        }
        System.out.println(sb);
    }

    public int w(int a,int b,int c){

        if(a >0 && b>0 && c>0 && memo[a][b][c]!=0 )
            return memo[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return memo[20][20][20] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            return  memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return memo[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }






    public static void main(String[] args) throws Exception {
        new P9184_2().solution();
    }

}
