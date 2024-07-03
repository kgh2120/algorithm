import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();
        String fail = "NOISE";
        String success = "SUBMARINE";

        if (array.length < 2) {
            System.out.println(fail);
            return;
        }


        int cursor = 0;

        while(cursor < array.length){

            if (array[cursor] == '1') {

                int zeroCount = 0;
                while(cursor < array.length-1 && array[++cursor] == '0'){
                    zeroCount++;
                }
                if (zeroCount < 2) {
                    System.out.println(fail);
                    return;
                }
                // 1 개수 세야함.

                // 1 개수 세기
                int oneCount = 0;
                while(cursor < array.length && array[cursor] == '1'){
                    oneCount++;
                    cursor++;
                }
                if (oneCount < 1) {
                    System.out.println(fail);
                    return;
                }

                // 만약 다음이 0이라면? a인지 b인지 가려줘야 함.

                if (oneCount == 1) {
                    continue;
                }
                if (cursor <= array.length - 2) {
                    if (array[cursor + 1] == '0') {
                        cursor--;
                    } else if (array[cursor + 1] == '1') {
                        cursor+=2;
                    }
                }

            }  else {
               if(cursor == array.length-1 || array[cursor+1] == '0'){
                   System.out.println(fail);
                   return;
               }
               cursor += 2;
            }
        }
        System.out.println(success);
    }


}