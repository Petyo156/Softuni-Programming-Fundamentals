import java.util.Scanner;

public class _10_Wizards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        StringBuilder spell = new StringBuilder(command);

        command = scanner.nextLine();
        while(!command.equals("Abracadabra")){
            String[] arr = command.split(" ");
            String mainCommand = arr[0];
            if(mainCommand.equals("Abjuration")){
                spell = new StringBuilder(spell.toString().toUpperCase());
                System.out.println(spell);
            }
            else if(mainCommand.equals("Necromancy")){
                spell = new StringBuilder(spell.toString().toLowerCase());
                System.out.println(spell);
            }
            else if(mainCommand.equals("Illusion")){
                int index = Integer.parseInt(arr[1]);
                String letter = arr[2];
                if(index<0||index >= spell.toString().length()){
                    System.out.println("The spell was too weak.");
                } else {
                    spell.replace(index, index+1, letter);
                    System.out.println("Done!");
                }
            }
            else if(mainCommand.equals("Divination"))
            {
                String substring1 = arr[1];
                String substring2 = arr[2];
                if(spell.toString().contains(substring1)) {
                    spell = new StringBuilder(spell.toString().replaceAll(substring1, substring2));
                    System.out.println(spell);
                }
            }
            else if(mainCommand.equals("Alteration")){
                String substring = arr[1];
                if(spell.toString().contains(substring)){
                    spell = new StringBuilder(spell.toString().replaceAll(substring,""));
                    System.out.println(spell);
                } else {
                    System.out.println("The spell did not work!");
                }
            }
            else {
                System.out.println("The spell did not work!");
            }

            command = scanner.nextLine();
        }

    }
}
