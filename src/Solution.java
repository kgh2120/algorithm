import java.util.*;

class Solution {
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
        fillMatrix(0,0,n,n);
        return answer;
    }

    private void fillMatrix(int leftRow, int leftCol, int rightRow, int rightCol){

        if(leftRow - rightRow == -1 && leftCol - rightCol == -1){

            // 결산

            int max = n*n;
            int k = max;
            for(int i = 0; i< s.size(); i++){
                Integer integer = s.get(i);
                k = k/4;
                max = max - ((4-integer) * k);
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
            fillMatrix(leftRow, halfCol, halfRow, rightCol);
        }

        else if(halfRow >= i+1 && halfCol >= j+1){
            s.add(2);
            fillMatrix(leftRow, leftCol, halfRow, halfCol);
        }

        else if(halfRow < i+1 && halfCol >= j+1){
            s.add(3);
            fillMatrix(halfRow, leftCol, rightRow, halfCol);
        }

        else if(halfRow < i+1 && halfCol < j+1){
            s.add(4);
            fillMatrix(halfRow, halfCol, rightRow, rightCol);
        }
    }


    public static void main(String[] args) {


        System.out.println(new Solution().solution(8,0,0));
    }
}