import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _5_ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String userRegex = "[A-Za-z0-9]+[\\.\\-\\_]?[A-Za-z0-9]+";
                //"[A-Za-z0-9][/./_/-]?[A-Za-z0-9]+";
        String domainRegex =  "[A-Za-z]+\\-?[A-Za-z]+(\\.[A-Za-z]+\\-?[A-Za-z]+)+";
                //"[A-Za-z]+\\-?[A-Za-z]+([/.][A-Za-z]+\\-?[A-Za-z])+";

        String regex = userRegex + "@" + domainRegex;

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
