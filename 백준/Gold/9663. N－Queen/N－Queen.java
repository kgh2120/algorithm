import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] cols;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cols = new int[N+1];
        ans = 0;
        setQueen(1);
        System.out.println(ans);
    }

    private static void setQueen(int row) {
        //가지치기
//        return;
        // 기저조건
        if (row > N) {
            ans++;
            return;
        }
        for (int c = 1; c <= N; c++) {
            cols[row] = c;
            if(isAvailable(row))
                setQueen(row+1);
        }
    }
    private static boolean isAvailable(int row) { // 마지막으로 놓아진 퀸의 행
        int cur = cols[row];
        for (int i = 1; i < row; i++) {
            if(cur == cols[i])
                return false;
            if(cur == cols[i] + Math.abs(row-i) || cur == cols[i] - Math.abs(row-i))
                return false;
        }
        return true;
    }
}