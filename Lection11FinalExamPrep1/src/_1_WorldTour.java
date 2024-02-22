import java.util.Scanner;

public class _1_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destinations = scanner.nextLine();

        String input = scanner.nextLine();
        while (true){
            if(input.equals("Travel")){
                System.out.printf("Ready for world tour! Planned stops: %s",destinations);
                break;
            }
            String command = input.split(":")[0];
            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String name = input.split(":")[2];

                    if(indexIsValid(index, destinations)) {
                        String left = destinations.substring(0, index);
                        String right = destinations.substring(index);

                        destinations = left+name+right;
                    }
                    System.out.println(destinations);
                    break;
                case "Remove Stop":
                    int indexForStart = Integer.parseInt(input.split(":")[1]);
                    int indexForEnd = Integer.parseInt(input.split(":")[2]);

                    if(indexIsValid(indexForStart, destinations)&&indexIsValid(indexForEnd,destinations)) {

                        String left = destinations.substring(0, indexForStart);
                        String right = destinations.substring(indexForEnd+1);

                        destinations = left+right;
                    }
                    System.out.println(destinations);
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];

                    destinations = destinations.replace(oldString,newString);
                    System.out.println(destinations);
                    break;
            }


            input = scanner.nextLine();
        }
    }

    private static boolean indexIsValid(int index, String string) {
        if(index>=0&&index<string.length()){
            return true;
        }
        return false;
    }
}
