import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while(!command.equals("end")){
            if(command.contains("Add")){
                int numPassengers = Integer.parseInt(command.split(" ")[1]);
                wagons.add(numPassengers);
            }
            else {
                int numPassengers = Integer.parseInt(command);
                for(int i=0; i<wagons.size(); i++){
                    if(numPassengers + wagons.get(i) <= maxCapacity){
                        wagons.set(i, numPassengers + wagons.get(i));
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }
        for (int wagon:wagons) {
            System.out.print(wagon + " ");
        }

    }
}
