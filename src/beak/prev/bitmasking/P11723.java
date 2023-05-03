package beak.prev.bitmasking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P11723 {

    static final String add = "add";
    static final String remove = "remove";
    static final String check = "check";
    static final String toggle = "toggle";
    static final String all = "all";
    static final String empty = "empty";
    static int s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[]args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfLine = Integer.parseInt(br.readLine());

        s = 0;

        for(int i = 0; i<nOfLine;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            operation(st);
        }
        System.out.println(sb);


    }

    private static void operation(StringTokenizer st){
        switch (st.nextToken()){
            case add: add(Integer.parseInt(st.nextToken()));
                break;
            case remove: remove(Integer.parseInt(st.nextToken()));
                break;
            case check: check(Integer.parseInt(st.nextToken()));
                break;
            case toggle: toggle(Integer.parseInt(st.nextToken()));
                break;
            case all: all();
                break;
            case empty: empty();
                break;
        }
    }
    private static void add(int i){
        s = s | (1 << (i-1));
    }
    private static void remove(int i){
        s = s & ~(1 << (i-1));
    }
    private static void check(int i) {
        int c = s & (1 << (i-1));
        sb.append(c == 0 ? 0 : 1).append("\n");

    }
    private static void toggle(int i){
        s = s ^ (1 << (i-1));
    }
    private static void all(){
        s = (1 << 20)-1;
    }
    private static void empty(){
        s = 0;
    }
}