import java.util.Arrays;
import java.util.Scanner;

public class _2_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String elements1 = scanner.nextLine();
        String elements2 = scanner.nextLine();

        String[] arr1 = elements1.split(" ");
        String[] arr2 = elements2.split(" ");

        for(String el1 : arr1)
        {
            for(String el2 : arr2)
            {
                if(el1.equals(el2)){
                    System.out.printf(el1+" ");
                }
            }
        }
    }
}
