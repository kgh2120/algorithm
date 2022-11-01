package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9184 {


    int[][][]w;
    public static void main(String []args) throws Exception {
        new p9184().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        w= new int[21][21][21];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)
                break;

            sb.append(String.format("w(%d, %d, %d)",a,b,c))
                    .append(" ")
                    .append("=")
                    .append(" ")
                    .append(r(a,b,c))
                    .append("\n");
        }


        System.out.println(sb);


    }

    public int r(int a, int b, int c) {

        if(a <=0 || b <= 0 || c <= 0)
            return 1;
        if (a > 20 || b > 20 || c > 20) {
            if (w[20][20][20] == 0) {
                w[20][20][20] = r(20,20,20);
            }
            return w[20][20][20];
        }
        if (a < b && b < c) {
            if(w[a][b][c-1]==0)
                w[a][b][c-1] = r(a,b,c-1);
            if(w[a][b-1][c-1]==0)
                w[a][b-1][c-1] = r(a,b-1,c-1);
            if(w[a][b-1][c]==0)
                w[a][b-1][c] = r(a,b-1,c);

            w[a][b][c] = w[a][b][c-1]+w[a][b-1][c-1]-w[a][b-1][c];
            return w[a][b][c];
        }
        if(w[a-1][b][c]==0)
            w[a-1][b][c] = r(a-1,b,c);
        if(w[a-1][b-1][c]==0)
            w[a-1][b-1][c] = r(a-1,b-1,c);
        if(w[a-1][b][c-1]==0)
            w[a-1][b][c-1] = r(a-1,b,c-1);
        if(w[a-1][b-1][c-1]==0)
            w[a-1][b-1][c-1] = r(a-1,b-1,c-1);

        w[a][b][c] = w[a-1][b][c]+w[a-1][b-1][c]+ w[a-1][b][c-1]- w[a-1][b-1][c-1];

        return  w[a][b][c];

    }




}