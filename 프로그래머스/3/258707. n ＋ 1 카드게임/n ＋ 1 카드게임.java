import java.util.*;

class Solution {
    
    int currentPairCount = 0;
    Set<Integer> singleSet = new HashSet<>();
    Set<Integer> candidateSet = new HashSet<>();
    int pariCandidate = 0;
    
    int coin;
    int[] cards;
    
    int n;
    
    int answer;
    public int solution(int coin, int[] cards) {
        
        this.coin = coin;
        this.cards = cards;
        this.n = cards.length;
        for(int i = 0; i<cards.length / 3; i++){
            int pair = (n+1) - cards[i];
            
            if(singleSet.contains(pair)){
                singleSet.remove(pair); // 굳이?
                currentPairCount++;
            } else {
                singleSet.add(cards[i]);
            }
        }
        
        
        play(0, n/3);
        
        
        return answer;
    }
    
    private void play(int round, int index){
        
        if(index >= n){
            answer = round+1;
            return;
        }
        
        
        int c1 = cards[index];
        int c2 = cards[index+1];
        
        // 이미 싱글셋에 있는 친구는 
        
        makePairWith(c1);
        makePairWith(c2);
        
        if(currentPairCount == 0){
            if(coin >= 2 && pariCandidate >= 1){
                pariCandidate--;
                coin -= 2;
                currentPairCount++;
            }
        }
        
        if(currentPairCount >= 1){
            currentPairCount--;
            play(round+1, index+2);
        } else {
            answer = round+1;
        }

        
    }
    
    private void makePairWith(int num){
        if(coin <= 0) return;
        
        int pair = (n+1) - num;
        if(singleSet.contains(pair)){
            singleSet.remove(pair);
            currentPairCount++;
            coin--;
            return;
        }
        
        //아니라면
        
        if(candidateSet.contains(pair)){
            candidateSet.remove(pair);
            pariCandidate++;
        } else {
            candidateSet.add(num);
        }
    }
    

    
    
}