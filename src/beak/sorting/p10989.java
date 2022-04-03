package beak.sorting;

import java.io.*;

/*
    문제 : 수 정렬하기3
    난이도 : 실버 5
    특징 : 카운팅 정렬이라는 기법을 사용해서 풀어야 했다. 카운팅 정렬은 O(n)이라는 놀라운 성능을 보여준다.
           하지만 오히려 많은 메모리를 사용한다는 특징이 있다고 한다.
           살면서 처음 들어본 정렬 방법이었고, 색달랐다. 수의 값이 작으면 작을수록 이용하기 좋다고 한다.
           카운팅 정렬 강의 : https://www.youtube.com/watch?v=n4kbFRn2z9M
 */
public class p10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loop = Integer.parseInt(br.readLine());
        int [] counting = new int[10001];
        for(int i = 0; i<loop; i++){
            counting[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i< counting.length;i++){
            if(counting[i]== 0)
                continue;
            for(int j = 0; j<counting[i];j++)
                bw.write(Integer.toString(i)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
