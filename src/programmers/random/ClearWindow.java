package programmers.random;

import java.io.IOException;

public class ClearWindow {



    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = 51; // 작아야함
        int luy = 51; // 작아야함
        int rux = -1; // 커야함
        int ruy = -1; // 커야함

        for(int i = 0; i<wallpaper.length;i++){
            for(int j = 0; j<wallpaper[0].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    lux = Math.min(lux,j);
                    luy = Math.min(luy,i);
                    rux = Math.max(rux,j);
                    ruy = Math.max(ruy,i);
                }
            }
        }
        answer[1] = lux;
        answer[0] = luy;
        answer[3] = rux+1;
        answer[2] = ruy+1;



        return answer;
    }



    public static void main(String[] args) throws IOException {

        String [] a = {".#...", "..#..", "...#."};
        System.out.println(((new ClearWindow().solution(a))));

    }
}
