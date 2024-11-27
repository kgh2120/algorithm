import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[] visited = new boolean[128];

    static StringBuilder answer = new StringBuilder();


    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요


        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            String origin = br.readLine();
            st = new StringTokenizer(origin);

            List<String> words = new ArrayList<>();
            while(st.hasMoreElements())
                words.add(st.nextToken());
            boolean isSkipped = false;

            for(int idx = 0; idx < words.size(); idx++){
                String word = words.get(idx);
                char firstChars = Character.toLowerCase(word.charAt(0));

                if(visited[firstChars]) continue;
                visited[firstChars] = true;

                for(int i = 0; i< words.size(); i++){
                    String w = words.get(i);
                    if(idx == i){
                        answer.append('[').append(w.charAt(0)).append(']');
                        for(int j = 1; j<w.length(); j++){
                            answer.append(w.charAt(j));
                        }
                        if(i != words.size()-1)
                            answer.append(" ");
                    } else {
                        answer.append(w);
                        if(i != words.size()-1)
                            answer.append(" ");
                    }

                }
               
                answer.append("\n");
                isSkipped = true;
                break;
            }

            if(isSkipped) continue;

            // 앞 자리로 안끝난 경우. 한 글자씩 봐야함.. 아오 귀찮아.

            for(char c : origin.toCharArray()){

                char v = Character.toLowerCase(c);
                if(!visited[v] && v != 32 && !isSkipped){
                    visited[v] = true;
                    isSkipped = true;
                    answer.append('[').append(c).append(']');
                } else {
                    answer.append(c);
                }
            }
            if(n != 0)
                answer.append("\n");
        }
        System.out.print(answer);

       
    }
}
