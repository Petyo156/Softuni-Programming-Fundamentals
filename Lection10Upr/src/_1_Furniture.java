import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = ">>(?<furnitureName>[A-za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> furniture = new ArrayList<>();
        double totalPrice = 0;

        //">>{furniture name}<<{price}!{quantity}"
        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String name = matcher.group("furnitureName");
                furniture.add(name);

                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price*quantity;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String thing : furniture) {
            System.out.println(thing);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
