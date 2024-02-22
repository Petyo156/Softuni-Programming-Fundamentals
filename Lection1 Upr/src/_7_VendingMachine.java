import java.util.Scanner;

public class _7_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sumOfCoins = 0;
        double coinsD;
        String coins = scanner.nextLine();
        while(!coins.equals("Start")) {
            coinsD = Double.parseDouble(coins);
            if(coinsD==0.1||coinsD==0.2||coinsD==0.5||coinsD==1||coinsD==2) {
                sumOfCoins+=coinsD;
            }
            else{
                coinsD = Double.parseDouble(coins);
                System.out.printf("Cannot accept %.2f",coinsD);
            }
            coins = scanner.nextLine();
        }

        String commands = scanner.nextLine();
        while(!commands.equals("End")){
            switch (commands){
                case "Nuts":
                    if(sumOfCoins>=2){
                        System.out.println("Purchased Nuts");
                        sumOfCoins-=2;
                    }
                    else {
                        System.out.println("Sorry, not enough money");
                    }
                    commands = scanner.nextLine();
                    break;
                case "Water":
                    if(sumOfCoins>=0.7){
                        System.out.println("Purchased Water");
                        sumOfCoins-=0.7;
                    }
                    else {
                        System.out.println("Sorry, not enough money");
                    }
                    commands = scanner.nextLine();
                    break;
                case "Crisps":
                    if(sumOfCoins>=1.5){
                        System.out.println("Purchased Crisps");
                        sumOfCoins-=1.5;
                    }
                    else {
                        System.out.println("Sorry, not enough money");
                    }
                    commands = scanner.nextLine();
                    break;
                case "Soda":
                    if(sumOfCoins>=0.8){
                        System.out.println("Purchased Soda");
                        sumOfCoins-=0.8;
                    }
                    else {
                        System.out.println("Sorry, not enough money");
                    }
                    commands = scanner.nextLine();
                    break;
                case "Coke":
                    if(sumOfCoins>=1){
                        System.out.println("Purchased Coke");
                        sumOfCoins-=1;
                    }
                    else {
                        System.out.println("Sorry, not enough money");
                    }
                    commands = scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid product");
                    commands = scanner.nextLine();
                    break;
            }
        }
        System.out.printf("Change: %.2f",sumOfCoins);
    }
}
