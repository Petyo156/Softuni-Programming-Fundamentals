import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _5_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(\\||#)(?<itemname>[A-Za-z\\s]+)\\1(?<expirationdate>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> items = new ArrayList<>();
        int allCalories = 0;
        while(matcher.find()) {
            String itemName = matcher.group("itemname");
            String expDate = matcher.group("expirationdate");
            int calories = Integer.parseInt(matcher.group("calories"));

            allCalories+=calories;

            //"Item: {item name}, Best before: {expiration date}, Nutrition: {calories}"
            items.add("Item: "+itemName+", Best before: "+expDate+", Nutrition: "+calories);
        }
        int daysFood = allCalories/2000;
        System.out.printf("You have food to last you for: %d days!%n",daysFood);
        for (String item: items) {
            System.out.println(item);
        }

    }
}
