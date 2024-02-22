import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_SoftuniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String,String> parkingData = new LinkedHashMap<>();

        for(int i=0; i<numOfCommands; i++)
        {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String command = arr[0]; String name = arr[1];
            if(command.equals("register")){
                String carNumber = arr[2];
                if(parkingData.containsKey(name)){
                    System.out.printf("ERROR: already registered with plate number %s%n",parkingData.get(name));
                } else {
                    parkingData.put(name,carNumber);
                    System.out.printf("%s registered %s successfully%n",name,carNumber);
                }
            } else {
                if(!parkingData.containsKey(name)){
                    System.out.printf("ERROR: user %s not found%n", name);
                } else{
                    parkingData.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }
        }
        for (Map.Entry<String, String> entry : parkingData.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
