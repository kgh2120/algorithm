import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] filter;
    static int n;
    static int num;
    static List<Integer> primeNumbers;

    public static void main(String[] args) throws Exception {

        num = Integer.parseInt(br.readLine());
        if (num == 1) {
            System.out.println(0);
            return;
        }
        filter = new boolean[num+1];
        primeNumbers = new ArrayList<>();
        getPrimeNumbers();

        int l = 0;
        int r = 0;
        int acc = primeNumbers.get(l);
        int size = primeNumbers.size();
        while (l <= r && l < size) {
            if (acc < num) {
                if(r == size -1)
                    break;
                acc += primeNumbers.get(++r);
            } else if (acc > num) {
                acc -= primeNumbers.get(l++);
            }else{
                n++;
                acc -= primeNumbers.get(l++);
                if(r == size-1)
                    break;
                acc += primeNumbers.get(++r);
            }
        }
        System.out.println(n);

    }

    private static void getPrimeNumbers() {
        for (int i = 2; i <= num ; i++) {
            if(filter[i]) continue;
            filtering(i);
            primeNumbers.add(i);
        }
    }

    private static void filtering(int n){

        for (int i = 2; i* n <= num ; i++) {
            filter[i*n] = true;
        }
    }




}