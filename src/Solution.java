import java.util.*;
class Solution {

    int[][]matrix;
    List<Move> list;
    Queue<Move>q;
    public int solution(int x1, int y1, int x2, int y2) {
        if(x1==x2 && y1==y2)
            return 0;
        int answer = 0;

        list = new ArrayList<>();

        if(y1==y2){
            matrix = new int[2][Math.abs(x1-x2)+1];

        }else if(x1==x2){
            matrix = new int[Math.abs(y1-y2)+1][2];

        }else{
            matrix = new int[Math.abs(y1-y2)+1][Math.abs(x1-x2)+1];

        }

        bfs(Math.abs(y1-y2),Math.abs(x1-x2));


        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Move m : list){
            int dist = m.r+ m.c;
            if(dist == m.turn){
                min = Math.min(m.turn,min);
            }
            if(dist > m.turn){
                if((dist -m.turn) % 2 == 0)
                    pq.add(dist);
            }
        }
        if(min == Integer.MAX_VALUE )
            min = pq.poll();

        return min;
    }

    private void bfs(int startX, int startY){
        q = new LinkedList<>();
        q.add(new Move(startX, startY,0));

        while(!q.isEmpty()){
            Move m = q.poll();
            move(m,-1,-1);
            move(m,-1,1);
            move(m,1,-1);
            move(m,1,1);
        }


    }

    private void move(Move m, int rD, int cD){
        if(m.r + rD <0 || m.r+rD >= matrix.length || m.c+cD < 0 || m.c+cD >= matrix[0].length)
            return;
        if(matrix[m.r+rD][m.c+cD] != 0)
            return;
        matrix[m.r+rD][m.c+cD] = m.turn+1;
        Move n = new Move(m.r+rD, m.c+cD, m.turn+1);
        q.add(n);
        list.add(n);
    }

    class Move{
        int r;
        int c;
        int turn;

        Move(int r, int c, int turn){
            this.r = r;
            this.c = c;
            this.turn = turn;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2,4,2,1));;
    }
}