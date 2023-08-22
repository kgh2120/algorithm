import java.util.*;
import java.io.*;




/*
    author : 규현
    date : 2023-08-22
    url : https://www.acmicpc.net/problem/1759
    performance :
    category :
    note:


*/
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int n, m;
    static String[] arr;
    static int[] selected;
    static final String 모음 = "aeiou";
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new String[m];
        for(int i = 0; i<m; i++)
            arr[i] = st.nextToken();

        Arrays.sort(arr);
        
        selected = new int[n];
        combination(0,0,0,0);
        System.out.println(sb);

    }
    
    private static void combination(int cnt, int start, int nOfM, int nOfJ) {
        if (cnt == n) {
            if(nOfM < 1 || nOfJ < 2)
                return;

            for (int i : selected) {
                sb.append(arr[i]);
            }
            sb.append("\n");
            
            return;
        }

        for (int i = start; i < m; i++) {
            selected[cnt] = i;
            if (모음.contains(arr[i])) {
                combination(cnt+1, i+1, nOfM+1, nOfJ);
            }else{
                combination(cnt+1, i+1, nOfM, nOfJ+1);
            }

        }
        
    }
}