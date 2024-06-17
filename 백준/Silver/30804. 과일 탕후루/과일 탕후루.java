import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static PScanner scanner  = new PScanner(System.in);


    public static void main(String[] args) throws Exception {

        int n = scanner.nextInt();
        int[] tanghuru = new int[n];

        for (int i = 0; i < n; i++) {
            tanghuru[i] = scanner.nextInt();
        }

        int left = 0;
        int right = 0;

        int fruitA = -1;
        int fruitB = -1;
        int fruitALastIndex = -1;
        int fruitBLastIndex = -1;

        int maxLength = -1;
        while (left <= right && right < n) {
            int next = tanghuru[right];
            if(fruitA == -1 ) {
                fruitA = next;
                fruitALastIndex = right;
            }else if(fruitA != next && fruitB == -1) {
                fruitB = next;
                fruitBLastIndex = right;
            }else { // 둘 다 찬 경우
                // 그런데 이미 같은 경우?
                if (fruitA == next) {
                    fruitALastIndex = right;
                }else if(fruitB == next) {
                    fruitBLastIndex = right;
                }else {
                    // 둘 중 index가 낮은 애가 나가라..
                    if(fruitALastIndex > fruitBLastIndex) {
                        left = fruitBLastIndex +1;
                        fruitB = next;
                        fruitBLastIndex = right;
                    }else {
                        left = fruitALastIndex +1;
                        fruitA = next;
                        fruitALastIndex = right;
                    }
                }
            }
            right++;
            maxLength = Math.max(maxLength, right - left);

        }

        System.out.println(maxLength);
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