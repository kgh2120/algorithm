import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int[] counter;
    static int[] dp;

    public static void main(String[] args) throws Exception {


        counter = new int[1_000_001];

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            counter[number]++;
            numbers[i] = number;
        }

        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            // number에 대한 약수 찾기
            int result = 0;

                for (int i = 1; i <= Math.sqrt(number) ; i++) {
                    if (number % i == 0) {
                        if (number == 1) {
                            result += counter[number] -1;
                        }else{
                            result += counter[i];
                            if (i != Math.sqrt(number)) {
                                if (i == 1) {
                                    result += counter[number] -1;
                                }else{
                                    result += counter[number/i];
                                }
                            }
                        }

                    }
                }

            sb.append(result).append("\n");
        }

        System.out.println(sb);





    }





}