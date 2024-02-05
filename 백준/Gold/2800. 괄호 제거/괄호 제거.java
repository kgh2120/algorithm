import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static String str;
    static ArrayList<int[]> pos;
    static Set<String> tmp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        str = input.readLine();
        Deque<Integer> brackets = new ArrayDeque<>();
        pos = new ArrayList<>();
        visited = new boolean[str.length()];
        tmp = new TreeSet<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                brackets.add(i);
            } else if(str.charAt(i) == ')') {
                int start = brackets.pollLast();
                pos.add(new int[] {start, i});
            }
        }

        combination(0, 0);

        for(String s: tmp) {
            output.append(s).append("\n");
        }

        System.out.println(output);
    }

    static void combination(int cnt, int s) {
        if(cnt > 0) {
            StringBuilder tt = new StringBuilder();
//            String ans = "";
            for(int i = 0; i < str.length(); i++) {
                if(!visited[i]) {

                    tt.append(str.charAt(i));
                }
            }

            tmp.add(tt.toString());
        }

        for(int i = s; i < pos.size(); i++) {
            if(visited[pos.get(i)[0]] && visited[pos.get(i)[1]]) continue;
            visited[pos.get(i)[0]] = true;
            visited[pos.get(i)[1]] = true;
            combination(cnt+1, i);
            visited[pos.get(i)[0]] = false;
            visited[pos.get(i)[1]] = false;
        }
    }
}