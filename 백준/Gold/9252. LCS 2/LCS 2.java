import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static StringTokenizer st;


    static Node[][] dp;
    static String left;
    static String right;
    static Node blank = new Node('0',null,-1);
    public static void main(String[] args) throws Exception {

        left = br.readLine();
        right = br.readLine();
        dp = new Node[left.length()][right.length()];
        LCS(left.length()-1, right.length()-1);
        Node last = dp[left.length() - 1][right.length() - 1];


        System.out.println(last.n+1);
        while (last.next != null) {
            sb.append(last.v);
            last = last.next;
        }
        System.out.println(sb.reverse());
    }

    private static Node LCS(int l, int r){
        if(l < 0 || r < 0) return blank;


        if(dp[l][r] != null) return dp[l][r];

        // left.l == right.r 전에꺼 + 나
        if (left.charAt(l) == right.charAt(r)) {
            Node before = LCS(l - 1, r - 1);
            Node cur = new Node(left.charAt(l), before, before.n+1);
            dp[l][r] = cur;
        }else {
            Node left = LCS(l - 1, r);
            Node right = LCS(l,r-1);

            if (left.n > right.n) {
                dp[l][r] = left;
            }else
                dp[l][r] = right;
        }
        return dp[l][r];
    }

    static class Node{
        char v;
        Node next;
        int n;

        public Node(char v, Node next, int n) {
            this.v = v;
            this.next = next;
            this.n = n;
        }
    }


}