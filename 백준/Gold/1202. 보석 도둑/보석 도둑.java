import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;




public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        정보석[] 보석이 = new 정보석[n];
        가방[] 가방들 = new 가방[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            보석이[i] = new 정보석(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < k; i++) {
            가방들[i] = new 가방(Integer.parseInt(br.readLine()));
        }

        Arrays.sort(보석이);
        Arrays.sort(가방들);

        PriorityQueue<정보석> pq = new PriorityQueue<정보석>(new Comparator<정보석>(){
            @Override
            public int compare(정보석 정보석, 정보석 t1) {
                return Integer.compare(정보석.value, t1.value) * -1;
            }
        });

        int index = 0;
        long total = 0;
        for (가방 가방 : 가방들) {
            while (index < n && 보석이[index].weight <= 가방.limit) {
                pq.add(보석이[index++]);
            }
            if(!pq.isEmpty())
                total +=pq.poll().value;
        }

        System.out.println(total);







    }

    static class 정보석 implements Comparable<정보석>{
        private int weight;
        private int value;

        public 정보석(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(정보석 정보석) {
            return Integer.compare(this.weight, 정보석.weight);
        }

        @Override
        public String toString() {
            return "정보석{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }

    static class 가방 implements Comparable<가방>{
        private int limit;

        public 가방(int limit) {
            this.limit = limit;
        }

        @Override
        public int compareTo(가방 가방) {
            return Integer.compare(this.limit, 가방.limit);
        }
    }




}