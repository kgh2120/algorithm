import java.io.*;

public class Main {

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