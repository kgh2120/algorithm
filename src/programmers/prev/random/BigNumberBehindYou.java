package programmers.prev.random;

import java.util.Comparator;
import java.util.PriorityQueue;

class BigNumberBehindYou {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];


        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){

            @Override
            public int compare(Element e1, Element e2){
                return e1.key - e2.key;
            }
        });

        int idx = 0;
        while(idx < numbers.length){
            int num = numbers[idx];
            while(true){
                Element e = pq.peek();
                if(e == null)
                    break;
                if(e.key >= num)
                    break;
                answer[e.idx] = num;
                pq.poll();
            }
            pq.add(new Element(num,idx));
            idx++;
        }
        for(int i = 0; i< answer.length; i++)
            if(answer[i] == 0)
                answer[i] = -1;


        return answer;
    }
    class Element{
        int key;
        int idx;
        Element(int num, int i){
            key = num;
            idx = i;
        }
    }





    public static void main(String[] args) {


        System.out.println(new BigNumberBehindYou().solution(new int[]{2, 3, 3, 5}));
    }
}