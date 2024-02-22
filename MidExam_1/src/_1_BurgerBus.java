import java.util.Scanner;

public class _1_BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(scanner.nextLine());

        double allIncome = 0;
        double allExpenses = 0;

        for(int i=1; i<=numberOfCities; i++){
            String cityName = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());
            if(i%3==0&&i%5==0) {
                income-=income*(10.0/100);
            }
            else if(i%3==0){
                expenses+=expenses*(50.0/100);
            }
            else if(i%5==0){
                income-=income*(10.0/100);
            }
            allIncome += income;
            allExpenses += expenses;

            double resultCity = income - expenses;
            System.out.printf("%nIn "+ cityName + " Burger Bus earned %.2f leva.", resultCity);
        }
        double result = allIncome-allExpenses;
        System.out.printf("%nBurger Bus total profit: %.2f leva.", result);
    }
}
