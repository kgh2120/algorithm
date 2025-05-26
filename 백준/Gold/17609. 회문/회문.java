import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int PEL = 0;
    static final int SOME_PEL = 1;
    static final int NON_PEL = 2;



    public static void main(String[] args) throws Exception {

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            char[] words = br.readLine().toCharArray();
            int result = isPalindrome(words, 0, words.length - 1, PEL);
            sb.append(result).append("\n");
        }
        System.out.print(sb);

    }

    private static int isPalindrome(char[] words, int left, int right, int status){
        if(left >= right){
            return status;
        }
        if (words[left] == words[right]) {
            return isPalindrome(words,left+1, right-1, status);
        } else {
            if(status == SOME_PEL)
                return NON_PEL;
            return Math.min(isPalindrome(words,left+1, right, SOME_PEL), isPalindrome(words, left, right-1, SOME_PEL));
        }
    }




}
