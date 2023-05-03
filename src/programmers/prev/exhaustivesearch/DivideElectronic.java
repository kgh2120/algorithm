package programmers.prev.exhaustivesearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DivideElectronic {
    List<LinkedList<Integer>> adjacent = new ArrayList<>();

    public int solution(int n, int[][] wires) {
        // n -> vertex , wires => edges
        for(int  i = 0; i <= n; i++){
            adjacent.add(new LinkedList<>());
        }

        for(int i = 0; i<wires.length; i++){
            adjacent.get(wires[i][0]).add(wires[i][1]);
            adjacent.get(wires[i][1]).add(wires[i][0]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            adjacent.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            adjacent.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));

            // abs 찾기
            min = Math.min(min, Math.abs(bfs(new boolean[n+1])));
            // reset
            adjacent.get(wires[i][0]).add(wires[i][1]);
            adjacent.get(wires[i][1]).add(wires[i][0]);
        }



        return min;
    }

    private int bfs(boolean[] visited){
        int [] counts = new int [visited.length];
        for(int i = 1; i < visited.length; i++){
            int count = 0;
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                count ++;
                visited[i] = true;
                while(!q.isEmpty()){
                    Integer p = q.poll();
                    LinkedList<Integer> adj = adjacent.get(p);

                    // 방문하지 않은 애들 넣기
                    // 넣은 만큼 카운트 ++
                    for(Integer ad : adj){
                        if(!visited[ad]){
                            q.add(ad);
                            visited[ad] = true;
                            count++;
                        }
                    }

                }
            }
            counts[i] = count;
        }
        int total = counts[1];
        for(int i = 2; i<counts.length; i++)
            total -= counts[i];

        if(total == counts[1])
            return 0;
        return total;
    }




    public static void main(String[] args) {

        int a = 7;
       int [][] b = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};


        System.out.println(((new DivideElectronic().solution(a,b))));
    }
}