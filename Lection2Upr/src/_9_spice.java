import java.util.Scanner;

public class _9_spice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int allYield = 0;
        int days = 0;
        while(startingYield>=100){
            allYield+=startingYield;
            startingYield-=10;
            allYield-=26;
            days++;
        }
        allYield-=26;
        if(allYield<0){allYield=0;}
        System.out.printf("%d%n%d",days,allYield);
    }
}
