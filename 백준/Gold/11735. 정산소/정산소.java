import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {


    static Set<Long> deletedRow;
    static Set<Long> deletedCol;
    static long deletedRowSum ;
    static long deletedColSum;
    static long originTotalSum;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        deletedRow = new HashSet<>();
        deletedCol = new HashSet<>();
         deletedRowSum = 0;
         deletedColSum = 0;
        
         originTotalSum = (long) n * (n + 1) / 2;
         sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (command.equals("R")) {
                // value가 이미 set에 있는가? 있다면 0
                deletedRowSum += action(deletedRow, deletedCol, deletedColSum, value);
            } else {
                deletedColSum += action(deletedCol, deletedRow, deletedRowSum, value);
            }

        }
        System.out.println(sb);


    }

    static long action(Set<Long> selected, Set<Long> other, long deletedAcc,  long cur){

        if (selected.contains(cur)) {
            sb.append(0).append("\n");
            return 0;
        }

        // 아니라면...

        long value = (long) (n - other.size()) * cur + originTotalSum - deletedAcc;
        sb.append(value).append("\n");
        selected.add(cur);


        return cur;
    }




}