package beak.May2023.b10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
         sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" : q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    Integer poll = q.poll();
                    append(poll == null ? -1 : poll);
                    break;
                case "size" : append(q.size());
                    break;
                case "empty" : append(q.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    Integer k = q.peekFirst();
                    append(k == null ? -1 : k);
                    break;
                case "back" :
                    Integer last = q.peekLast();
                    append(last == null ? -1 : last);
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void append(int k){
        sb.append(k)
                .append("\n");
    }




}
