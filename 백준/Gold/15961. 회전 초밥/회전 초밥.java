import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int free;

//    static class Counter{
//        int n = 1;
//    }

    static int[] counter;
    static int kind;
    static int[] susi;
    static int max;

    public static void main(String[] args) throws Exception {

        PScanner sc = new PScanner(System.in);
        int n =  sc.nextInt();
        int d =  sc.nextInt();
        int k = sc.nextInt();
        int free =  sc.nextInt() -1;

        counter = new int[d+1];

        susi = new int[n];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            susi[i] = sc.nextInt() -1;
            if (i < k) {
                if(counter[susi[i]] == 0)
                    kind++;
                counter[susi[i]]++;
            }
        }

        int l = 0;
        int r = k;
        while (l < n) {
            int cur = kind;
            if (counter[free] == 0) {
                cur++;
            }
            max = Math.max(max,cur);

            if (counter[susi[l++]]-- == 1) {
                kind--;
            }

            if (counter[susi[r]] == 0) {
                kind++;

            }
            counter[susi[r]]++;
            r++;
            if(r >= n)
                r = 0;
        }
        System.out.println(max);
    }

    static class PScanner {
        private final InputStreamReader in;
        private final char[] buf;
        private int len, ptr;

        public PScanner(InputStream input) {
            in = new InputStreamReader(input);
            buf = new char[8192];
        }

        public boolean hasNext() {
            consume();
            return ptr < len && buf[ptr] > ' ';
        }

        public String next() {
            consume();
            char[] cbuf = new char[16];
            char clen = 0;
            while ((cbuf[clen++] = read()) > ' ') {
                if (clen == cbuf.length)
                    cbuf = Arrays.copyOf(cbuf, clen << 2);
            }
            return new String(cbuf, 0, clen - 1);
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
                throw new RuntimeException(e.getMessage());
            }
        }

        private void consume() {
            char c;
            while ((c = read()) <= ' ' && c != 0) ;
            ptr--;
        }
    }

}