import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String journalInput = scanner.nextLine();
        List<String> journal = new ArrayList<>(List.of(journalInput.split(", ")));

        String command = scanner.nextLine();
        while (!command.equals("Craft!")){
            String[] arr = command.split(" - ");
            String thingToDo = arr[0];
            String item = arr[1];
            switch (thingToDo){
                case "Collect":
                    if (!journal.contains(item)) {
                        journal.add(item);
                    }
                    break;
                case "Drop":
                    journal.remove(item);
                    break;
                case "Combine Items":
                    String[] itemsSeparated = item.split(":");
                    String item1 = itemsSeparated[0];
                    String item2 = itemsSeparated[1];
                    if(journal.contains(item1)){
                        journal.add(journal.indexOf(item1)+1, item2);
                    }
                    break;
                case "Renew":
                    if(journal.contains(item)) {
                        journal.remove(item);
                        journal.add(item);
                    }
                    break;
                }
                command = scanner.nextLine();
            }
        for (int i=0; i<journal.size(); i++) {
            if(i==journal.size()-1) {
                System.out.print(journal.get(i));
            }
            else {
                System.out.print(journal.get(i) + ", ");
            }
        }
        }

    }

