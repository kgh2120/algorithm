import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;




    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();

        int lb = 0;
        int lr = 0;
        int rr = 0;
        int rb = 0;

        char leftStart = array[0];
        char rightStart = array[n-1];

        boolean lChanged = false;
        boolean rChanged = false;
        for (int l = 0, r = n - 1; l < n; l++, r--) {

            if (leftStart != array[l]) {
                lChanged = true;
            }
            if (rightStart != array[r]) {
                rChanged = true;
            }

            if (lChanged) {
                if (array[l] == 'R') {
                    lr++;
                }else {
                    lb++;
                }
            }

            if (rChanged) {
                if (array[r] == 'R') {
                    rr++;
                }else {
                    rb++;
                }
            }
        }


        int result = Math.min(Math.min(lb, lr), Math.min(rb, rr));

        System.out.println(result);


    }

}