import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    @author 김규현
    @since 2023-08-11
    @see
    @git
    @youtube
    @performance
    @category #
    @note
    난쟁이가 9명. 7난쟁이의 합이 100임.

*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        comb(0,0,new int[7],0,arr);
        System.out.println(sb);


    }
    private static void comb(int cnt, int start, int[] selected, int acc, int[]arr){
        if(flag)
            return;
        if (cnt == 7) {
            if (acc == 100) {
                for (int i : selected) {
                    sb.append(i).append("\n");
                }
                flag = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selected[cnt] = arr[i];
            comb(cnt+1, i+1, selected, acc + arr[i],arr);
        }



    }
}