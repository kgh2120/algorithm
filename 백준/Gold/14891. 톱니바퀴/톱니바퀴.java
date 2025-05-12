import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{

        Chain[] chains = new Chain[4];

        for (int i = 0; i < 4; i++) {
            LinkedList<Boolean> list = new LinkedList<>();
            for(char c : br.readLine().toCharArray()) {
                list.add(c == '1');
            }
            chains[i] = new Chain(list);

            if (i - 1 >= 0) {
                chains[i].left = chains[i - 1];
                chains[i - 1].right = chains[i];
            }
        }


        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) -1;
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                chains[index].rotateRight();
            } else {
                chains[index].rotateLeft();
            }

        }

        int score = 0;
        for (int i = 0; i <4 ; i++) {
            if (chains[i].head()) {
                score += (int) Math.pow(2,i);
            }
        }

        System.out.print(score);



    }

    static class Chain{

        LinkedList<Boolean> chains;
        Chain left;
        Chain right;

        public Chain(LinkedList<Boolean> chains) {
            this.chains = chains;
        }

        public void rotateRight(){
            // 선전파
            propagateLeft(true);
            propagateRight(true);
            turnRight(chains);
        }

        private void turnRight(LinkedList<Boolean> chains) {
            chains.addFirst(chains.pollLast());
        }

        public void rotateLeft(){
            propagateLeft(false);
            propagateRight(false);
            turnLeft(chains);
        }

        private void turnLeft(LinkedList<Boolean> chains) {
            chains.addLast(chains.pollFirst());
        }

        private void propagateRight(boolean isRight){
            if (right != null && chains.get(2) != right.chains.get(6)) {
                right.propagateRight(!isRight);
                if(isRight)
                    turnLeft(right.chains);
                else
                    turnRight(right.chains);
            }
        }
        private void propagateLeft(boolean isRight){
            if (left != null && left.chains.get(2) != chains.get(6)) {
                left.propagateLeft(!isRight);
                if(isRight)
                    turnLeft(left.chains);
                else
                    turnRight(left.chains);
            }
        }

        public boolean head(){
            return chains.get(0);
        }

    }



}
