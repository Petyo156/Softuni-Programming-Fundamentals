import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] arr = input.split(" ");
            String command = arr[0];
            int index = Integer.parseInt(arr[1]);
            int powerOrValueOrRadius = Integer.parseInt(arr[2]);

            if(command.equals("Shoot")){
                if(index>=0&&index<numbers.size()) {
                    int numberToShoot = numbers.get(index);

                    int operationDone = numberToShoot-powerOrValueOrRadius;
                    if(operationDone<=0){
                        numbers.remove(index);
                    }
                    else{
                        numbers.set(index, operationDone);
                    }
                }
            }
            else if(command.equals("Add")){
                if(index>=0&&index<numbers.size()) {
                    numbers.add(index,powerOrValueOrRadius);
                }
                else{
                    System.out.println("Invalid placement!");
                }
            }
            else if(command.equals("Strike")){
                if(index>=0&&index<numbers.size()) {
                    //int left = Math.max(0, index - powerOrValueOrRadius);
                    //int right = Math.min(index + powerOrValueOrRadius, numbers.size() - 1);

                    int leftIndex = index - powerOrValueOrRadius;
                    int rightIndex = index + powerOrValueOrRadius;
                    if ((rightIndex > 0 && leftIndex > 0)&&(rightIndex < numbers.size() && leftIndex < numbers.size())) {
                        int count = powerOrValueOrRadius*2+1;
                        for (int i = 0; i < count; i++) {
                            numbers.remove(leftIndex);
                        }
                    }
                    else {
                        System.out.println("Strike missed!");
                    }
                }
                else{
                    System.out.println("Invalid placement!");
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i<numbers.size(); i++) {
            if(i!=numbers.size()-1) {
                System.out.print(numbers.get(i)+"|");
            }
            else {
                System.out.print(numbers.get(i));
            }
        }
    }
}
