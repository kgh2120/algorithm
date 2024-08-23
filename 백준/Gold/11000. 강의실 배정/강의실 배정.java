import java.util.*;
import java.io.*;

/*
    강의의 시작시간에는 강의실을 사용해야함.
    강의 시작순으로 정렬을 하고, 새로운 강의실을 넣을 때엔
    PQ에 끝나는 시간이 빠른 순으로 정렬을 박아서 
    새로운 강의 시작시간 >= 끝나는 강의 시간이면
    끝강의를 poll 박아주고 (반복문 박아야함)
    아니면 add를 해준다.
    이때 사용되는 강의실의 최대값(pq의size)을 max값으로 기록해놓으면 될 듯 하다.

*/

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        Queue<Node> pq= new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                int v = Integer.compare(o1.end, o2.end);
                if(v == 0)
                    return Integer.compare(o1.start, o2.start);
                    return v;
            }
        });
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        
        int max = -1;
        for(Node node : nodes){
            while(!pq.isEmpty() && pq.peek().end <= node.start){
                pq.poll();
            }
            pq.add(node);
            max = Math.max(max, pq.size());
        }
        
        System.out.println(max);
        
        
        
    }
    
    static class Node implements Comparable<Node>{
        int start;
        int end;
        
        public Node(int s, int e){
            start = s;
            end = e;
        }
        
        @Override
        public int compareTo(Node o){
            int v = Integer.compare(this.start, o.start);
                if(v == 0)
                    return Integer.compare(this.end, o.end);
                    return v;
        }
    }
}
