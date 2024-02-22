import java.util.Scanner;

public class _8_ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String mainString = command;
        StringBuilder edit = new StringBuilder(command);

        command = scanner.nextLine();
        while (!command.equals("Generate")){
            String[] arr = command.split(">>>");
            String mainCommand = arr[0];
            if(mainCommand.equals("Contains")){
                String substring = arr[1];

                if(edit.toString().contains(substring)){
                    System.out.printf("%s contains %s%n",edit.toString(),substring);
                } else {
                    System.out.println("Substring not found!");
                }
            }
            else if(mainCommand.equals("Flip")){
                String upperOrLower = arr[1];

                int startIdx = Integer.parseInt(arr[2]);
                int endIdx = Integer.parseInt(arr[3]);

                String subs;
                if(upperOrLower.equals("Lower")) {
                    subs = edit.substring(startIdx, endIdx).toLowerCase();
                } else {
                    subs = edit.substring(startIdx, endIdx).toUpperCase();
                }
                edit.replace(startIdx, endIdx, subs);

                System.out.println(edit);
            }
            else if(mainCommand.equals("Slice")){
                int startIdx = Integer.parseInt(arr[1]);
                int endIdx = Integer.parseInt(arr[2]);

                edit.delete(startIdx, endIdx);

                System.out.println(edit);
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: "+edit);
    }
}
