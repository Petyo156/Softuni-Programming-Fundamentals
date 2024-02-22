import java.util.Arrays;
import java.util.Scanner;

public class _4_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String[] array = scanner.nextLine().split(" ");
        //int numRotations = Integer.parseInt(scanner.nextLine());
        //String[] arrayRotated = new String[array.length];

        //for(int i=0; i<numRotations; i++)
        //{
        //    for(int k = 0; k<arrayRotated.length-1; k++) {
        //        for (int j = arrayRotated.length-1; j >= 0; j--) {
        //            arrayRotated[k]=array[j];
        //            arrayRotated[j]=array[k];
        //        }
        //    }
        //    if(i==numRotations-1){

        //    }
        //}
        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for(int rotation = 1; rotation<= rotations; rotation++){
            int firstElement = numbers[0];
            for(int i = 0; i< numbers.length-1; i++){
                numbers[i]=numbers[i+1];
            }
            numbers[numbers.length-1]=firstElement;
        }
        for (int number:numbers) {
            System.out.printf("%d ", number);
        }
    }
}
