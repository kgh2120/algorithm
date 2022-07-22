package beak.backtracking;

import java.io.*;
/*
    알고리즘이 좀 더 할 일이 많아서 그런지 타임아웃이 발생.
    Scanner , System.out 에서 BufferedReader, BufferedWriter로 바꾸니 통과
    시간 제한이 1초였는데 Buffered를 사용할 때에는 512ms가 나온것을 보니 거의 2배정도의 차이가 발생하는 듯 하다.
 */
public class P_15651_NM3 {

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String val = br.readLine();
        String[] cons = val.split(" ");
        int x = Integer.parseInt(cons[0]);
        int y = Integer.parseInt(cons[1]);

        Backtracking(x,y,0,"");
        bw.flush();
    }

    public static void Backtracking(int x, int y, int now, String result) throws IOException {
        if (y == now) {
            bw.write(result+"\n");
        }else {
            for (int i = 1; i <=x ; i++) {
                    Backtracking(x,y,now+1,result+i+ " ");
            }
        }
    }


}