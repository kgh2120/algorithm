import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                System.out.println(0);
                System.out.println(1);
            }

            Queue<Node> q = new ArrayDeque<>();
            List<Integer> historyArray = new ArrayList<>();
            List<Integer> parents =new ArrayList<>();
            boolean[] visited = new boolean[100_0001];
            parents.add(-1);
            historyArray.add(n);
            visited[n] = true;

            int parentIndex = 0;
            int index = 1;
            if (n % 3 == 0 ) {
                int nn = n / 3;
                if (!visited[nn]) {
                    historyArray.add(nn);
                    parents.add(parentIndex);
                    q.add(new Node(nn, index++));
                    visited[nn] = true;
                }
            }
            if (n % 2 == 0) {
                int nn = n / 2;
                if (!visited[nn]) {
                    historyArray.add(nn);
                    parents.add(parentIndex);
                    q.add(new Node(nn, index++));
                    visited[nn] = true;
                }
            }
            int nn = n-1;
            if (!visited[nn]) {
                historyArray.add(nn);
                parents.add(parentIndex);
                q.add(new Node(nn, index++));
                visited[nn] = true;
            }


            StringBuilder answer = new StringBuilder();
            int turn = 0;
            while (!q.isEmpty()) {
                turn++;
                int size = q.size();
                while (size-- > 0) {
                    Node node = q.poll();
                    int cur = node.currentValue;
                    int nodeIndex = node.index;
                    if (node.currentValue == 1) {
                        answer.append(turn).append("\n");
                        logHistory(nodeIndex, parents, historyArray, answer);
                        System.out.println(answer);


                        return;
                    }

                    if (cur % 3 == 0) {
                        int cc = cur / 3;
                        if (!visited[cc]) {
                            historyArray.add(cc);
                            parents.add(nodeIndex);
                            q.add(new Node(cc, index++));
                            visited[cc] = true;
                        }
                    }
                    if (cur % 2 == 0) {
                        int cc = cur / 2;
                        if (!visited[cc]) {
                            historyArray.add(cc);
                            parents.add(nodeIndex);
                            q.add(new Node(cc, index++));
                            visited[cc] = true;
                        }
                    }
                    int ccc = cur - 1;
                    if (ccc > 0 && !visited[ccc]) {
                        historyArray.add(ccc);
                        parents.add(nodeIndex);
                        q.add(new Node(ccc, index++));
                        visited[ccc] = true;
                    }
                }
            }



        }

        static void logHistory(int index, List<Integer> parents,List<Integer> history, StringBuilder answer){
            if (index == -1) {
                return;
            }
            int parentIndex = parents.get(index);
            logHistory(parentIndex,parents,history,answer);
            answer.append(history.get(index)).append(" ");

        }


        static class Node{
            int currentValue;
            int index;

            public Node(int currentValue, int index) {
                this.currentValue = currentValue;
                this.index = index;
            }
        }

    }