package programmers.prev.exhaustivesearch;

public class MinRectangle{
    public int solution(int[][] sizes) {
        for (int[] size : sizes)
            maxToLeft(size);

        return getMax(sizes,0) * getMax(sizes,1);
    }

    private int getMax(int [][] cards, int col){
        int max = cards[0][col];
        for(int[] card : cards)
            max = Math.max(max,card[col] );

        return max;
    }

    private void maxToLeft(int[]card){
        if(card[1] > card[0])
            swap(card,0,1);
    }

    private void swap(int[] card, int l ,int r){
        int temp = card[l];
        card[l] = card[r];
        card[r] = temp;
    }



}
