import java.util.Scanner;

public class _1_dayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String days[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        if(n>0&&n<8){
            System.out.println(days.length);
        }
        else{
            System.out.println("Invalid day!");
        }
    }
}

