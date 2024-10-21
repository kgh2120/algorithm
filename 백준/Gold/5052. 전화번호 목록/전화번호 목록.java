import java.util.*;
import java.io.*;
public class Main {

    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<TC; t++){
            int n = Integer.parseInt(br.readLine());
            flag = false;
            Trie trie = new Trie();
            String answer = "YES";
            int i = 0;
            for (; i < n; i++) {
                String word = br.readLine();
                if(!flag)
                    trie.add(word);

                if(flag){
                    answer = "NO";
                
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Trie{
        Trie[] dictionary = new Trie[10];
        boolean isFinal;

        public void add(String word){

            int last = word.length();
            Trie t = this;
            for (int i = 0; i < last; i++) {
                int convertIndex = word.charAt(i) - '0';
                Trie trie = t.dictionary[convertIndex];

                // 종료조건
                // 나 남았는데 지금 위치가 isFinal인 경우. or나 이번ㅇ ㅔ끝나는데 이새끼 이미 와있었네?? 하는 경우

                if (t.isFinal || (i == last - 1 && trie != null)) {
                    flag = true;
                    return;
                }



                if (trie == null) {
                    trie = new Trie();
                    t.dictionary[convertIndex] = trie; // 이게 넣은거임
                }

               // 나 마지막이면
                if(i == last-1)
                    trie.isFinal = true;

                t = trie;
            }
        }

    }
}