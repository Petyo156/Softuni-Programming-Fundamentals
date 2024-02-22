/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();
        boolean firstIterationDone = false;

        for(int i=0; i<numOfCommands; i++){
            String command = scanner.nextLine();

            if(command.contains("is not going!")){
                for (String name:names) {
                    if(command.split(" ")[0].equals(name)){
                        names.remove(name);
                        break;
                    }
                    else {
                        System.out.println(command.split(" ")[0]+" is not in the list!");
                    }
                }
            }
            else{
                if(!firstIterationDone){
                    names.add(command.split(" ")[0]);
                    firstIterationDone=true;
                }
                else {
                    if(names.contains(command.split(" ")[0])){
                        System.out.println(command.split(" ")[0]+" is already in the list!");
                    } else {
                        names.add(command.split(" ")[0]);
                    }
                }
            }
        }
        for (String name:names) {
            System.out.println(name);
        }
    }
}*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < numOfCommands; i++) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[2].equals("not")) {
                if (names.contains(parts[0])) {
                    names.remove(parts[0]);
                } else {
                    System.out.println(parts[0] + " is not in the list!");
                }
            } else {
                if (names.contains(parts[0])) {
                    System.out.println(parts[0] + " is already in the list!");
                } else {
                    names.add(parts[0]);
                }
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
