package beak.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class P11437 {

    int[]depth;
    int[]parent;
    Map<Integer, Set<Integer>> map;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfV = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 1; i <= nOfV ; i++) {
            map.put(i,new HashSet<>());
        }

        StringTokenizer st ;
        for (int i = 0; i < nOfV-1; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            map.get(l).add(r);
            map.get(r).add(l);
        }

        depth = new int[nOfV+1];
        parent = new int[nOfV+1];

        // set Tree
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1));
        while(!q.isEmpty()){
            Node n = q.poll();
            parent[n.value] = n.parent;
            depth[n.value] = n.depth;

            for(Integer s : map.get(n.value)){
                Set<Integer> set = map.get(s);
                set.remove(n.value);
                q.add(new Node(n.value, n.depth+1,s));

            }

        }


        int nOfLCA = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nOfLCA; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(LCA(l,r)).append("\n");
        }
        System.out.println(sb);

    }

    public int LCA(int l, int r){

        int tempL = l;
        int tempR = r;

        while(true){
            if(tempL == tempR)
                return tempL;

            if(parent[tempL] == parent[tempR])
                return parent[tempL];

            if(depth[tempL] == depth[tempR]){
                tempL = parent[tempL];
                tempR = parent[tempR];
            }else{
                if(depth[tempL] > depth[tempR]){
                    tempL = parent[tempL];
                }else{
                    tempR = parent[tempR];
                }
            }
        }
    }


    class Node{

        int parent;
        int depth;
        int value;

        public Node(int parent, int depth, int value) {
            this.parent = parent;
            this.depth = depth;
            this.value = value;
        }
    }





    public static void main(String[] args) throws Exception {
        new P11437().solution();
    }
}