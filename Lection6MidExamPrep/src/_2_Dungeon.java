import java.util.Arrays;
import java.util.Scanner;

public class _2_Dungeon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;

        String dungeonRooms = scanner.nextLine();
        String[] arr = dungeonRooms.split("\\|");

        for (int i = 0; i < arr.length; i++) {
            String[] room = arr[i].split(" ");
            String command = room[0];
            int number = Integer.parseInt(room[1]);

            if(command.equals("potion")){
                int healedAmount;
                if(health+number>100)
                {
                    healedAmount = 100-health;
                    health=100;
                }
                else{
                    healedAmount = number;
                    health+=number;
                }
                System.out.println("You healed for "+healedAmount+" hp.");
                System.out.printf("Current health: %d hp.%n", health);
            }
            else if(command.equals("chest")){
                bitcoins+=number;
                System.out.printf("You found %d bitcoins.%n", number);
            }
            else {
                health -= number;
                if(health>0){
                    System.out.printf("You slayed %s.%n", command);
                }
            }

            if(health<=0){
                System.out.printf("You died! Killed by %s.%n",command);
                System.out.printf("Best room: %d%n",i+1);
                return;
            }
        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d",bitcoins,health);
    }
}
