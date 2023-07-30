package beak.Jul2023.p5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] deque;
    static int l,r;
    static boolean direction;

    static boolean isSuccess = true;
    static final char REVERSE = 'R';
    static final char DELETE = 'D';
    static final String FAIL_MESSAGE = "error";

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            operation(setVariables());
            logAnswer();
        }
        System.out.println(sb);

    }


    private static String setVariables() throws IOException {

        isSuccess = true;
        direction = true;
        String command = br.readLine();
        int length = Integer.parseInt(br.readLine());
        deque = new int[length];
        l = 0; r = length != 0 ? length-1 : -1;
        String array = br.readLine();
        array = array.substring(1,array.length()-1);
        st = new StringTokenizer(array, ",");

        for(int i = 0; i<length; i++)
            deque[i] = Integer.parseInt(st.nextToken());

        return command;
    }


    private static void operation(String command) {
        for (char c : command.toCharArray()) {
            if(c == REVERSE)
                reverse();
            else
                delete();
        }
    }


    private static void logAnswer() {
        if(!isSuccess) {
            sb.append(FAIL_MESSAGE)
                    .append("\n");
            return;
        }
        sb.append("[");

        if(direction)
            for(int i = l; i <=r ;i++)
                sb.append(deque[i]).append(",");
        else
            for(int i = r; i>=l; i--)
                sb.append(deque[i])
                        .append(",");
        if(l <= r) // 배열이 비지 않았을 때
            sb.deleteCharAt(sb.length()-1);
        sb.append("]").append("\n");
    }


    private static void reverse() {
        direction = !direction;
    }

    private static void delete() {
        if(l > r) {
            isSuccess = false;
            return;
        }

        if (direction) {
            l++;
            return;
        }
        r--;
    }
}
