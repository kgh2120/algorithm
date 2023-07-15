package beak.Sep2023.p15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int result = Integer.MAX_VALUE;
    static boolean[] visited ;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickenRes = new ArrayList<>();
    static ArrayList<int[]> selected = new ArrayList<>();
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());


        houses = new ArrayList<>();
        chickenRes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int token = Integer.parseInt(st.nextToken());
                if(token == 1)
                    houses.add(new int[]{i,j});
                if(token == 2)
                    chickenRes.add(new int[]{i,j});
            }


        }

        visited = new boolean[chickenRes.size()];
        findDistance(0,0);
        System.out.println(result);
    }

    private static void findDistance(int depth,   int idx){
        if(m == depth){
            int total = 0;
            // 여기에서 dist를 구하고 조합으로는 치킨집만 선택해서 가져오기.
            for (int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for (int[] res : selected) {
                    min = Math.min(min,Math.abs(house[0] - res[0]) + Math.abs(house[1] - res[1]));
                }
                total += min;
            }
            result = Math.min(result,total);
            return;
        }



        for (int i = idx; i < chickenRes.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[] sel = chickenRes.get(i);
                selected.add(sel);
                findDistance(depth+1,  i+1);
                selected.remove(selected.size()-1);
                visited[i] = false;
            }
        }

    }



}