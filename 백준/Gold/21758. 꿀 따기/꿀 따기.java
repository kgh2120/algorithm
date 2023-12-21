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


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] acc;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        acc = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int w = Integer.parseInt(st.nextToken());
            acc[i] = w + acc[i - 1];
        }

        // 1 ~ n까지 돌면서 값 체크

        int answer = 0;
        for (int i = 2; i < n ; i++) {
            // 1) 왼 왼
            int a1 = acc[n] - acc[1] - (acc[i] - acc[i-1]);
            int b1= acc[n] - acc[i];
            answer = Math.max(answer, a1 + b1);
            // 2 ) 왼 오

            int a2 = acc[i] - acc[1];
            int b2 = acc[n-1] - acc[i-1];
            answer = Math.max(answer, a2 + b2);

            // 3 ) 오 오
            int a3 = acc[i-1] - acc[0];
            int b3 = acc[n-1] - acc[0] - (acc[i] - acc[i - 1]);
            answer = Math.max(answer, a3 + b3);
        }
        System.out.println(answer);
    }






}