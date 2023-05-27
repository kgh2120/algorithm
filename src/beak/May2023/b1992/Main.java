package beak.May2023.b1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static String[] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new String[n];
        for(int i = 0; i<n;i++)
            matrix[i] = br.readLine();
        String result = "";
        if(n == 1){
            result = matrix[0];
        }else{
            result = calc(0,0,n);
        }
        System.out.println(result);

    }
    private static String calc(int sr, int sc, int n){
        boolean isSame = true;
        String prev = matrix[sr].charAt(sc) + "";
        String w = "";
        if(n == 2){
            for(int i = 0; i<2; i++){
                for(int j = 0; j<2; j++){
                    char c = matrix[sr+i].charAt(sc+j);
                    w += c;
                    isSame = isSame && (prev.equals(c+""));
                    prev = c + "";
                }
            }
        }
        else{
            // 분할하기
            int next = n/2;
            for(int i = 0; i<2; i++){
                for(int j = 0; j<2; j++){
                    String s = calc(sr + (next * i), sc + (next * j), next );
                    w += s;
                    isSame = isSame && (prev.equals(s));
                    prev = s;
                }
            }

        }

        // 정산하기

        // 같다면 하나만 내보내기
        // 다르다면 앞 뒤로 () 붙혀서 내보내기
        if(isSame)
            return prev;
        return "(" + w + ")";


    }


}