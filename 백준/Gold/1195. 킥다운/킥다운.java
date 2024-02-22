import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        char[] up = br.readLine().toCharArray();
        char[] down = br.readLine().toCharArray();

        if (up.length < down.length) {
            char[] temp = up;
            up = down;
            down = temp;
        }
        int total = up.length + down.length;
        int minLength = total;




        int l = 0;
        int r = 0;

        int lLastIndex = up.length-1;
        int rIndex = down.length -1;

        while (r < lLastIndex + rIndex + 1) {
            boolean flag = true;
            if (r > lLastIndex) {
                int loop = rIndex - (r-lLastIndex);
                for (int i = 0 ; i  <= loop; i++) {
                    if (up[lLastIndex - i] + down[loop - i] > 3 + '0' + '0') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    minLength = Math.min(minLength, total - (loop + 1));
                }


            }else{
                int loop = Math.min(r, rIndex);
                for (int i = 0; i <= loop; i++) {
                    if (up[r - i] + down[rIndex - i] > 3 + '0' + '0') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    minLength = Math.min(minLength, total - (loop+1));
                }
            }
            r++;
        }

        System.out.println(minLength);



    }





}