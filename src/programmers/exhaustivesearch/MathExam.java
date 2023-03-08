package programmers.exhaustivesearch;

import java.util.Arrays;

public class MathExam {
    public int[] solution(int[] answers) {

        int oddCount = 0;
        MathHater[] haters= new MathHater[3];
        for(int i = 0; i<3; i++)
            haters[i] = new MathHater(i+1);

        for(int i = 0; i<answers.length; i++){
            if((i%5 +1)== answers[i])
                haters[0].correct();
            if(i%2 == 0 && answers[i] == 2)
                haters[1].correct();
            if(i%2 != 0 ){
                if( s2(oddCount,answers[i]))
                    haters[1].correct();
                oddCount++;
            }
            if(s3(i,answers[i]))
                haters[2].correct();
        }

        Arrays.sort(haters);
        int idx = 0;
        int max = haters[0].count;

        for(MathHater mh : haters){
            if(max == mh.count)
                idx++;
        }
        int[] answer = new int [idx];
        for (int i = 0; i < idx; i++) {
            answer[i] = haters[i].order;
        }

        return answer;
    }

    private boolean s2(int oddCount, int target){
        oddCount = oddCount%4;
        switch(oddCount){
            case 0 : oddCount = 1;
                break;
            case 1 : oddCount = 3;
                break;
            case 2 : oddCount = 4;
                break;
            case 3 : oddCount = 5;
                break;
        }
        return oddCount == target;
    }

    private boolean s3(int i , int target){
        int c = (i%10);
        if(c != 0)
            c = c/2;
        switch(c){
            case 0 : c = 3;
                break;
            case 3 : c = 4;
                break;
            case 4 : c = 5;
                break;
        }
        return c == target;
    }

    class MathHater implements Comparable<MathHater>{
        int order;
        int count;

        MathHater(int order){
            this.order = order;
        }

        public void correct(){
            count++;
        }

        @Override
        public int compareTo(MathHater o){
            if(this.count > o.count)
                return -1;
            else if(this.count < o.count)
                return 1;
            else{
                if(this.order < o.order)
                    return -1;
                else
                    return 1;
            }

        }
    }

    public static void main(String[] args) {

        int [] a = {1,3,2,4,2};


        System.out.println((Arrays.toString(new MathExam().solution(a))));
    }

}
