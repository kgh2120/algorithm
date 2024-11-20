import java.util.*;
import java.io.*;


/*
    추가 테케

    깔끔하게 다 박히는 경우

    4
    4
    4
    4
    4
    4

    4

    하나밖에 못 박는 경우

    4
    4
    1
    1
    1
    1

    1


 */
public class Main {

    static PScanner sc = new PScanner(System.in);


    static int[] parents;
    static int answer;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        int n = sc.nextInt();
        int p = sc.nextInt();

        parents = new int[n+1];
        for(int i = 0; i<= n; i++)
            parents[i] = i;

        for(int i = 0; i<p; i++){
            int num = sc.nextInt();

            int parent = find(num);

            if(parent == 0)
                break;

            parents[parent] = find(parent -1);
            answer++;
        }
        System.out.println(answer);
    }

    static int find(int i){
        if(parents[i] == i)
            return i;
        return parents[i] = find(parents[i]);
    }
        // @formatter:off
            static class PScanner{private final InputStreamReader in;private final char[]buf;private final char[]cbuf;private int len,ptr;public PScanner(InputStream input){in=new InputStreamReader(input);buf=new char[8192];cbuf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public boolean hasNextInLine(){char c;while((c=read())<=' '&&c!=0&&c!='\n');ptr--;return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=this.cbuf;int clen=0;int start=ptr;while(true){if(ptr<len){if(buf[ptr++]<=' '){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;break;}}else if(ptr==len){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;fill();start=ptr;}else break;}ptr--;if(ptr<len)clen--;return new String(cbuf,0,clen);}private char[]copy(char[]src,int srcPos,char[]dest,int destPos,int length){if(dest.length<destPos+length)dest=Arrays.copyOf(dest,dest.length << 1);System.arraycopy(src,srcPos,dest,destPos,length);return dest;}public char nextChar(){consume();return read();}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(IOException e){throw new RuntimeException(e);}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
}