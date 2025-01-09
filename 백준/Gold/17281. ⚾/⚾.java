import java.util.*;
import java.io.*;

/**



 **/
public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int [] order;
    static boolean[] selected = new boolean[9];
    static int maxIning;
    static int[][] result;

    static int maxScore;
    static int cursor = -1;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        maxIning = Integer.parseInt(input.readLine());
        result = new int[maxIning][9];

        order = new int[9];
        selected[0] = true;

        for (int i = 0; i < maxIning; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < 9; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        play(0);

        System.out.println(maxScore);

    }

    static void play(int depth){

        if (depth == 9) {
            baseball();
            return;
        }

        if (depth == 3) {
            play(depth+1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if(selected[i]) continue;
            order[depth] = i;
            selected[i] = true;
            play(depth+1);
            selected[i] = false;
        }
    }

    static void baseball(){
        int score = 0;
        cursor = -1;
        int ining = 0;

        while (ining < maxIning) {
            boolean[] field = new boolean[4];
            field[0] = true;
            int outCount = 0;
            while (outCount < 3) {

                int playerNumber = getPlayer();
                int r = result[ining][playerNumber];

                if (r == 0) {
                    outCount++;
                } else {
                    for (int i = 3; i >= 0; i--) {
                        if(!field[i]) continue;
                        if(i != 0)
                            field[i] = false;
                        if (i + r > 3) {
                            score++;
                        } else {
                            field[i+r] = true;
                        }
                    }
                }
            }
            ining++;
        }
        if (maxScore < score) {
            maxScore = score;
//            System.out.println(Arrays.toString(order));
        }
//        maxScore = Math.max(maxIning, score);
    }




    static int getPlayer(){
        if(++cursor == 9)
            cursor = 0;
        return order[cursor];
    }



}
