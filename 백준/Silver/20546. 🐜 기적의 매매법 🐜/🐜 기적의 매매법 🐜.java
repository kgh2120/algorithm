import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 준현이 전략 BNP
 * 가능한 모든 돈을 박아서 구매한다. 구매를 못하면 만다. 반복.
 * <p>
 * 성민이 전략 TIMING
 * 3일 연속 상승장이면 전량 매도한다.
 * 3일 연속 하락장이면 전량 매수한다.
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int budget = Integer.parseInt(br.readLine());

        Player jh = new Player(budget);
        Player sm = new Player(budget);

        st = new StringTokenizer(br.readLine());


        int status = 0;
        int chain = 0;
        int prev = -1;
        while (st.hasMoreTokens()) {
            int stockPrice = Integer.parseInt(st.nextToken());
            if(prev == -1)
                prev = stockPrice;

            jh.buyAll(stockPrice);

            // 새로운 애랑 그 전애랑 비교를 해 일단.
            if (stockPrice > prev) {
                if(status == 1)
                    chain++;
                else {
                    status = 1;
                    chain = 1;
                }
            } else if(stockPrice == prev) {
                status = 0;
                chain = 0;
            } else {
                if (status == -1) {
                    chain++;
                } else {
                    status = -1;
                    chain = 1;
                }
            }

            if (chain >= 3) {
                if (status == 1) {
                    sm.sellAll(stockPrice);
                } else {
                    sm.buyAll(stockPrice);
                }


            }

            prev = stockPrice;
        }

        int jhMoney = jh.calculate(prev);
        int smMoney = sm.calculate(prev);


        int result = Integer.compare(jhMoney, smMoney);
        if (result >= 1) {
            System.out.println("BNP");
        } else if (result == 0) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }

    }

    static class Player {
        int budget;
        int stock;

        public Player(int budget) {
            this.budget = budget;
        }

        public void buyAll(int stockPrice) {
            if (budget < stockPrice) return;
            stock += budget / stockPrice;
            budget %= stockPrice;
        }

        public void sellAll(int stockPrice) {
            if(stock <= 0) return;
            budget += stock * stockPrice;
            stock = 0;
        }

        public int calculate(int stockPrice){
            return budget + stock * stockPrice;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "budget=" + budget +
                    ", stock=" + stock +
                    '}';
        }
    }


}
