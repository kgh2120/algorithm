package programmers.prev.exhaustivesearch;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {

    boolean flag;
    Set<String> wordsSet = new HashSet<>();
    int answer;

    public int solution(String word) {
        String[] words = {"A", "E", "I", "O", "U"};
        bruteForce(words, word, 0, 5, "");
        return answer;
    }

    private void bruteForce(String[] words, String target, int depth, int endDepth, String comb) {
        if (flag) {
            return;
        }

        if (comb.equals(target)) {
            answer = wordsSet.size();
            flag = true;
            return;
        }
        if(depth == endDepth)
            return;

        for (int i = 0; i < words.length; i++) {
            if (flag) {
                return;
            }
            wordsSet.add(comb + words[i]);
            bruteForce(words, target, depth + 1, endDepth, comb + words[i]);
        }
    }


    public static void main(String[] args) {

        String a = "EIO";

        System.out.println(((new Dictionary().solution(a))));
    }
}