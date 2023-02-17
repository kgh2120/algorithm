import java.util.ArrayList;
import java.util.List;

/**
 * 로또 확률 문제
 * 당첨자 수 , 지원자 수, 금액이 있었다.
 * 당첨확률 중 금액이 높은 것을 선택하는 문제.
 *
 */
public class M1 {
    StringBuilder sb = new StringBuilder();


    public int solution(int[][] lotteries) throws Exception {

        Lottery[] ll = new Lottery[lotteries.length];
        for (int i = 0; i < ll.length; i++) {
            ll[i] = new Lottery(lotteries[i],i+1);        }

        List<Lottery> group = new ArrayList<>();

        // 바로 되는거 찾기
        for (Lottery lottery : ll) {
            if (lottery.nOfSuccess >= lottery.nOfPurchaser) {
                group.add(lottery);
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (Lottery lottery : group) {

            if(lottery.money > max){
                max = lottery.money;
                index = lottery.number;
            }
        }

        if(index != -1)
            return index;



        // 당첨 확률


        double percent = 0;

        for (Lottery lottery : ll) {

            if (lottery.pctOfSuccess > percent) {
                percent = lottery.pctOfSuccess;
                group.clear();
                group.add(lottery);
            }
            else if (lottery.pctOfSuccess == percent) {
                group.add(lottery);
            }

        }
        for (Lottery lottery : group) {

            if(lottery.money > max){
                max = lottery.money;
                index = lottery.number;
            }
        }


            return index;



    }

    class Lottery{
        int number;
        int nOfSuccess;
        int nOfPurchaser;
        int money;
        double pctOfSuccess;

        public Lottery(int [] l,int index) {
            this.nOfSuccess = l[0];
            this.nOfPurchaser = l[1] +1;
            this.money = l[2];
            this.number = index;
            pctOfSuccess = (double) nOfSuccess/nOfPurchaser  ;
        }


    }

    public static void main(String[] args) throws Exception {

        int [][] l = {
                {100,100,500},
                {1000,1000,100}
        };

        System.out.println(new M1().solution(l));;
    }
}





