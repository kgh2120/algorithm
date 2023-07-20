package beak.Jul2023.p1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = end-start;
            sb.append(find(distance)).append("\n");
        }
        System.out.println(sb);

    }

    private static int find(int distance) {
        int max = (int) Math.sqrt(distance);
        if(max == Math.sqrt(distance))
            return 2*max -1;
        else if(distance <= max*max + max)
            return 2*max;
        else
            return 2*max +1;
    }




}