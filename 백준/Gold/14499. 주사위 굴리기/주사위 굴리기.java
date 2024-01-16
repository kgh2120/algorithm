import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static final int EAST = 1;
    static final int WEST = 2;
    static final int NORTH = 3;
    static final int SOUTH = 4;

    static int[][] deltas = {
            {},
            {0,1},
            {0,-1},
            {-1,0},
            {1,0}
    };

    static int r;
    static int c;


    public static void main(String[] args) throws Exception {



        st = new StringTokenizer(br.readLine());

         r = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());
        int currentR = Integer.parseInt(st.nextToken());
        int currentC = Integer.parseInt(st.nextToken());
        int nOfCommand = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice();
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nOfCommand; i++) {
            int command = Integer.parseInt(st.nextToken());

            // 지금 위치 체크

            int[] delta = deltas[command];
            int nr = currentR + delta[0];
            int nc = currentC + delta[1];

            if (isIn(nr, nc)) {
                sb.append(dice.roll(command, map, nr, nc)).append("\n");
                currentR = nr;
                currentC = nc;
            }
        }
        System.out.println(sb);



    }
    static boolean isIn(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }

    static class Dice{

        int [] number;
        int [] north = new int[]{0,4,5,1};
        int [] south = new int[]{1,0,4,5};


        public Dice() {
            this.number = new int[6];

        }

        public int roll(int direction, int[][] map, int row, int col) {

            int value = map[row][col];

            // value 가 0이라면 dice에 값이 찍힌다.
            // 0이 아니라면, 그 자리가 0이 되고, dice에 바닥(5)에 그 값이 적힌다.


            switch (direction) {
                case EAST :
                    east();
                    break;
                case WEST:
                    west();
                    break;
                case NORTH:
                    north();
                    break;
                case SOUTH:
                    south();
                    break;
            }

            if (value == 0) {
                map[row][col] = number[5];
            }else{
                number[5] = value;
                map[row][col] = 0;
            }
            return number[0];
        }

        public void west(){

            int three =number[3];
            int five =number[5];
            int two = number[2];
            int zero = number[0];
            number[3] = zero;
            number[5] = three;
            number[2] = five;
            number[0] = two;

        }
        public void east(){
            int three =number[3];
            int five =number[5];
            int two = number[2];
            int zero = number[0];
            number[3] = five;
            number[5] = two;
            number[2] = zero;
            number[0] = three;
        }
        public void south(){

            int zero = number[0];
            int one = number[1];
            int four = number[4];
            int five = number[5];

            number[1] = five;
            number[0] = one;
            number[4] = zero;
            number[5] = four;
        }
        public void north(){
            int zero = number[0];
            int one = number[1];
            int four = number[4];
            int five = number[5];


            number[1] = zero;
            number[0] = four;
            number[4] = five;
            number[5] = one;
        }




    }


}