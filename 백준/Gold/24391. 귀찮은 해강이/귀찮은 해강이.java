import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int[] parents;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


       parents = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            union(l,r);
        }

        st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i =1; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());

            if(find(cur) == find(next))
                continue;
            answer++;
            cur = next;
        }
        System.out.println(answer);


    }

    static void union(int l, int r){
        int ll = find(l);
        int rr = find(r);

        if(ll < rr)
            parents[rr] = ll;
        else
            parents[ll] = rr;
    }

    static int find(int i) {
        if(i == parents[i])
            return i;
        return parents[i] = find(parents[i]);
    }




}