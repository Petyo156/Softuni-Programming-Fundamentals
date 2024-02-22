/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _5_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> bombNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> remainingNumbers = new ArrayList<>();
        int bomb = bombNumbers.get(0);
        int power = bombNumbers.get(1);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bomb) {
                for (int j = Math.max(0, i - power); j <= Math.min(numbers.size() - 1, i + power); j++) {
                    if (j < i - power || j > i + power) {
                        remainingNumbers.add(numbers.get(j));
                    }
                }
            } else {
                remainingNumbers.add(numbers.get(i));
            }
        }

        int sum = 0;
        for (int number : remainingNumbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
*/
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _5_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        String[] data = scanner.nextLine().split("\\s+");
        String bombNumber = data[0];
        int power = Integer.parseInt(data[1]);

        while (elements.contains(bombNumber)) {
            int elementIndex = elements.indexOf(bombNumber);

            int left = Math.max(0, elementIndex - power);
            int right = Math.min(elementIndex + power, elements.size() - 1);

            for (int i = right; i >= left; i--) {
                elements.remove(i);
            }
        }
        System.out.println(elements.stream().mapToInt(Integer::parseInt).sum());
    }
}





