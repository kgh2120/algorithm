import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int water = Integer.parseInt(st.nextToken());
            if (water < 0) {
                minus.add(water);
            } else {
                plus.add(water);
            }
        }

        int min = Integer.MAX_VALUE;

        int left = minus.size() - 1;
        int right = 0;

        int ll = 0;
        int rr = 0;

        if (minus.size() >= 2) {
            Integer l = minus.get(left);
            Integer r = minus.get(left - 1);
            int val = Math.abs(l + r);


            if (min > val) {
                ll = l;
                rr = r;
                min = val;
            }
        }

        if (plus.size() >= 2) {
            Integer l = plus.get(right);
            Integer r = plus.get(right+1);
            if (min > Math.abs(l + r)) {
                ll = l;
                rr = r;
                min = Math.abs(l + r);
            }
        }


        // 투포인터 하기


        while (left >= 0 && right < plus.size()) {
            Integer l = minus.get(left);
            Integer r = plus.get(right);
            int v = l + r;

            if (min > Math.abs(v)) {
                ll = l;
                rr = r;
                min = Math.abs(v);
            }
            if (v < 0) {
                right++;
            } else {
                left--;
            }
        }

        while (!plus.isEmpty() && left >= 0) {
            Integer l = minus.get(left);
            Integer r = plus.get(plus.size()-1);
            int v = l + r;

            if (min > Math.abs(v)) {
                ll = l;
                rr = r;
                min = Math.abs(v);
            }
            left--;
        }
        while (!minus.isEmpty() && right < plus.size()) {
            Integer l = minus.get(0);
            Integer r = plus.get(right);
            int v = l + r;

            if (min > Math.abs(v)) {
                ll = l;
                rr = r;
                min = Math.abs(v);
            }
            right++;
        }



        System.out.println(Math.min(ll, rr) + " " + Math.max(ll, rr));


    }


}