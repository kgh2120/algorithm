import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(tc-- > 0) {

            n = Integer.parseInt(br.readLine());
            trees = new int[n+1];

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                trees[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aDepth = calcDepth(a);
            int bDepth = calcDepth(b);

            while(aDepth > bDepth){
                a = trees[a];
                aDepth = calcDepth(a);
            }
            while(aDepth < bDepth){
                b = trees[b];
                bDepth = calcDepth(b);
            }

            // 이제 높이 똑같음
            while (a != b) {
                a = trees[a];
                b = trees[b];
            }
            answer.append(a).append("\n");
        }
        System.out.print(answer);

    }



    private static int calcDepth(int tree){
        if(trees[tree] == 0){
            return 1;
        }
        return calcDepth(trees[tree]) + 1;
    }

}
