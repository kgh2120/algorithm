import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] countArray = new int[10];
    static int nOfKinds = 0;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] tanghuru = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;


        int maxLength = -1;
        while (left <= right && right < n) {
            int next = tanghuru[right];
            while (!canPush(next)) {
                pop(tanghuru[left++]);
            }
            push(tanghuru[right++]);
            maxLength = Math.max(maxLength, right - left);
        }

        System.out.println(maxLength);
    }


    public static void push(int n) {
        if (countArray[n]++ == 0)
            nOfKinds++;
    }

    public static boolean canPush(int n) {
        if (countArray[n] != 0) return true;
        else return nOfKinds < 2;
    }

    public static void pop(int n) {
        if (--countArray[n] == 0) {
            nOfKinds--;
        }
    }



}