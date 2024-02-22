import java.util.Arrays;
import java.util.Scanner;

public class _6_equalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();

        int[] nums2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();

        int sum = 0;
        boolean equal = true;
        for(int i=0;i< nums.length;i++){
            if(nums[i]==nums2[i])
            {
                sum+=nums[i];
            }
            else{
                equal=false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
        if(equal)
        {
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
