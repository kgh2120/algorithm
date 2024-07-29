import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
    static final int INF = 10_0000_0000;

    public static void main(String[] args) throws Exception {
        PScanner sc = new PScanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n+1][n+1];
        int [][]path = new int[n+1][n+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i==j) continue;
                matrix[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            if (matrix[from][to] > weight) {
                matrix[from][to] = weight;
                path[from][to] = from;
            }

        }


        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <=n ; i++) {
                for (int j = 1; j <=n ; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                int value = matrix[i][j];
                if(value == INF) value = 0;
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (path[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }
                StringBuilder sub = new StringBuilder();
                int k = findPath(sub, path, i, j) +1;
                sb.append(k).append(" ").append(sub).append(j).append("\n");
            }
        }
        System.out.println(sb);

    }

    static int findPath(StringBuilder sb, int[][] path, int i, int j){

        if (path[i][j] == 0) {
            return 0;
        }

        int val = findPath(sb, path, i, path[i][j])+1;
        sb.append(path[i][j]).append(" ");
        return val;

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