import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    static StringTokenizer st;


    static int n, l;
    static Water[] waters;
    static int result = 0;

    public static void main(String[] args) throws Exception {

        PScanner sc = new PScanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        waters = new Water[n];

        for (int i = 0; i < n; i++) {

            waters[i] = new Water(sc.nextInt(),sc.nextInt());

        }
        Arrays.sort(waters);


        int i = waters[0].start;
        int j = 0;
        int max = waters[waters.length-1].end;
        while (i < max) {
            Water water = waters[j];
            int diff = water.end - i;
            int k = diff/l + (diff%l != 0 ? 1 : 0);
            result += k;
            i += k * l;
            j++;
            if(i >= max || j >= waters.length)
                break;
            while (waters[j].end <= i)
                j++;
            if(waters[j].start > i)
                i = waters[j].start;
        }
        System.out.println(result);
    }
    static class Water implements Comparable<Water> {

        int start;
        int end;

        public Water(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Water o) {
            return Integer.compare(start, o.start);
        }

    }

    static class PScanner{private final InputStreamReader in;private final char[]buf;private int len,ptr;public PScanner(
                InputStream input){in=new InputStreamReader(input);buf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=new char[16];char clen=0;while((cbuf[clen++]=read())>' '){if(clen==cbuf.length)cbuf=Arrays.copyOf(cbuf,clen << 2);}return new String(cbuf,0,clen - 1);}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(
                IOException e){throw new RuntimeException(e.getMessage());}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}

}