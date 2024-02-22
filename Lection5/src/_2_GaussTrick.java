import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _2_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .toList());

        List<Integer> result = new ArrayList<>();

        if(numbers.size() % 2 != 0){
            int midIndex = numbers.size() / 2;
            numbers.add(midIndex, 0);
        }

        for(int i=0; i < numbers.size()/2; i++){
            int addedNum = numbers.get(i) + numbers.get(numbers.size()-i-1);
            result.add(addedNum);
        }

        for(int num : result){
            System.out.print(num+" ");
        }
    }
}
