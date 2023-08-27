import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author 규현
 * @url
 * @level
 * @try
 * @performance
 * @category #
 * @note 교실은 N * N, 학생은 1 ~ N^2 까지 존재 가장 위는 1,1 가장 아래는 N,N
 * <p>
 * 인접한 칸 : | r1 - r2 | + |c1 - c1| == 1인 경우우
 * <p>
 * 배치. 1. 좋아하는 학생이 많이 인접하도록 배치. 2. 1이 많다면, 인접한 칸 중 많이 비어있는 곳으로 선택 3. 2도 같다면, r이 작고, c도 작은 칸으로 설정한다.
 * <p>
 * 전부 배치한 다음엔 학생의 만족도를 조사한다. 좋아하는 친구가 인접한 수에 따라서 만족도가 다르다. 0명 : 0점, 1명 : 1점, 2명 : 10점, 3명 : 100점, 4명
 * : 1000점
 * <p>
 * 만족도의 총 합을 구하자.
 * <p>
 * 3 <= N <= 20; 1ms 1024mb
 * <p>
 * 일단 어... 차례가 오면, 전체 매트릭스를 순회를 해야 해. 이때 인접한 친구들을 체크해야 하니까. 400 * 4, 1600회임.
 * <p>
 * 한 학생의 가능 위치를 체크할 때, 해당 지점에서 좋아하는 친구 수와 빈칸의 수를 체크해야 해. 그래서.. 음.. 좋아하는 수와 빈칸 수를 max 값으로 체크해서. 해당
 * 조건을 만족시킬 떄 r,c를 바꿔줘야 할 듯. 이걸 왼쪽 상단부터 오른쪽 하단으로 탐색할 경우, 3번 조건을 만족시킬 수 있을 듯 함.
 * <p>
 * 그렇게 배치를 한다면... 1600회 안에 배치가 가능할 듯 하다.
 * <p>
 * 필요한 것.
 * <p>
 * 세팅할 int[][] 배열. maxFriend, maxBlank, 각 사람마다의 친구 체크.
 * <p>
 * 1억이 1초
 * @since 2023-08-27
 */

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] matrix;
    static Student[] students;
    static int n;

    static int[][] deltas = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    static int[] scores = {0,1,10,100,1000};
    static int finalScore;

    public static void main(String[] args) throws Exception {
        setVariables();
        setMatrix();
        calculateScore();
        System.out.println(finalScore);

    }

    private static void calculateScore(){

        for (Student student : students) {
            finalScore += student.calculateScore();
        }

    }

    private static void setMatrix(){
        for (Student student : students) {
            int maxFriends = -1;
            int maxBlank = -1;
            int row = -1;
            int col = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] != 0) continue;
                    int friends = 0;
                    int blanks = 0;
                    for (int[] delta : deltas) {
                        int nr = i + delta[0];
                        int nc = j + delta[1];
                        if (isIn(nr, nc)) {
                            if (matrix[nr][nc] == 0) {
                                blanks++;
                            }else{
                                if(student.isFriend(matrix[nr][nc])){
                                    friends++;
                                }
                            }
                        }
                    }
                    if (friends > maxFriends) {
                        maxFriends = friends;
                        maxBlank = blanks;
                        row = i;
                        col = j;
                    } else if (friends == maxFriends && blanks > maxBlank) {
                        maxBlank = blanks;
                        row = i;
                        col = j;
                    }
                }
            }
            matrix[row][col] = student.number;
            student.row = row;
            student.col = col;
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private static void setVariables() throws IOException {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        students = new Student[n * n];

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());
            int f4 = Integer.parseInt(st.nextToken());
            students[i] = new Student(new int[]{f1,f2,f3,f4}, number);
        }
    }

    static class Student {

        int[] friends;
        int number;
        int row;
        int col;

        public Student(int[] friends, int number) {
            this.friends = friends;
            this.number = number;
        }

        public boolean isFriend(int number) {
            for (int friend : friends) {
                if (friend == number) {
                    return true;
                }
            }
            return false;
        }

        public int calculateScore(){
            int counts = 0;
            for (int[] delta : deltas) {
                int nr = row + delta[0];
                int nc = col + delta[1];
                if (isIn(nr, nc)) {
                    if(isFriend(matrix[nr][nc]))
                        counts++;
                }
            }
            return scores[counts];

        }

    }


}