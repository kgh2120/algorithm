import java.util.*;


// 일단 콤비네이션 기술 들어가서 절반 고르고
// 그 다음에 노가다로 승무패 결정한 다음에
// 무 + 패가 제일 적은 경우를 기록하기
// 다른 케이스에서 무+패가 min보다 많다면 백트래킹 하기
class Solution {
    int[][] dice;
    long minLoseDrawCase = -1;

    boolean[] bestSelectedDice;

    public int[] solution(int[][] dice) {
        int[] answer = new int[dice.length/2];
        bestSelectedDice = new boolean[dice.length];
        this.dice = dice;
        comb(0,0,new boolean[dice.length]);
        int j = 0;
        for(int i = 0; i< dice.length;i++){
            if(bestSelectedDice[i]){
                answer[j++] = i+1;
            }
        }
        
        return answer;
    }

    // 최대 10C5 -> 252회
    private void comb(int index, int depth, boolean[] selected){
        if(depth == dice.length/2){
            // 기술 들어가기
            findNumberCase(selected);
            return;
        }

        for(int i = index; i<dice.length; i++){
            selected[i] = true;
            comb(i+1, depth+1, selected);
            selected[i] = false;
        }
    }

    private void findNumberCase(boolean[] selected){


        List<Integer> selectedNumbers = findCase(selected, new ArrayList<>(), 0, true);
        List<Integer> nonSelectedNumbers = findCase(selected, new ArrayList<>(), 0, false);

        Collections.sort(selectedNumbers);
        Collections.sort(nonSelectedNumbers);

        // 이제 셀렉티드 넘버스가지고 바이너리서치 조져서 인덱스 기준으로 찾아내기
        long sumDrawLose = 0;
        for(int num : selectedNumbers){

            int idx = Collections.binarySearch(nonSelectedNumbers, num);
            // upperBound
            if(idx < 0){
                idx = -idx-1;
              sumDrawLose += idx;
            }else {// 어차피 같다는 소리임
                while( idx >= 0 && nonSelectedNumbers.get(idx) == num) idx--;
                sumDrawLose += idx+1;
            }

            // 이제 idx만큼 패,무라는 뜻
          
        }

        if(minLoseDrawCase < sumDrawLose){
            minLoseDrawCase = sumDrawLose;
            System.arraycopy(selected,0,bestSelectedDice,0,bestSelectedDice.length);
        }


    }
    private List<Integer> findCase(boolean[] selected, List<Integer> list, int index, boolean target){

        if(index == selected.length)
            return list;

        if(selected[index] !=target){
            return findCase(selected, list, index+1, target);
        }


        List<Integer> nextList = new ArrayList<>();

        if (list.isEmpty()) {
            for(int d : dice[index]){
                    nextList.add(d);
            }
        } else {
            for(int d : dice[index]){
                for(int prev : list){
                    nextList.add(prev + d);
                }
            }
        }



        return findCase(selected, nextList, index+1, target);
    }






}