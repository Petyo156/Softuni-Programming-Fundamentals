import java.util.Scanner;
import java.util.SimpleTimeZone;

public class _3_ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] arr1 = new String[n];
        String[] arr2 = new String[n];
        for(int i = 1; i<=n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);
            if(i%2==0) {
                arr1[i-1] = String.valueOf(num2);
                arr2[i-1]= String.valueOf(num1);
            }
            else {
                arr1[i-1] = String.valueOf(num1);
                arr2[i-1]= String.valueOf(num2);
            }
        }
        for(String el : arr1){
            System.out.printf("%s ", el);
        }
        System.out.printf("%n");
        for(String el : arr2){
            System.out.printf("%s ", el);
        }
    }
}
