import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int n, l;
    static Water[] waters;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        waters = new Water[n];
        int min = 10_0000_0001;
        int max = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            waters[i] = new Water(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            min = Math.min(waters[i].start,min);
            max = Math.max(waters[i].end,max);
        }
        Arrays.sort(waters);


        int i = min;
        int j = 0;
        while (i < max) {
            Water water = waters[j];
//            System.out.println("i : " + i + " j  : " + j + " water : " + water);
            int diff = water.end - i;
            int k = diff/l + (diff%l != 0 ? 1 : 0);
//            System.out.println("diff : " + diff + " k : " + k);
            result += k;
            i += k * l;
            j++;
            if(i >= max || j >= waters.length)
                break;
            while (waters[j].end <= i)
                j++;
            if(waters[j].start > i)
                i = waters[j].start;
        }
        System.out.println(result);
    }
    static class Water implements Comparable<Water> {

        int start;
        int end;

        public Water(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Water o) {
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return "Water{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


}