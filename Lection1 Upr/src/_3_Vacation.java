import java.util.Scanner;

public class _3_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        int num = Integer.parseInt(scanner.nextLine());
        String people = scanner.nextLine();
        String day = scanner.nextLine();
        switch (people)
        {
            case "Students":
                switch (day)
                {
                    case "Friday":
                        price=8.45*num;
                        break;
                    case "Saturday":
                        price=9.80*num;
                        break;
                    case "Sunday":
                        price=10.46*num;
                        break;
                }
                if(num>=30){
                    price=price-price*0.15;
                }
                break;
            case "Business":
                if(num>=100){
                    num-=10;
                }
                switch (day)
                {
                    case "Friday":
                        price=10.9*num;
                        break;
                    case "Saturday":
                        price=15.6*num;
                        break;
                    case "Sunday":
                        price=16*num;
                        break;
                }
                break;
            case "Regular":
                switch (day)
                {
                    case "Friday":
                        price=15*num;
                        break;
                    case "Saturday":
                        price=20*num;
                        break;
                    case "Sunday":
                        price=22.5*num;
                        break;
                }
                if(num>=10&&num<=20){
                    price=price-price*0.05;
                }
                break;
        }
        System.out.printf("Total price: %.2f", price);
    }
}
