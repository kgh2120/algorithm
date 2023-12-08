import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;




    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        loop: for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] parents = new int[n + 1];
            for (int i = 0; i < n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parents[c] = p;
            }

            // 구할 녀석
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int alpha = a; alpha != 0 ; alpha  = parents[alpha]) {

                for (int beta = b; beta != 0 ; beta  = parents[beta]) {

                    if (alpha == beta) {
                        sb.append(alpha)
                                .append("\n");
                        continue loop;
                    }
                }
            }
        }

        System.out.println(sb);


    }





}