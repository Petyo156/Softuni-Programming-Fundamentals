import java.util.Scanner;

public class _6_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        char current;
        int sum = 0;
        for(int i = 0; i<=(number.length()-1); i++){
            double fac = 1;
            current = number.charAt(i);
            int currentChar = Integer.parseInt(String.valueOf(current));
            for(int j=1;j<=currentChar;j++){
                fac=fac*j;
            }
            sum+=fac;
        }
        int realNum = Integer.parseInt(number);
        if(realNum==sum){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
