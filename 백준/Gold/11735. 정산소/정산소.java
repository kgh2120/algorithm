import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {




    static long originTotalSum;
    static StringBuilder sb;
    static int n;
    static Wrapper rowWrapper;
    static Wrapper colWrapper;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rowWrapper = new Wrapper(n);
        colWrapper = new Wrapper(n);

        
         originTotalSum = (long) n * (n + 1) / 2;
         sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (command.equals("R")) {
                // value가 이미 set에 있는가? 있다면 0
                action(rowWrapper, colWrapper, value);
            } else {
                action(colWrapper, rowWrapper, value);
            }

        }
        System.out.println(sb);


    }

    static long action(Wrapper selected, Wrapper other,  int cur){

        if (selected.contains(cur)) {
            sb.append(0).append("\n");
            return 0;
        }

        // 아니라면...

        long value = (n - other.size) * cur + originTotalSum - other.containsTotalSum;
        sb.append(value).append("\n");
        selected.add(cur);


        return cur;
    }

    static class Wrapper{
        boolean [] contains;
        long containsTotalSum;
        long size;

        public Wrapper(int n) {
            contains = new boolean[n+1];
        }

        public boolean contains(int n) {
            return contains[n];
        }

        public void add(int n) {
            contains[n] = true;
            size++;
            containsTotalSum += n;
        }

    }




}