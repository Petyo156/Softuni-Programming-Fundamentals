import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _4_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        int number, index;
        while(!command.equals("End")){
            String[] arr = command.split(" ");
            String injunction = arr[0];
            switch (injunction){
                case "Add":
                    number = Integer.parseInt(arr[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(arr[1]);
                    index = Integer.parseInt(arr[2]);
                    if(index>=0&&index<=numbers.size()-1) {
                        numbers.add(index,number);
                    }
                    else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(arr[1]);
                    if(index>=0&&index<=numbers.size()-1) {
                        numbers.remove(index);
                    }
                    else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    switch (arr[1]){
                        case "left":
                            int countShiftLeft = Integer.parseInt(arr[2]);
                            for(int i=0;i<countShiftLeft;i++){
                                int temp = numbers.get(0);
                                numbers.remove(0);
                                numbers.add(temp);
                            }
                            break;
                        case "right":
                            int countShiftRight = Integer.parseInt(arr[2]);
                            for(int i=0;i<countShiftRight;i++){
                                int temp = numbers.get(numbers.size()-1);
                                numbers.remove(numbers.size()-1);
                                numbers.add(0,temp);
                            }
                            break;
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        for (int printNum:numbers) {
            System.out.print(printNum+" ");
        }
    }
}
