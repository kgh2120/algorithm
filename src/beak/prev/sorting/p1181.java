package beak.prev.sorting;

import java.util.*;
/*
    예상 난이도 : 실버 5
    실제 난이도 : 실버 5
    특징 : 기존 문제와 마찬가지로 collection.sort를 활용해서 해결함.
          다만 같은 단어가 등장해서, 이를 따로 처리해주는데 있어서 처음 값을 Set으로 받고 이를 다시
           List로 바꿔주었음, 근데 매번 추가할 때 마다 contains를 체크해서 넣고빼고가 더 좋은지는
           잘 모르겠다.
 */
public class p1181 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nOfWords = sc.nextInt();

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < nOfWords; i++) {
            wordSet.add(sc.next());
        }


        List<String> words = new ArrayList<>(wordSet);
        words.sort(new WordComparator());
        for (String word : words) {
            System.out.println(word);
        }


    }



    static class WordComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() == o2.length()) {
                return compare(o1, o2, 0);
            }
            return 1;
        }

        public static int compare(String o1, String o2, int index) {
            if ((int) o1.charAt(index) < (int) o2.charAt(index)) {
                return -1;
            } else if ((int) o1.charAt(index) == (int) o2.charAt(index)) {
                return compare(o1, o2, index + 1);
            } else return 1;
        }
    }
}
