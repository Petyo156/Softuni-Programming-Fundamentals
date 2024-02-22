import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _3_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> productsQuantity = new LinkedHashMap<>(); //product -> quantity
        Map<String, Double> productsPrice = new LinkedHashMap<>(); //product -> price

        String command = scanner.nextLine();
        while(!command.equals("buy")){
            //"{name} {price} {quantity}".
            String name = command.split(" ")[0];
            double price = Double.parseDouble(command.split(" ")[1]);
            int quantity = Integer.parseInt(command.split(" ")[2]);

            if(!productsQuantity.containsKey(name)){
                productsQuantity.put(name, quantity);
                productsPrice.put(name, price);
            }
            else{
                int currentQuantity = productsQuantity.get(name);
                productsQuantity.put(name, quantity+currentQuantity);
                if(price!=productsPrice.get(name)){
                    productsPrice.put(name, price);
                }
            }
            command = scanner.nextLine();
        }
        //"{productName} -> {totalPrice}"
        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            String productName = entry.getKey();
            int totalQuantity = entry.getValue();
            double totalPrice = totalQuantity * productsPrice.get(productName);
            System.out.printf("%s -> %.2f%n",productName, totalPrice);
        }
    }
}
