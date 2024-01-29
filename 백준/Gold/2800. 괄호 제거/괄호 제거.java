import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2800 괄호제거
 *
 * 그냥 괄호쌍에 대한 인덱스를 가지고 있는다.
 * 괄호쌍은 최대 10개까지 나온다.
 * 괄호쌍이 제거된 케이스에 대해서 값을 가지고 있으란다.
 * 제거된 괄호쌍을 부분집합으로 관리하고 경우를 따지면서 String값을 저장하자.
 * 값을 다 저장하면, 정렬을 때려주고, 순서대로 출력한다.
 *
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static final char BRACKET_OPEN = '(';
    static final char BRACKET_CLOSE = ')';
    static List<Bracket> brackets;
    static char[] chars;
    static Set<String> answers;
    public static void main(String[] args) throws Exception {
        String word = br.readLine();
        answers = new HashSet<>();
        chars = word.toCharArray();

        Deque<Bracket> deque = new ArrayDeque<>();
        brackets = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == BRACKET_OPEN) {
                deque.addLast(new Bracket(i));
            } else if (c == BRACKET_CLOSE) {
                Bracket bracket = deque.pollLast();
                bracket.endIndex = i;
                brackets.add(bracket);
            }
        }


        boolean[] checked = new boolean[brackets.size()];
        powerSet(0, checked);
        List<String> list = new ArrayList<>(answers);


        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static void powerSet(int index, boolean[] check){
        if (index == check.length) {
            // 선택된애들 꺼내고, 그 인덱스는 고르지마

            List<Integer> removeIndex = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (check[i]) {
                    Bracket bracket = brackets.get(i);
                    removeIndex.add(bracket.startIndex);
                    removeIndex.add(bracket.endIndex);
                }
            }

            Collections.sort(removeIndex);

            StringBuilder output = new StringBuilder();
            for (int i = 0, j = 0; i < chars.length; i++) {
                if (j < removeIndex.size() && i == removeIndex.get(j)) {
                    j++;
                    continue;
                }
                output.append(chars[i]);
            }
            answers.add(output.toString());
            return;
        }
        powerSet(index+1, check);
        check[index] = true;
        powerSet(index+1, check);
        check[index] = false;
    }


    static class Bracket{
        int startIndex;
        int endIndex;

        public Bracket(int startIndex) {
            this.startIndex = startIndex;
        }

        @Override
        public String toString() {
            return "Bracket{" +
                    "startIndex=" + startIndex +
                    ", endIndex=" + endIndex +
                    '}';
        }
    }
}