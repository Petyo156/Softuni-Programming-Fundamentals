import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _11_MessageDecypher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex =
                  "^(\\$|%)(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<group1>[0-9]+)\\]\\|\\[(?<group2>[0-9]+)\\]\\|\\[(?<group3>[0-9]+)\\]\\|$";
                //"(\\$|%)(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<group1>[0-9]+)\\]\\[(?<group2>[0-9]+)\\]\\[(?<group3>[0-9]+)\\]";

        for(int i=0; i<n; i++) {
            String message = scanner.nextLine();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);

            if(matcher.find()){
                String tag = matcher.group("tag");
                int num1 = Integer.parseInt(matcher.group("group1"));
                int num2 = Integer.parseInt(matcher.group("group2"));
                int num3 = Integer.parseInt(matcher.group("group3"));

                char char1 = (char) num1;
                char char2 = (char) num2;
                char char3 = (char) num3;

                String decryptedMessage = "" + char1 + char2 + char3;
                StringBuilder tags = new StringBuilder(tag.replaceAll("\\$", ""));
                tags = new StringBuilder(tags.toString().replaceAll("%", ""));
                System.out.println(tags + ": " + decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
