package zerobase.quiz.first;

import java.util.ArrayList;
import java.util.List;

class P4 {
    int n;
    int i;
    int j;
    int answer;
    List<Integer> s = new ArrayList<>();
    public int solution(int n, int i, int j) {
        answer = 0;
        this.n = n;
        this.i = i;
        this.j = j;
        findNumberOfMatrix(0,0,n,n);
        return answer;
    }

    private void findNumberOfMatrix(int leftRow, int leftCol, int rightRow, int rightCol){

        if(leftRow - rightRow == -1 && leftCol - rightCol == -1){
            int max = n*n;
            int k = max;
            for (Integer integer : s) {
                k = k / 4;
                max = max - ((4 - integer) * k);
            }
            answer = max;
            return;
        }

        int halfRow = (rightRow + leftRow)/2;
        int halfCol = (rightCol + leftCol)/2;
        if(leftRow == rightRow || leftCol == rightCol)
            return;

        if(halfRow >= (i+1) && halfCol < (j+1)){
            s.add(1);
            findNumberOfMatrix(leftRow, halfCol, halfRow, rightCol);
        }

        else if(halfRow >= i+1 && halfCol >= j+1){
            s.add(2);
            findNumberOfMatrix(leftRow, leftCol, halfRow, halfCol);
        }

        else if(halfRow < i+1 && halfCol >= j+1){
            s.add(3);
            findNumberOfMatrix(halfRow, leftCol, rightRow, halfCol);
        }

        else if(halfRow < i+1 && halfCol < j+1){
            s.add(4);
            findNumberOfMatrix(halfRow, halfCol, rightRow, rightCol);
        }
    }


    public static void main(String[] args) {
        System.out.println(new P4().solution(8,0,0));
    }
}