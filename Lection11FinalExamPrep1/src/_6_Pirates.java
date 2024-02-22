import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();

        int cityCount = 0;
        String command = scanner.nextLine();
        while(!command.equals("Sail")){
            String[] arr = command.split("\\|\\|");
            String city = arr[0];
            int population = Integer.parseInt(arr[1]);
            int gold = Integer.parseInt(arr[2]);
            if(cityGold.containsKey(city)){
                int goldToAdd = gold+cityGold.get(city);
                int populationToAdd = population+cityPopulation.get(city);

                cityGold.put(city,goldToAdd);
                cityPopulation.put(city,populationToAdd);
            }
            else {
                cityPopulation.put(city, population);
                cityGold.put(city, gold);
                cityCount++;
            }
            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while(!command.equals("End")){
            //"Plunder=>{town}=>{people}=>{gold}"
            //"Prosper=>{town}=>{gold}"
            String[] arr = command.split("=>");
            String action = arr[0];
            String city = arr[1];

            if(action.equals("Plunder")){
                int people = Integer.parseInt(arr[2]);
                int gold = Integer.parseInt(arr[3]);
                //"{town} plundered! {gold} gold stolen, {people} citizens killed."

                int currentGold = cityGold.get(city)-gold;
                cityGold.put(city,currentGold);

                int currentPeople = cityPopulation.get(city)-people;
                cityPopulation.put(city,currentPeople);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                if(cityGold.get(city)==0||cityPopulation.get(city)==0){
                    cityGold.remove(city);
                    cityPopulation.remove(city);
                    cityCount--;
                    System.out.printf("%s has been wiped off the map!%n",city);
                }

            } else if(action.equals("Prosper")) {
                int gold = Integer.parseInt(arr[2]);
                if(!(gold<0)){
                    //"{gold added} gold added to the city treasury. {town} now has {total gold} gold."
                    int currentGold = cityGold.get(city)+gold;
                    cityGold.put(city,currentGold);

                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",gold,city,currentGold);
                } else {
                    System.out.println("Gold added cannot be a negative number!");
                }
            }
            command = scanner.nextLine();
        }

        if(!cityPopulation.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityCount);
            for (String town : cityGold.keySet()) {
                //{town1} -> Population: {people} citizens, Gold: {gold} kg
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, cityPopulation.get(town), cityGold.get(town));
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
