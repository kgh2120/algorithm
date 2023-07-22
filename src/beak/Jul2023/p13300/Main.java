package beak.Jul2023.p13300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;


/**
 * @url : https://www.acmicpc.net/problem/13300
 * @info : BOJ B2
 * @time : 8min
 * @try : 1
 * @type : 배열, 카운팅
 * @performance : memory : 12236, time : 100ms
 */
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    /**
     *
     * 학생들의 반 배정은 성별-학년을 기준으로 나뉜다.
     * 학년은 1~6학년까지 있기 때문에, 총 12개의 그룹으로 나뉨.
     * 카운팅을 해야 하기 때문에, Map을 이용해서 카운팅을 진행
     * 학생의 정보(성별,학년)을 이용해야 하기 때문에 클래스를 만들어야 하고,
     * 동일성 체크를 해야 해서 equals 메서드와 해시맵을 쓸 것이기 때문에
     * hashcode() 재정의 해야 할 것.
     *
     */

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Node, Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map.put(node,
                    map.getOrDefault(node,0)+1
                    );
        }

        int result = 0;
        for(Integer count : map.values()){
            if(count == 0)
                continue;

            result += (count -1)/k +1;
        }

        System.out.println(result);





    }

    static class Node{
        int sex;
        int grade;

        public Node(int sex, int grade) {
            this.sex = sex;
            this.grade = grade;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return sex == node.sex && grade == node.grade;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sex, grade);
        }
    }




}