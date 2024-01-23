import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    20437 문자열 게임 2


 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int [] normalAcc;
    static int [] reverseAcc;

    static int [] fullAcc;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        normalAcc = new int[h];
        reverseAcc = new int[h];
        fullAcc = new int[h];


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                // 석순
                normalAcc[num-1]++;
            }else{
                // 종유석
                reverseAcc[h-num]++;
            }
        }
        
        for (int i = 0, r = h-1; i < h-1 ; i++, r--) {
            normalAcc[r-1]+= normalAcc[r];
            reverseAcc[i+1] += reverseAcc[i];
        }

        for (int i = 0; i < h; i++) {
            fullAcc[i] = normalAcc[i] + reverseAcc[i];
        }

        Arrays.sort(fullAcc);



        // binary search 부분을 다시 짜야 함.

        int i = Arrays.binarySearch(fullAcc, fullAcc[0] + 1);
        if(i  < 0){
            i = (i + 1) * -1;
        }else{
            for (int j = i; j >= 0 ; j--) {
                if (fullAcc[j] == fullAcc[0]) {
                    i = j+1;
                    break;
                }
            }
        }





        System.out.print(fullAcc[0] + " " + i);
    }



}