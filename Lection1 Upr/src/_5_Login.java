import java.util.Scanner;

public class _5_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password="";
        for(int position = username.length()-1;position>=0;position--)
        {
            char currentSymbol = username.charAt(position);
            password+=currentSymbol;
        }
        int sum = 0;
        for(;;) {
            String passwordInput = scanner.nextLine();
            if (!password.equals(passwordInput)) {
                sum++;
                if (sum >= 4) {
                    System.out.printf("User %s blocked!", username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            } else {
                System.out.printf("User %s logged in.", username);
                break;
            }
        }
    }
}
