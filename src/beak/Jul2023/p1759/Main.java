package beak.Jul2023.p1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] words;
    static int nOfJ;
    static int nOfM;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        words = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(words);
        comb(0, 0, "");
        System.out.println(sb);
    }

    private static void comb(int startIdx, int depth, String word) {
        if (depth == n) {

            if (nOfM < 1 || nOfJ < 2) {
                return;
            }
            sb.append(word).append("\n");

            return;
        }

        for (int i = startIdx; i < m; i++) {
            char c = words[i];
            boolean mo = "aeiou".indexOf(c) >= 0;
            if (mo) {
                nOfM++;
            } else {
                nOfJ++;
            }
            comb(i + 1, depth + 1, word + c);
            if (mo) {
                nOfM--;
            } else {
                nOfJ--;
            }
        }


    }

}