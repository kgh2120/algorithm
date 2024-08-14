import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();


    static int[][] dp;
    static int[][] matrix;

    static int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        PScanner sc = new PScanner(System.in);

   
        n = sc.nextInt();
        m =sc.nextInt();

        matrix = new int [n][m];
        dp = new int[n][m];



        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(dfs(0,0));
        // 막히는 길 처리하기..
        
    }

    static int dfs(int row, int col){

        if(row == n-1 && col == m-1)
            return 1;
        if(dp[row][col] >= 0)
            return dp[row][col];

        dp[row][col] = 0;
        for (int[] delta : deltas) {
            int nr = row + delta[0];
            int nc = col + delta[1];

            if (isIn(nr, nc) && matrix[row][col] > matrix[nr][nc]) {
                dp[row][col] += dfs(nr, nc);
            }
        }

        return dp[row][col];
    }

    static boolean isIn(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }
         public static class PScanner {
                     private final InputStreamReader in;
                     private final char[] buf;
                     private final char[] cbuf;
                     private int len, ptr;
         
                     public PScanner(InputStream input) {
                         in = new InputStreamReader(input);
                         buf = new char[8192];
                         cbuf = new char[8192];
                     }
         
                     public boolean hasNext() {
                         consume();
                         return ptr < len && buf[ptr] > ' ';
                     }
         
                     public boolean hasNextInLine() {
                         char c;
                         while ((c = read()) <= ' ' && c != 0 && c != '\n') ;
                         ptr--;
                         return ptr < len && buf[ptr] > ' ';
                     }
         
                     public String next() {
                         consume();
                         char[] cbuf = this.cbuf;
                         int clen = 0;
                         int start = ptr;
                         while (true) {
                             if (ptr < len) {
                                 if (buf[ptr++] <= ' ') {
                                     cbuf = copy(buf, start, cbuf, clen, ptr - start);
                                     clen += ptr - start;
                                     break;
                                 }
                             } else if (ptr == len) {
                                 cbuf = copy(buf, start, cbuf, clen, ptr - start);
                                 clen += ptr - start;
                                 fill();
                                 start = ptr;
                             } else break;
                         }
                         ptr--;
                         if (ptr < len) clen--;
                         return new String(cbuf, 0, clen);
                     }
         
                     private char[] copy(char[] src, int srcPos, char[] dest, int destPos, int length) {
                         if (dest.length < destPos + length) dest = Arrays.copyOf(dest, dest.length << 1);
                         System.arraycopy(src, srcPos, dest, destPos, length);
                         return dest;
                     }
         
                     public char nextChar() {
                         consume();
                         return read();
                     }
         
                     public int nextInt() {
                         consume();
                         int v = 0;
                         char c = read();
                         boolean neg = c == '-';
                         if (neg) c = read();
                         do {
                             v = v * 10 + c - '0';
                         } while ('0' <= (c = read()) && c <= '9');
                         ptr--;
                         return neg ? -v : v;
                     }
         
                     public long nextLong() {
                         consume();
                         long v = 0;
                         char c = read();
                         boolean neg = c == '-';
                         if (neg) c = read();
                         do {
                             v = v * 10 + c - '0';
                         } while ('0' <= (c = read()) && c <= '9');
                         ptr--;
                         return neg ? -v : v;
                     }
         
                     private char read() {
                         if (ptr == len) fill();
                         return ptr < len ? buf[ptr++] : 0;
                     }
         
                     private void fill() {
                         try {
                             len = in.read(buf);
                             ptr = 0;
                         } catch (IOException e) {
                             throw new RuntimeException(e);
                         }
                     }
         
                     private void consume() {
                         char c;
                         while ((c = read()) <= ' ' && c != 0) ;
                         ptr--;
                     }
                 }

}