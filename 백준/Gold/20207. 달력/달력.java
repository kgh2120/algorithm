import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        TaskGroup tg = null;
        int ans = 0;

        Queue<Task> q = new PriorityQueue<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            q.add(new Task(s, e));
        }

        while (!q.isEmpty()) {
            Task task = q.poll();

            if (tg == null) {
                tg = new TaskGroup(task);
                continue;
            }

            if (tg.addTask(task)) {
                continue;
            }

            // 넣기 실패한 경우
            ans += tg.size();
            tg = new TaskGroup(task);
        }
        ans += tg.size();

        System.out.println(ans);


    }

    static class Task implements Comparable<Task> {
        int s;
        int e;

        public Task(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Task o) {
            int compare = Integer.compare(this.s, o.s);
            if (compare == 0) {
                return Integer.compare(e, o.e) * -1;
            }
            return compare;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }

    static class TaskGroup{
        int s;
        int e;
        List<Integer> floor;

        public TaskGroup(Task task){
            this.s = task.s;
            this.e = task.e;
            floor = new ArrayList<>();
            floor.add(e);
        }
        // 일단은 연결이 가능한지 체크
        // floor의 e 중에 하나는 내 s랑 같거나 커야 함.
        // 체크 했다면 내 들어갈 자리 찾는다.
        // e가 나보다 작은 곳에 들어감
        // 자리 없으면 add해
        public boolean addTask(Task task){
            if(this.e < task.s - 1)
                return false;
            this.e = Math.max(e, task.e);

            for(int i = 0; i< floor.size(); i++){
                if (floor.get(i) < task.s) {
                    floor.set(i, task.e);
                    return true;
                }
            }
            floor.add(task.e);
            return true;
        }
        public int size(){
            return (e - s +1) * floor.size();
        }
    }

}
