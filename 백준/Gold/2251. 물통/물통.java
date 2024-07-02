import java.util.*;
import java.io.*;

public class Main {


    static public void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean [][][]visited = new boolean[a+1][b+1][c+1];
        int[]maxValue = {a,b,c};

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(new int[]{0,0,c}));
        Set<Integer> answers = new HashSet<>();
        answers.add(c);
        visited[0][0][c] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            int[] value = node.value;
            for (int i = 0; i < 3; i++) {
                if(value[i] == 0) continue;
                for (int j = 0; j < 3; j++) {
                    if(i == j ||  value[j] == maxValue[j]) continue;
                    // i -> j로 이동  i는 i - maxValue - value[j]
                    int[] copy = copy(value);
                    water(i,j,copy,maxValue);
                    if(isVisited(copy, visited)) continue;
                    visited[copy[0]][copy[1]][copy[2]] = true;
                    if(copy[0] == 0){
                        answers.add(copy[2]);
                    }
                    q.add(new Node(copy));
                }
            }

        }


        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>(answers);
        Collections.sort(answer);
        for (Integer i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);


    }
    static boolean isVisited(int[]cups, boolean [][][]visited){
        return visited[cups[0]][cups[1]][cups[2]];
    }

    static int[] copy(int[] origin){
        int[] copy = new int[origin.length];
        System.arraycopy(origin,0, copy, 0, origin.length);
        return copy;
    }

    static void water(int from, int to, int[] cups, int[] maxValues) {
        int fromValue = cups[from];
        int toValue = cups[to];

        cups[from] = Math.max(0, fromValue - (maxValues[to] - toValue));
        cups[to] = Math.min(fromValue + toValue, maxValues[to]);

    }

    static class Node{
        int[] value;

        public Node(int[] value) {
            this.value = value;
        }
    }


}