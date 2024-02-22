import java.util.Arrays;
import java.util.Scanner;

public class _8_MagicNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int sum = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[i]+nums[j]==sum){
                    System.out.printf("%d %d%n",nums[i],nums[j]);
                }
            }
        }
    }
}
