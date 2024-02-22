import java.util.Arrays;
import java.util.Scanner;

public class _2_printNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String[] elements = scanner.nextLine().split(" ");
        //int[] numbers = new int[elements.length];
        //for(int i = elements.length; i>=0; i--)
        //{
        //    numbers[i]=Integer.parseInt(elements[i]);
        //}

        //String inputLine = scanner.nextLine();
        //String[] items = inputLine.split(" ");
        //int[] arr = Arrays.stream(items)
        //        .mapToInt(e->Integer.parseInt(e)).toArray();

        //int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
        //        .mapToInt(e->Integer.parseInt(e))
        //        .toArray();
        //for (int i = numbers.length; i>=0; i--) {
        //    System.out.printf(String.valueOf(numbers[i])+" ");
        //}

        //int n = Integer.parseInt(scanner.nextLine());
        //int[] numbers = new int[n];
        //int[] numbers2 = new int[n];
        //for(int i = 0; i< numbers.length; i++){
        //    numbers[i] = Integer.parseInt(scanner.nextLine());
        //}
        //int index=0;
        //for(int i=numbers.length-1;i>=0;i--) {
        //    numbers2[i]=numbers[index];
        //    index++;
        //}
        //for(int i = 0; i<numbers.length; i++){
        //    System.out.printf(numbers2[i]+" ");
        //}

        String[] numbers = scanner.nextLine().split(" ");
        String[] numbers2 = new String[numbers.length];

        int index=0;
        for(int i=numbers.length-1;i>=0;i--) {
            numbers2[i]=numbers[index];
            index++;
        }

        System.out.println(String.join(" ", numbers2));
    }
}
