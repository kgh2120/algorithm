import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parents;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (!union(l, r)) {
                result  = i;
                break;
            }
        }

        System.out.println(result);




    }

    private static int find(int index) {
        if(parents[index] == index)
            return index;
        return parents[index] = find(parents[index]);
    }

    private static boolean union(int l, int r) {
        int lp = find(l);
        int rp = find(r);

        if(lp == rp) return false;
        parents[rp] = lp;
        return true;
    }




}