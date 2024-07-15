import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Work> startQueue = new PriorityQueue<>((w1,w2) -> Integer.compare(w1.start,w2.start));
        Queue<Work> endQueue = new PriorityQueue<>((w1,w2) -> Integer.compare(w1.end,w2.end));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Work work = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            startQueue.add(work);

        }

        int curValue = 0;
        int idx = 1;
        while (idx <= n) {
            // st가 있으면 check
            while (!startQueue.isEmpty() && startQueue.peek().start == idx) {
                Work poll = startQueue.poll();
                curValue += poll.value;
                endQueue.add(poll);

            }
            arr[idx] += curValue;

            while(!endQueue.isEmpty() && endQueue.peek().end == idx) {
                curValue -= endQueue.poll().value;
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<=n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);



    }

    static class Work{
        int start;
        int end;
        int value;

        public Work(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }



}