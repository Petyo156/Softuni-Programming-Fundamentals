import java.util.List;
import java.util.Scanner;

public class _2_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String productsInput = scanner.nextLine();
        List<String> products = new java.util.ArrayList<>(List.of(productsInput.split("!")));

        String commandForShopping = scanner.nextLine();
        while(!commandForShopping.equals("Go Shopping!")){
            String[] arr = commandForShopping.split(" ");
            String command = arr[0];
            String item = arr[1];
            if(command.equals("Urgent")){
                if(!products.contains(item)){
                    products.add(0,item);
                }
            }
            else if(command.equals("Unnecessary")){
                products.remove(item);
            }
            else if(command.equals("Correct")){
                String newItem = arr[2];
                if(products.contains(item)){
                    int index = products.indexOf(item);
                    products.set(index, newItem);
                }
            }
            else if(command.equals("Rearrange")){
                if(products.contains(item)) {
                    products.remove(item);
                    products.add(item);
                }
            }
            commandForShopping = scanner.nextLine();
        }
        for (int i=0; i<products.size(); i++) {
            if(i==products.size()-1) {
                System.out.print(products.get(i));
            }
            else {
                System.out.print(products.get(i) + ", ");
            }
        }
    }
}
