import java.util.Scanner;

public class _2_TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String[] commandSplitted = command.split(">>");
        double governmentMoney = 0;
        for(int i=0; i < commandSplitted.length; i++) {

            String[] commands = commandSplitted[i].split(" ");

            String typeOfVehicle = commands[0];
            int yearsForPaying = Integer.parseInt(commands[1]);
            int kilometersTravelled = Integer.parseInt(commands[2]);

            double allTax;

            switch (typeOfVehicle) {
                case "family":

                    allTax = kilometersTravelled / 3000 * 12 + (50 - yearsForPaying * 5);
                    governmentMoney+=allTax;
                    System.out.printf("%nA %s car will pay %.2f euros in taxes.", typeOfVehicle, allTax);

                    break;
                case "heavyDuty":

                    allTax = kilometersTravelled / 9000 * 14 + (80 - yearsForPaying * 8);
                    governmentMoney+=allTax;
                    System.out.printf("%nA %s car will pay %.2f euros in taxes.", typeOfVehicle, allTax);

                    break;
                case "sports":

                    allTax = kilometersTravelled / 2000 * 18 + (100 - yearsForPaying * 9);
                    governmentMoney+=allTax;
                    System.out.printf("%nA %s car will pay %.2f euros in taxes.", typeOfVehicle, allTax);

                    break;
                default:
                    System.out.printf("%nInvalid car type.");
                    break;
            }
        }
        System.out.printf("%nThe National Revenue Agency will collect %.2f euros in taxes.", governmentMoney);
    }
}
