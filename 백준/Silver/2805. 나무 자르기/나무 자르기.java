import java.util.*;
import java.io.*;
/*

    내가 몇 H를 짜를지를 선택해야 함.
    그리고 그 H에 따라서 적어도 M보다는 커야해.
    근데 만약에 내가 짤랐는데 M보다 더 많이 짤랐다면
    M보다는 크고, 지금보다는 적은 H를 선택해봐야함.
    
    일단은 binary search를 통해 M을 넘기는 H를 찾은 후,
    거기서 작은 값을 찾아봅시다.
    
    얻을 수 있는 나무의 길이 = max(0, 길이 - H);
    
*/
public class Main {
    static PScanner sc = new PScanner(System.in);

    static int n;
    static int m;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
      
        n = sc.nextInt();
        m = sc.nextInt();

        trees = new int[n];
     

        int l = 0;
        int r = -1;
        for(int i = 0; i<n; i++){
            trees[i] = sc.nextInt();
            r = Math.max(r, trees[i]);
        }
        int ans = -1;
        while(l<=r){
            int mid = (l+r) /2;
            long height = cut(mid);

            // 만약에 height가 m보다 적다면? mid를 낮춰야지
            if(height < m){
                r = mid-1;
            } else { // 충분하다면? mid를 높히면서 간을 보자
                l = mid+1;
                ans = Math.max(ans , mid);
            }
        }


        System.out.println(ans );
    }

    static long cut(int h){
        long total = 0;
        for(int tree: trees){
            total += Math.max(0, tree-h);
        }
        return total;
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