/*import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _6_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(firstPlayer.size() != 0 && secondPlayer.size() != 0){
            int firstPlayerCard = firstPlayer.get(0);
            int secondPlayerCard = secondPlayer.get(0);
            firstPlayer.remove(0);
            secondPlayer.remove(0);
            if(firstPlayerCard>secondPlayerCard){
                secondPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            }
            else if(secondPlayerCard>firstPlayerCard){
                firstPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPlayerCard);
            }
        }

        int sum=0;
        if(secondPlayer.isEmpty()){
            for (int count:firstPlayer) {
                sum+=count;
            }
            System.out.printf("First player wins! Sum: %d",sum);
        }
        else {
            for (int count:secondPlayer) {
                sum+=count;
            }
            System.out.printf("Second player wins! Sum: %d",sum);
        }
    }
}
*/
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _6_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //{20 30 40 50}
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //{10 20 30 40}

        //1. взимам първата карта от ръката
        //2. премахвам картата от ръката
        //3. проверка кой печели:
        // карта 1 > карта 2 -> слагам накрая на ръката на първия -> карта 1 -> карта 2
        //карта 2 > карта 1 -> слагам накрая на ръката на втория -> карта 2 -> карта 1
        //карта 1 == карта 2 -> не ги добавяме никъде

        //играта продължава когато и двамата имат карти
        //играта спира, когато някой остане без карти

        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);
            }
        }

        //1. ако на първия му свършат картите
        if (firstPlayerCards.size() == 0) {
            //втория печели -> сума от картите на втория
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayerCards));
        }
        //2. ако на втория му свършат картите
        else if (secondPlayerCards.size() == 0) {
            //първия печели
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayerCards));
        }
    }

    private static int getCardsSum(List<Integer> listCards) {
        int sum = 0;
        for (int card : listCards) {
            sum += card;
        }

        return sum;
    }
}