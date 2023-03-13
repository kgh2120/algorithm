import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {






    public static void main(String[] args) throws Exception {

        comb(0,"",new int[]{1,2,3,4,5,6},0);
    }

    public static void comb(int depth, String temp, int[]arr, int cur){
        if (depth == 3) {
            System.out.println(temp);
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            comb(depth+1,temp + " " + arr[i], arr,i+1);
        }

    }

}
