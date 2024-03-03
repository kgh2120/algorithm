import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 규현
 * - @since 2024-03-04
 * - @limit memory : 512mb time : 1s
 * - @performance
 * - @category string,
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] counter = new int[26];
        int maxLength = -1;
        int kindOfWord = 0;

        char[] words = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < words.length; i++) {
            char word = words[i];
            int wordIndex = word - 'a';
            // 이미 있어
            if (counter[wordIndex] > 0) {
                deque.addLast(word);
                counter[wordIndex]++;
                continue;
            }

            if (kindOfWord == n) {
                maxLength = Math.max(maxLength, deque.size());
                while (!deque.isEmpty()) {
                    Character head = deque.pollFirst();
                    int headIndex = head - 'a';
                    if (--counter[headIndex] == 0) {
                        kindOfWord--;
                        break;
                    }
                }
            }
            kindOfWord++;
            counter[wordIndex]++;
            deque.addLast(word);
        }

        maxLength = Math.max(maxLength, deque.size());

        System.out.println(maxLength);


    }


}