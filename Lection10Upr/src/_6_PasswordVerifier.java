import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _6_PasswordVerifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCommands = Integer.parseInt(scanner.nextLine());
        String regex = "_\\.+[A-Z][A-Za-z0-9]{4,}[A-Z]_\\.+";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numOfCommands; i++) {
            String password = scanner.nextLine();

            Matcher matcher = pattern.matcher(password);

            if(matcher.find()){
                StringBuilder sum = new StringBuilder();
                for (int j = 0; j < password.toCharArray().length; j++) {
                    if(Character.isDigit(password.charAt(j))){
                        sum.append(password.charAt(j));
                    }
                }
                if(sum.length()==0){
                    System.out.println("Group: default");
                } else {
                    System.out.println("Group: "+sum);
                }
            }
            else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
