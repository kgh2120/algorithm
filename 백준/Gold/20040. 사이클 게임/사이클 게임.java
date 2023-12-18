import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

class Main {


    static StringTokenizer st;

    static int[] parents;

    public static void main(String[] args) throws Exception {

        PScanner sc = new PScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {

            int l = sc.nextInt();
            int r = sc.nextInt();

            if (!union(l, r)) {
                result  = i;
                break;
            }
        }

        System.out.println(result);




    }

    private static int find(int index) {
        if(parents[index] == index)
            return index;
        return parents[index] = find(parents[index]);
    }

    private static boolean union(int l, int r) {
        int lp = find(l);
        int rp = find(r);

        if(lp == rp) return false;
        parents[Math.max(lp,rp)] = Math.min(rp,lp);
        return true;
    }

 static class PScanner{private final InputStreamReader in;private final char[]buf;private final char[]cbuf;private int len,ptr;public PScanner(
         InputStream input){in=new InputStreamReader(input);buf=new char[8192];cbuf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public boolean hasNextInLine(){char c;while((c=read())<=' '&&c!=0&&c!='\n');ptr--;return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=this.cbuf;int clen=0;int start=ptr;while(true){if(ptr<len){if(buf[ptr++]<=' '){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;break;}}else if(ptr==len){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;fill();start=ptr;}else break;}ptr--;if(ptr<len)clen--;return new String(cbuf,0,clen);}private char[]copy(char[]src,int srcPos,char[]dest,int destPos,int length){if(dest.length<destPos+length)dest=Arrays.copyOf(dest,dest.length << 1);System.arraycopy(src,srcPos,dest,destPos,length);return dest;}public char nextChar(){consume();return read();}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(IOException e){throw new RuntimeException(e);}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
     static class PWriter{private final BufferedWriter out;public PWriter(
             OutputStream out){this.out=new BufferedWriter(new OutputStreamWriter(out));}public void flush(){try{out.flush();}catch(
             IOException e){throw new RuntimeException(e);}}public void print(char c){try{out.write(c);}catch(IOException e){throw new RuntimeException(e);}}public void print(int i){print(i+"");}public void print(long l){print(l+"");}public void print(float f){print(f+"");}public void print(double d){print(d+"");}public void print(Object o){print(o+"");}public void print(String s){try{out.write(s);}catch(IOException e){throw new RuntimeException(e);}}public void println(){print('\n');}public void println(char c){print(c);print('\n');}public void println(int i){print(i+"\n");}public void println(long l){print(l+"\n");}public void println(float f){print(f+"\n");}public void println(double d){print(d+"\n");}public void println(Object o){print(o+"\n");}public void println(String s){print(s);print('\n');}public void printf(String format,Object ...args){print(String.format(format,args));}}


}