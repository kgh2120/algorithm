package beak.prev.backtracking;

import java.io.*;

/*
    비 내림차순이라는 개념이 도입된 문제
     비 내림차순이란 수열에 있어서 n번째 수가 n-1보다 크거나 같은 구조를 지닌 수열의 구조이다.
 */
public class P_15652_NM4 {

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String val = br.readLine();
        String[] cons = val.split(" ");
        int x = Integer.parseInt(cons[0]);
        int y = Integer.parseInt(cons[1]);

        Backtracking(x,y,1,0,"");
        bw.flush();
    }

    public static void Backtracking(int x, int y,int last, int now, String result) throws IOException {
        if (y == now) {
            bw.write(result+"\n");
        }else {
            for (int i = 1; i <=x ; i++) {
                if(i >= last)
                    Backtracking(x,y,i,now+1,result+i+ " ");
            }
        }
    }


}