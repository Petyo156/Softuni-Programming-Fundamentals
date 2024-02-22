import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_BarOfDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "%(?<customerName>[A-Z][a-z]+)%[^\\|$%\\.]*<(?<validProduct>\\w+)>[^\\|\\$%\\.]*\\|(?<quantity>[0-9]+)\\|[^\\|\\$%\\.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
                //"%(?<customerName>[A-Z][a-z]+)%<(?<validProduct>[A-Za-z]+)>\\|(?<quantity>[0-9]+)\\|(?<price>\\d+(\\.\\d+)?)\\$"; not working
                //"%(?<customerName>[A-Z][a-z]+)%<(?<validProduct>[A-Za-z]+)>\\|(?<quantity>[0-9]+)\\|(?<price>[0-9]+\\.?[0-9]*)\\$)"; not working
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;
        while (!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String customerName = matcher.group("customerName");
                String validProduct = matcher.group("validProduct");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = price*quantity;
                totalIncome+=totalPrice;

                System.out.printf("%s: %s - %.2f%n",customerName,validProduct,totalPrice);
            }
            input=scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
