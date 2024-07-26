import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static List<Fireball> fireballs;
    static Queue<Integer> deletedIndex;
    static Map<String, Holder> matrix;
    static int n;
    static int[][] directions = {
            {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}
    };
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        fireballs = new ArrayList<>();
        deletedIndex = new PriorityQueue<>(Collections.reverseOrder());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(row, col, weight, direction, speed));
            answer += weight;
        }


        for (int i = 0; i < k; i++) {

            // 파이어볼 이동하기
            moveFireballs();
            // 파이어볼 합치기
            secondStep();
            // 파이어볼 지우기
            third();
        }

        System.out.println(answer);

    }



    static void third(){
        while (!deletedIndex.isEmpty()) {
            int poll = deletedIndex.poll();
            answer -= fireballs.get(poll).m;
            fireballs.remove(poll);
        }
    }

    static void secondStep(){
        for(Holder holder : matrix.values()){
            if(holder.fireballIndex.size() < 2) continue;
            holder.divideFireball();;
        }
    }

    static void moveFireballs(){
        matrix = new HashMap<>();

        for (int i = 0; i< fireballs.size(); i++) {
            Fireball fireball = fireballs.get(i);
            int move = fireball.s % n;

            int[] direction = directions[fireball.d];

            int nr = fireball.row + direction[0] * move;
            int nc = fireball.col + direction[1] * move;

            nr = convert(nr);
            nc = convert(nc);

            fireball.row = nr;
            fireball.col = nc;

            String location = "R"+nr+"C"+nc;
            if (!matrix.containsKey(location))
                matrix.put(location, new Holder(nr,nc));
            matrix.get(location).fireballIndex.add(i);
        }

    }

    static int convert(int num){
        if (num <= 0) {
            return n + num;
        } else if(num > n) return num - n;
        else return num;
    }

    static class Holder{
        int row;
        int col;
        List<Integer> fireballIndex;

        public Holder(int row, int col) {
            this.row = row;
            this.col = col;
            fireballIndex = new ArrayList<>();
        }

        public void divideFireball(){
            deletedIndex.addAll(fireballIndex);
            int nOfOddDirection = 0;

            int totalWeight = 0;
            int totalSpeed = 0;
            for (Integer index : fireballIndex) {
                Fireball fireball = fireballs.get(index);
                totalWeight += fireball.m;
                totalSpeed += fireball.s;

                if (fireball.d % 2 == 1) {
                    nOfOddDirection++;
                }
            }

            // 4개로 나눈다.

            if(totalWeight / 5 == 0)
                return;


            int newWeight = totalWeight/5;
            int newSpeed = totalSpeed/ fireballIndex.size();

            int[] newDirections;
            if (nOfOddDirection == 0 || nOfOddDirection == fireballIndex.size()) {
                newDirections = new int[]{0, 2, 4, 6};
            } else {
                newDirections = new int[]{1,3,5,7};
            }
            for (int i : newDirections) {
                answer += newWeight;
                fireballs.add(new Fireball(row, col, newWeight, i, newSpeed));
            }

        }
    }

    static class Fireball{
        int row;
        int col;
        int m;
        int d;
        int s;

        public Fireball(int row, int col, int m, int d, int s) {
            this.row = row;
            this.col = col;
            this.m = m;
            this.d = d;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Fireball{" +
                    "row=" + row +
                    ", col=" + col +
                    ", m=" + m +
                    ", d=" + d +
                    ", s=" + s +
                    '}';
        }
    }


}