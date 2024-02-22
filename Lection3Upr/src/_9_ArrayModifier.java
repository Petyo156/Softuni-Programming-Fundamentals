import java.util.Arrays;
import java.util.Scanner;

public class _9_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            if(input.contains("swap")){
                int index1 = Integer.parseInt(input.split(" ")[1]);
                int index2 = Integer.parseInt(input.split(" ")[2]);
                int temp = nums[index1];
                nums[index1] = nums[index2];
                nums[index2] = temp;
            }
            else if(input.contains("multiply")){
                int index1 = Integer.parseInt(input.split(" ")[1]);
                int index2 = Integer.parseInt(input.split(" ")[2]);
                nums[index1]=nums[index1]*nums[index2];
            }
            else if(input.contains("decrease")){
                for(int i=0; i<nums.length; i++)
                {
                    nums[i]--;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(nums)
                .replace("[", "")
                .replace("]", ""));
    }
}
