import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[6];
            for (int i = 0; i < 6; i++) {
                int sizeCount = Integer.parseInt(st.nextToken());
                arr[i] = sizeCount;
            }
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int size : arr) {
                int v = getV(size, t);
                cnt+=v;
            }

            StringBuilder sb = new StringBuilder().append(cnt).append("\n");
            sb.append(n/p).append(" ").append(n % p);
            System.out.println(sb);

        }

        private static int getV(int size, int t) {
            int v = size / t +1;
            if(size % t == 0)
                v--;
            return v;
        }


    }