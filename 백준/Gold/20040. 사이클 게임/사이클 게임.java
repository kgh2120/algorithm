import java.io.*;
import java.util.*;

/**
 사이클이 형성이 되는 턴을 리턴한다.
 사이클이 생성되지 않는다면 0을 리턴한다.

 사이클의 유무는 유니온 파인드로 체크해볼까 한다.
 더 낮은 애를 기준으로 유니온을 묶는데,
 이미 둘의 부모가 같다면 사이클이라고 생각해도 좋아보인다.
 **/
public class Main {

   

    static int[] parents;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        PScanner sc = new PScanner(System.in);
        int n = sc.nextInt();
        int maxTurn = sc.nextInt();

        parents = new int[n];
        for(int i =0; i<n; i++)
            parents[i] = i;

        for(int i = 1; i<=maxTurn; i++){
            
            int l = sc.nextInt();
            int r = sc.nextInt();

            if(union(l,r)){
                System.out.println(i);
                return;
            }

        }
        System.out.println(0);

    }

    static boolean union(int l, int r){
        int lp = find(l);
        int rp = find(r);

        if(lp == rp)
            return true;

        if(lp <= rp)
            parents[rp] = lp;
        else
            parents[lp] = rp;
        return false;

    }

    static int find(int n){
        if(parents[n] == n)
            return n;
        return parents[n] = find(parents[n]);
    }
    
        // @formatter:off
            static class PScanner{private final InputStreamReader in;private final char[]buf;private final char[]cbuf;private int len,ptr;public PScanner(InputStream input){in=new InputStreamReader(input);buf=new char[8192];cbuf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public boolean hasNextInLine(){char c;while((c=read())<=' '&&c!=0&&c!='\n');ptr--;return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=this.cbuf;int clen=0;int start=ptr;while(true){if(ptr<len){if(buf[ptr++]<=' '){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;break;}}else if(ptr==len){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;fill();start=ptr;}else break;}ptr--;if(ptr<len)clen--;return new String(cbuf,0,clen);}private char[]copy(char[]src,int srcPos,char[]dest,int destPos,int length){if(dest.length<destPos+length)dest=Arrays.copyOf(dest,dest.length << 1);System.arraycopy(src,srcPos,dest,destPos,length);return dest;}public char nextChar(){consume();return read();}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(IOException e){throw new RuntimeException(e);}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
}