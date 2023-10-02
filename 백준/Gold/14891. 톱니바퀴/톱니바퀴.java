import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**

    @author 규현
    @since 2023-10-02
    @url https://www.acmicpc.net/problem/14891
    @level G5
    @try
    @performance
    @category #
    @note

    톱니바퀴를 구현하는 문제
    톱니바퀴의 각 톱니는 N,S 상태로 놓인다.
    톱니바퀴가 시계방향 혹은 시계 반대방향로 회전시킨다.
    회전시킬 때 맞물려있는 다른 톱니바퀴의 톱니가 서로 다른 극을 가지고 있다면, 회전 톱니의 반대 방향으로 회전한다.

    회전 명령이 끝난 후, 12시 방향에 있는 톱니의 극에 따라서 점수를 부여한다.

    각 톱니바퀴는 총 4개가 있으며, 자신의 좌,우의 상태를 알아야한다.

    각 톱니는 총 8개가 있으며, 회전을 해야 하기 때문에, 자신의 좌,우 상태를 알아야한다.

*/

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Chain head;

    public static void main(String[] args) throws Exception {
        setChains();
        action();
        System.out.println(getScore());
    }

    private static void action() throws IOException {
        int nOfCommand = Integer.parseInt(br.readLine());
        for (int i = 0; i < nOfCommand; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            getChain(index).rotate(Integer.parseInt(st.nextToken()) != 1);
        }
    }

    private static void setChains() throws IOException {
        head = null;
        Chain prev = null;
        for (int i = 0; i < 4; i++) {

            Chain chain = new Chain(br.readLine());
            if(i == 0)
                head = chain;
            if(prev != null)
                prev.setNextChain(chain);
            prev = chain;
        }
    }

    private static Chain getChain(int index) {
        Chain chain = head;
        for (int i = 1; i < index ; i++) {
            chain = chain.next;
        }
        return chain;
    }

    private static int getScore(){
        int total = 0;
        int score =1;
        while (head != null) {
            if(head.head.value == 1)
                total += score;
            score *= 2;
            head = head.next;
        }
        return total;
    }

    static class Node{
        int value;
        Node next;
        Node prev;


        public Node(int value, Node prev) {
            this.value = value;
            if (prev != null) {
                this.prev = prev;
                prev.next = this;
            }
        }
    }

    static class Chain{

        Node head;
        Chain next;
        Chain prev;

        public Chain(String arr){
            setNodes(arr.toCharArray());
        }
        public void setNextChain(Chain next){
            this.next = next;
            next.prev = this;
        }

        private void setNodes(char[] arr){
            Node temp = new Node(arr[0]-'0',null);
            head = temp;

            for (int i = 1; i < arr.length; i++) {
                head = new Node(arr[i]-'0',head);
            }
            temp.prev = head;
            head.next = temp;
            head = temp;
        }
        private int getRightNodeValue(){
            return head.next.next.value;
        }
        private int getLeftNodeValue(){
            return head.prev.prev.value;
        }
        // rotate Left is head = head.next;
        // rotate right is head = head.prev;
        public void rotate(boolean d){
//             if my 2 == next.6 next.rotate !d

            propagateRight(!d);
            propagateLeft(!d);
            // if my 6 == prev.2 prev.rotate !d
            switchHead(d);
        }

        private void switchHead(boolean d) {
            if (d) {
                head = head.next;
            }else
                head = head.prev;
        }

        private void propagateLeft(boolean propagation) {
            if (prev != null && getLeftNodeValue() != prev.getRightNodeValue()) {
                prev.propagateLeft(!propagation);
                prev.switchHead(propagation);
            }
        }

        private void propagateRight(boolean propagation) {
            if (next != null && getRightNodeValue() != next.getLeftNodeValue()) {
                next.propagateRight(!propagation);
                next.switchHead(propagation);
            }
        }
    }




}