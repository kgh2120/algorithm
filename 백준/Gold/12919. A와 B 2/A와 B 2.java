import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();


        Set<String> visited = new HashSet<>();

        Queue<String> q = new ArrayDeque<>();

        q.add(t);

        int answer = 0;

        while(!q.isEmpty()) {

            String poll = q.poll();

            if(poll.length() < s.length())
                break;



            if (poll.charAt(0) == 'B') {
                StringBuilder sb = new StringBuilder(poll);
                String next = sb.reverse().deleteCharAt(sb.length() - 1).toString();


                if(!visited.contains(next)) {
                    if (next.equals(s)) {
                        answer = 1;
                        break;
                    }
                    visited.add(next);
                    q.add(next);
                }

            }

            if (poll.charAt(poll.length() - 1) == 'A') {

                String next = poll.substring(0, poll.length() - 1);

                if(!visited.contains(next)){
                    if (next.equals(s)) {
                        answer = 1;
                        break;
                    }
                    visited.add(next);
                    q.add(next);
                }


            }
        }
        System.out.println(answer);


    }


}