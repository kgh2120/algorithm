import java.util.*;
import java.io.*;


/*
    author : 규현
    date : 2023-08-23
    url : 
    performance :
    category : 
    note:



*/
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

//    static Map<Integer,Counter> counter;

    static int free;

//    static class Counter{
//        int n = 1;
//    }

    static int[] counter;
    static int kind;
    static int[] susi;
    static int max;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int free = Integer.parseInt(st.nextToken());

        counter = new int[d+1];

        susi = new int[n];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            susi[i] = Integer.parseInt(br.readLine());
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



}