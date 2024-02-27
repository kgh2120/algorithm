import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {


        int count = 0;

        Map<Character, char[][]> dictionary = new HashMap<>();

        dictionary.put('c', new char[][]{{'='}, {'-'}});
        dictionary.put('d', new char[][]{{'z','='}, {'-'}});
        dictionary.put('l', new char[][]{{'j'}});
        dictionary.put('n', new char[][]{{'j'}});
        dictionary.put('s', new char[][]{{'='}});
        dictionary.put('z', new char[][]{{'='}});

        char[] words = br.readLine().toCharArray();

        for (int i = 0; i < words.length; i++) {

            char c = words[i];
            char[][] chars = dictionary.get(c);
            if (chars == null) {
                count++;
                continue;
            }

            boolean isHit = false;
            loop:for (char[] aChar : chars) {
                int j = i+1;

                for (char c1 : aChar) {
                    if (j >= words.length || words[j] != c1 ) {
                        continue loop;
                    }
                    j++;
                }
                count++;
                i = j-1;
                isHit = true;
                break;
            }
            if (!isHit) {
                count++;
            }
        }

        System.out.println(count);
    }


}