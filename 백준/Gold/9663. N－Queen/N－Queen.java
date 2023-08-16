import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        result = 0;

        backT(0,  0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

    static void backT(int row,  int count) {
        if(count == N) {
            result++;
//            for (int[] ints : arr) {
//                System.out.println(Arrays.toString(ints));
//            }
//            System.out.println();
            return;
        }


            for(int j = 0; j < N; j++) {
                if(checkQ(row, j)) {
                    arr[row][j] = 1;
                    backT(row + 1,  count+1);
                    arr[row][j] = 0;
                }
            }

    }

    static boolean checkQ(int row, int col) {
        boolean flag = true;
        // y축
        for(int i = 0; i < row; i++) {
            if(arr[i][col] == 1) {
                flag = false;
                break;
            }
        }
        // 대각선
        for (int i = 1; i <= row; i++) {
            if ((isIn(row-i,col-i) && arr[row - i][col - i] == 1) || (isIn(row-i, col+i) && arr[row - i][col + i] == 1)  ){
                flag = false;
                break;
            }
        }

        return flag;
    }

    static boolean isIn(int row, int col){
        return row >= 0 && row < arr.length && col >= 0 && col < arr.length;
    }
}