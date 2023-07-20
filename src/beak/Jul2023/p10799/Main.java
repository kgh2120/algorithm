package beak.Jul2023.p10799;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static final char OPEN = '(';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int answer = 0;
        int count = 0;
        int length = chars.length;
        /*
            로직 정리
            1. OPEN이고, 다음도 OPEN이면 count에 +1을 한다.
            2. OPEN이고 다음이 CLOSE이면, count만큼 answer에 더한다, 인덱스를 +1한다.
            3. CLOSE라면 count를 -1하고 answer에 +1을 한다.
         */
        for(int i =0; i< length; i++){
            if (chars[i] == OPEN) {
                if (chars[i + 1] == OPEN) {
                    count++;
                } else {
                    answer += count;
                    i++;
                }
            } else {
                count--;
                answer ++;
            }

        }

        System.out.println(answer);
    }

}