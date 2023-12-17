import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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


    static Map<Integer, List<Integer>> dwMapper;

    static Queue<Integer> pq;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        dwMapper = new HashMap<>();
        int maxD = 0;



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (!dwMapper.containsKey(d)) {
                dwMapper.put(d, new ArrayList<>());
            }
            dwMapper.get(d).add(w);
            maxD = Math.max(maxD, d);
        }

        pq = new PriorityQueue<>(Comparator.reverseOrder());



        int sum = 0;
        while (maxD > 0) {
            if(dwMapper.containsKey(maxD))
                pq.addAll(dwMapper.get(maxD));
            if(!pq.isEmpty())
                sum += pq.poll();
            maxD--;
        }

        System.out.println(sum);


    }




}