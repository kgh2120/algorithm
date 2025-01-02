import java.io.*;
import java.util.*;

/**
 *
 *  LCS 문제임. 시간제한이 0.4초이다.
 *  N은 최대 1000글자
 *  LCS에 대한 정확한 시간 복잡도가 생각나지는 않는데,
 *  돌아가는 모양새가 A * B같은 느낌이라서 1000 * 1000은 10만이니
 *  0.4초 이내에 돌아가지 않을까 싶다.
 *  특이 사항으로 출력에서 LCS가 여러 개이면 아무거나 출력하고,
 *  길이가0인 경우엔 출력하지 않는다고 한다.
 *  이제보니 LCS 문장 자체를 출력해야 하는 문제였다.
 *
 *  일반적인 LCS라고 하면, 경우에 대해서 값을 리턴해주는 형태를 띈다.
 *  그런데 최종적으로 값뿐만 아닌 형태도 가져야 한다면
 *
 */
public class Main{

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static char[] firstWord;
    static char[] secondWord;

    static Node[][] dp;

    public static void main(String[] args) throws Exception{
        firstWord = input.readLine().toCharArray();
        secondWord = input.readLine().toCharArray();

        dp = new Node[firstWord.length][secondWord.length];

        Node result = lcs(0, 0);

        StringBuilder answer = new StringBuilder();

        answer.append(result.length).append("\n");

        for(Word w = result.word; w != null; w = w.next)
            answer.append(w.alphabet);

        System.out.print(answer);
    }

    static Node lcs(int leftIndex, int rightIndex){

        if(leftIndex >= firstWord.length || rightIndex >= secondWord.length){
            return new Node(0, null);
        }

        if(dp[leftIndex][rightIndex] != null){
            return dp[leftIndex][rightIndex];
        }

        // 같은 경우
        Node node = null;
        if(firstWord[leftIndex] == secondWord[rightIndex]){
            Node same = lcs(leftIndex + 1, rightIndex + 1);
            node = new Node(same.length+1, new Word(secondWord[rightIndex], same.word));
        } else {

            Node left = lcs(leftIndex + 1, rightIndex);
            Node right = lcs(leftIndex , rightIndex+1);

            Node winner = null;

            if (left.length >= right.length) {
                winner = left;
            } else {
                winner = right;
            }
            node = winner;
        }

        return dp[leftIndex][rightIndex] = node;
    }

    static class Node{
        int length;
        Word word;
        public Node(int length, Word word) {
            this.length = length;
            this.word = word;
        }
    }

    static class Word{
        char alphabet;
        Word next;

        public Word(char alphabet, Word next) {
            this.alphabet = alphabet;
            this.next = next;
        }
    }
}