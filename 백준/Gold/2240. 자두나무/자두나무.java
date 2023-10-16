import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {




    static int[] arr;
    static int[][][] dp;
    static int T, W;
    public static void main(String[] args) throws IOException {
        PScanner sc = new PScanner(System.in);
        T = sc.nextInt();
        W = sc.nextInt();
        arr = new int[T];
        dp = new int[W+1][2][T];
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(dp(W, 0, 0));
    }

    private static int dp(int ablil, int dir, int depth){
        if (depth == T) {
            return 0;
        }
        if(dp[ablil][dir][depth] != 0) return dp[ablil][dir][depth];

        int result = 0;

        // 현재 위치와 떨어질 위치가 같은 경우
        if (dir == arr[depth] - 1) {
            result = Math.max(result, dp(ablil,dir,depth+1) +1);
        }
        // 현재 위치와 떨어지는 위치가 달라서 능력을 쓸 경우
        if (ablil > 0 && dir != arr[depth] - 1) {
            result = Math.max(result,dp(ablil-1,dir^1,depth+1) +1 );
        }
        // 현재 위치와 떨어지는 위치가 다른데 능력을 안 쓸 경우
        if(dir != arr[depth] -1)
            result = Math.max(result,dp(ablil,dir,depth+1));
        return  dp[ablil][dir][depth] = result;
    }



static class PScanner{private final InputStreamReader in;private final char[]buf;private int len,ptr;public PScanner(
            InputStream input){in=new InputStreamReader(input);buf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=new char[16];char clen=0;while((cbuf[clen++]=read())>' '){if(clen==cbuf.length)cbuf=Arrays.copyOf(cbuf,clen << 2);}return new String(cbuf,0,clen - 1);}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(
            IOException e){throw new RuntimeException(e.getMessage());}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}

}