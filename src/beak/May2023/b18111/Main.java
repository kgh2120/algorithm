package beak.May2023.b18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] fields = new int[r*c];

        int idx = 0;
        int max = -1;
        int min = 257;
        Map<Integer, Integer> blockCount = new HashMap<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int height = Integer.parseInt(st.nextToken());
                fields[idx++] = height;
                min = Math.min(min,height);
                max = Math.max(max,height);
                blockCount.put(height,blockCount.getOrDefault(height,0)+1);
            }

        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.time == o2.time)
                    return o2.height - o1.height;
                return o1.time - o2.time;
            }
        });
        // 세팅 해씅니까 이제 찾아봐야 함.
        boolean canMake = false;
        for(int i = max; i >= min; i--){
            // 얘가 추가를 할 수 있는 케이스인지 체크
            if(!canMake){
                canMake = canMake(r * c * i, blockCount, b);
            }
            // canAdd가 그 높이는 만들 지 못함
            if(!canMake)
                continue;
            // 이 높이를 만드려면 어떻게 해야 하나
            // 더 높은 애들은 (높이 - i) * 2 * 개수
            // 낮은 애들은 (i - 높이) * 개수
            pq.add(new Node(i, countTime(i,blockCount)));
        }



        Node node = pq.poll();
        System.out.println(node.time + " " + node.height);

    }

    private static int countTime(int height, Map<Integer, Integer> blockCount ){
        int time = 0;
        for (Entry<Integer, Integer> entry : blockCount.entrySet()) {
            Integer key = entry.getKey();

            if(key > height){
                time += (key - height) * entry.getValue() * 2;
            }else if(key < height){
                time += (height - key) * entry.getValue();
            }
        }
        return time;
    }

    // 총 블럭수 vs 필요 블럭수에서 총 블럭수가 많거나 같아야 함.
    private static boolean canMake(int need, Map<Integer, Integer> blockCount, int b){

        int total = b;
        for (Entry<Integer, Integer> entry : blockCount.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }


        return need <= total;
    }

    static class Node{
        int height;
        int time;

        public Node(int height, int time) {
            this.height = height;
            this.time = time;
        }
    }

}