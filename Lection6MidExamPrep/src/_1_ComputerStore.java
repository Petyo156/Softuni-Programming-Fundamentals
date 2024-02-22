import java.util.Scanner;

public class _1_ComputerStore {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double priceForAllAndTax = 0;
        double priceForAllNoTax=0;
        while (true)
        {
            if(command.equals("special")||command.equals("regular")){break;}
            double pricePerComponent = Double.parseDouble(command);
            if(pricePerComponent<0){
                System.out.println("Invalid price!");
            }
            else{
                priceForAllNoTax += pricePerComponent;
                priceForAllAndTax += pricePerComponent*0.2+pricePerComponent;
            }
            command = scanner.nextLine();
        }
        if(command.equals("special"))
        {
            priceForAllAndTax-=priceForAllAndTax*0.1;
            if(priceForAllNoTax>0) {
                print(priceForAllNoTax, priceForAllAndTax);
            }
            else{
                System.out.println("Invalid order!");
            }
        }
        else {
            if(priceForAllNoTax>0) {
                print(priceForAllNoTax, priceForAllAndTax);
            }
            else {
                System.out.println("Invalid order!");
            }
        }
    }
    public static void print(double priceForALlNoTax, double priceForAllAndTax){
        System.out.printf("Congratulations you've just bought a new computer!" +
                "%nPrice without taxes: %.2f$" +
                "%nTaxes: %.2f$" +
                "%n-----------" +
                "%nTotal price: %.2f$",priceForALlNoTax,priceForAllAndTax-priceForALlNoTax,priceForAllAndTax);
    }

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double totalPrice = 0;
        while (!command.equals("special") && !command.equals("regular")) {
            double Price = Double.parseDouble(command);
            if (Price > 0) {
                totalPrice += Price;
            } else {
                System.out.println("Invalid price!");
            }
            command = scanner.nextLine();
        }
        double taxes = totalPrice * 0.2;
        double result = totalPrice + taxes;

        if (totalPrice != 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            if (command.equals("special")) {
                result = result - result * 0.1;
            }
            System.out.printf("Total price: %.2f$%n", result);
        }
        else{
            System.out.println("Invalid order!");
        }
    }

}
