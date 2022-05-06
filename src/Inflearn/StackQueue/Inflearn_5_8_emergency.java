package Inflearn.StackQueue;

import java.util.*;

public class Inflearn_5_8_emergency {

        public static void answer(String[] args) {
            Scanner sc = new Scanner(System.in);

            int nOfPatient = sc.nextInt();
            int target = sc.nextInt();

            Deque<Node> queue = new ArrayDeque<>();
            Stack<Node> temp = new Stack<>();

            for (int i = 0; i < nOfPatient; i++) {
                queue.add(new Node(i, sc.nextInt()));
            }

            int loop = 1;

            while (!queue.isEmpty()) {
                Node e = queue.poll();
                while (!queue.isEmpty()) {
                    Node tempNode = queue.poll();
                    temp.push(tempNode);
                    if (e.getS() < tempNode.getS()) {
                        while (!temp.isEmpty()) {
                            queue.addFirst(temp.pop());
                        }
                        queue.add(e);
                        break;
                    }
                }
                while (!temp.isEmpty()) {
                    queue.addFirst(temp.pop());
                }

                if (!queue.peekLast().equals(e)) {
                    if (e.getNum() == target) {
                        System.out.println(loop);
                        return;
                    }
                    loop++;
                }

            }




        }

         static class Node{
            private int num;
            private int s;

            public Node(int num, int s) {
                this.num = num;
                this.s = s;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getS() {
                return s;
            }

            public void setS(int s) {
                this.s = s;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "num=" + num +
                        ", s=" + s +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return getNum() == node.getNum() && getS() == node.getS();
            }

            @Override
            public int hashCode() {
                return Objects.hash(getNum(), getS());
            }
        }


    }

