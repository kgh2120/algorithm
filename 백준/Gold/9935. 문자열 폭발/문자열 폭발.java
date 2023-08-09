import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {


    // queue에 다 넣는다.
    // stack이 queue의 poll을 먹는다.
    // 먹은 애가 target[cnt]와 같다면 cnt++
    // cnt == length이면
    // stack은 length만큼 pop하고
    // length -1 만큼 queue에 add한다.
    // 반복문은 queue가 빌때까지 진행하고
    // 반복문이 끝났을 때 Stack의 상태에 따라서 답을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader("mirkovC4nizCC44\n"
//                + "C4"));
        String word = br.readLine();
        char[] target = br.readLine().toCharArray();
        int length = target.length;

        Deque<Character> left = new ArrayDeque<>(); // LIFO 먹은애를 그대로 내뱉으면 됨.
        Deque<Character> right = new ArrayDeque<>(); // LIFO 먹은애를 그대로 내뱉으면 됨.
        for (int i = 0; i < word.length(); i++) {
            right.addLast(word.charAt(i));
        }

        int cnt = 0;
        while (!right.isEmpty()) {


            Character poll = right.pollFirst();

            if (poll != target[cnt]) {
                cnt = 0;
            }
            if (poll == target[cnt]) {
                cnt++;
            }
            left.addLast(poll);

            if (cnt == length) {

                for(int i = 0; i<length;i++)
                    left.pollLast();

                for(int i = 0; i<length-1;i++)
                    if(!left.isEmpty())
                        right.addFirst(left.pollLast());


                cnt = 0;
            }

        }



        if (left.isEmpty()) {
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for (Character character : left) {
                sb.append(character);
            }
            System.out.println(sb);
        }


    }


}