import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _7_Destination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String regex = "(=|/)(?<name>[A-Z][a-zA-Z]{2,})\\1";
                     //"(=||/)(?<name>[A-Z][a-zA-Z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        List<String> destinations = new ArrayList<>();
        int points = 0;
        while(matcher.find()){
            String found = matcher.group();

            StringBuilder lol = new StringBuilder(found);
            lol = new StringBuilder(lol.toString().replaceAll("=", ""));
            lol = new StringBuilder(lol.toString().replaceAll("/", ""));

            destinations.add(lol.toString());
            points+=lol.toString().length();
        }
        //"Destinations: {destinations joined by ', '}".

        System.out.print("Destinations: ");
        for (int i=0; i< destinations.size(); i++) {
            if(i!=destinations.size()-1) {
                System.out.print(destinations.get(i) + ", ");
            } else {
                System.out.print(destinations.get(i));
            }
        }
        System.out.println();
        System.out.printf("Travel Points: "+points);
    }
}
