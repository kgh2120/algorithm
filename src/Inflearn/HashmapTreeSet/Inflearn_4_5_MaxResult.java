package Inflearn.HashmapTreeSet;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  n 장의 카드 중 3장을 뽑아서 합한 값 중 k 번째로 큰 값을 고르는 문제.
 *  문제 이해를 늦게 해서 시간이 많이 걸렸고, 틀리기도 했음.
 *  중복 값 제거를 위해서 set을 써서 했고, stream.sort를 통해서 계산할 때 마다 비교를 사용했는데,
 *  TreeSet으로 생성하는 것이 더 좋았을 거 같다.
 */

public class Inflearn_4_5_MaxResult {
    public static void answer(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nOfCard = sc.nextInt();
        int nOfPick = sc.nextInt();

        List<Integer> cards = new ArrayList<>();

        for (int i = 0; i < nOfCard; i++) {
            int input = sc.nextInt();
            cards.add(input);
        }


        cards.sort(Collections.reverseOrder());
        Set<Integer> resultSet = new HashSet<>();

        int border = 0;
        for (int i = 0; i < nOfCard-2; i++) {
            for (int j = i+1; j < nOfCard-1; j++) {
                for (int k = j+1; k < nOfCard; k++) {
                    int result = cards.get(i) + cards.get(j) + cards.get(k);
                    if (resultSet.size() < nOfPick) {
                        resultSet.add(result);
                    }else{
                        if (result > border) {
                            resultSet.add(result);
                            List<Integer> collect = resultSet.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
                            border = collect.get(nOfPick-1);
                        }else
                            break;
                    }
                }
            }
        }
        if(resultSet.size() <nOfPick)
            System.out.println(-1);
        else
            System.out.println(border);
    }

    public static void feedback(String[]args) {

        Scanner sc = new Scanner(System.in);
        int nOfCard = sc.nextInt();
        int nOfPick = sc.nextInt();

        List<Integer> cards = new ArrayList<>();

        for (int i = 0; i < nOfCard; i++) {
            int input = sc.nextInt();
            cards.add(input);
        }
        Set<Integer> resultSet = new TreeSet<>(Collections.reverseOrder());

        int border = 0;
        for (int i = 0; i < nOfCard-2; i++) {
            for (int j = i+1; j < nOfCard-1; j++) {
                for (int k = j+1; k < nOfCard; k++) {
                    int result = cards.get(i) + cards.get(j) + cards.get(k);
                    resultSet.add(result);
                    }
                }
            }

        if (resultSet.size() < nOfPick) {
            System.out.println(-1);
        } else {
            int index = 1;
            for (Integer integer : resultSet) {
                if (index == nOfPick) {
                    System.out.println(integer);
                    return;
                }
                else index++;
            }
        }
    }
}
