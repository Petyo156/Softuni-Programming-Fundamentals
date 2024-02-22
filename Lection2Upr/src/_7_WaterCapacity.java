import java.util.Scanner;

public class _7_WaterCapacity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int allLiters = 0;
        for(int i=0;i<n;i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            allLiters+=liters;
            if(allLiters>255){
                allLiters-=liters;
                System.out.printf("Insufficient capacity!%n");
            }
        }
        System.out.println(allLiters);
    }
}
