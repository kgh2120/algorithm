package swea.May23.s1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {

    static int max;
    static Set<Node> set;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            max = -1;
            set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

//            int t = 0;
//            String temp = k;
            find(k,0,n);
            System.out.println("#"+i +" " + max);
        }
    }

    private static void find(String s, int current, int end){

        if(current == end){
            max = Math.max(max, Integer.parseInt(s));
            return;
        }

        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            for (int l = j+1; l < chars.length; l++) {
                String number = createNumber(chars, j, l);
                if(set.contains(new Node(number,current+1)))
                    continue;
                set.add(new Node(number,current+1));
                find(number, current+1, end);
            }
        }

    }

    private static void swap(int l, int r, char[]chars) {
        char temp = chars[r];
        chars[r] = chars[l];
        chars[l] = temp;


    }

    private static String createNumber(char[]chars, int l, int r){
        swap(l,r,chars);

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        swap(l,r,chars);
        return (sb.toString());
    }

    static class Node{
        String number;
        int current;

        public Node(String number, int current) {
            this.number = number;
            this.current = current;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return current == node.current && Objects.equals(number, node.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, current);
        }
    }
}