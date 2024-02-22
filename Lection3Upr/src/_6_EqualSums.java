import java.util.Arrays;
import java.util.Scanner;

public class _6_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int i=0; i< nums.length;i++)
        {
            int leftSum = 0;
            for(int j=0; j< i; j++)
            {
                leftSum+=nums[j];
            }
            int rightSum = 0;
            for(int j=i+1; j <= nums.length-1; j++)
            {
                rightSum+=nums[j];
            }
            if(leftSum==rightSum){
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
