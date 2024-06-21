import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {


        PScanner sc= new PScanner(System.in);
        int aN = sc.nextInt();

        int[] yaksu = new int[10_0001];
        for (int i = 0; i < aN; i++) {
            yaksu[sc.nextInt()]++;
        }
        int qN = sc.nextInt();
        int[] qArray = new int[qN];
        for (int i = 0; i < qN; i++) {
            qArray[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= 10_0000 ; i++) {

            if(yaksu[i] == 0)
                continue;
            for (int j = 2; j * i <= 10_0000 ; j++) {
                yaksu[j * i] += yaksu[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : qArray) {
            sb.append(yaksu[i]).append(" ");
        }
        System.out.println(sb);

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