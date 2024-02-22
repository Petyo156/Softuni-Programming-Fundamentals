/*import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_SoftuniCourses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> topics = Arrays.stream(scanner.nextLine()
                        .split(", "))
                        .collect(Collectors.toList());

        String command=scanner.nextLine();

        String[] arr = command.split(":");

        while (!command.equals("course start")){
            if(command.contains("Add")) {
                Add(topics,arr);
            }
            else if(command.contains("Insert")) {
                Insert(topics,arr);
            }
            else if(command.contains("Remove")) {
                Remove(topics,arr);
            }
            else if(command.contains("Swap")) {
                Swap(topics,arr);
            }
            else if(command.contains("Exercise")) {
                Exercise(topics,arr);
            }
            command=scanner.nextLine();
        }
        int number = 1;
        for (String topic:topics) {
            System.out.println(number+"."+topic);
            number++;
        }
    }
    public static void Add(List<String> topics,String[] arr){
        if(!topics.contains(arr[1])){
            topics.add(arr[1]);
        }
    }
    public static void Insert(List<String> topics,String[] arr){
        if(!topics.contains(arr[1])){
            topics.add(Integer.parseInt(arr[2]),arr[1]);
        }
    }
    public static void Remove(List<String> topics,String[] arr){
        if(topics.contains(arr[1])){
            topics.remove(arr[1]);
            topics.remove(arr[1] + "-Exercise");
        }
    }
    public static void Swap(List<String> topics,String[] arr){
        if(topics.contains(arr[1])&&topics.contains(arr[2])){
            int indexForFirst = topics.indexOf(arr[1]);
            int indexForSecond = topics.indexOf(arr[2]);

            String topic1 = arr[1];
            String topic2 = arr[2];

            String topic1Exercise = arr[1]+"-Exercise";
            String topic2Exercise = arr[2]+"-Exercise";

            topics.set(indexForFirst, topic2);
            topics.set(indexForSecond, topic1);

            if(topics.contains(topic1Exercise)){
                topics.remove(topic1Exercise);
                topics.add(indexForFirst + 1, topic1Exercise);
            }
            if(topics.contains(topic2Exercise)){
                topics.remove(topic2Exercise);
                topics.add(indexForSecond+1,topic2Exercise);
            }
        }
    }
    public static void Exercise(List<String> topics,String[] arr){
        if(topics.contains(arr[1])){
            int indexTopic = topics.indexOf(arr[1]);
            if(indexTopic==topics.size()-1){
                topics.add(arr[1]+"-Exercise");
            }
            else if(!topics.get(indexTopic+1).equals(arr[1]+"-Exercise")) {
                topics.add(indexTopic + 1, arr[1] + "-Exercise");
            }
        } else{
            topics.add(arr[1]);
            topics.add(arr[1]+"-Exercise");
        }
    }
}
*/
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_SoftuniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> topics = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("course start")) {

            String [] commandParts = command.split(":");
            String commandName = commandParts[0];
            String topic = commandParts[1];

            switch (commandName) {
                case "Add":

                    if (!topics.contains(topic)) {
                        topics.add(topic);
                    }
                    break;
                case "Insert":

                    int indexForInsert = Integer.parseInt(commandParts[2]);
                    if (!topics.contains(topic)) {
                        topics.add(indexForInsert, topic);
                    }
                    break;
                case "Remove":

                    if (topics.contains(topic)) {
                        int topicIndex = topics.indexOf(topic);
                        String exerciseName = topic + "-Exercise";
                        boolean hasExercise = topicIndex != topics.size() - 1 && topics.get(topicIndex + 1).equals(exerciseName);

                        topics.remove(topic);

                        if (hasExercise) {
                            topics.remove(exerciseName);
                        }
                    }

                    break;
                case "Swap":

                    String topic2 = commandParts[2];

                    if (topics.contains(topic) && topics.contains(topic2)) {

                        int indexFirst = topics.indexOf(topic);
                        int indexSecond = topics.indexOf(topic2);

                        topics.set(indexSecond, topic);
                        topics.set(indexFirst, topic2);

                        String exFirstTopic = topic + "-Exercise";
                        String exSecondTopic = topic2 + "-Exercise";

                        if (topics.contains(exFirstTopic)) {
                            topics.remove(exFirstTopic);
                            topics.add(topics.indexOf(topic) + 1, exFirstTopic);
                        }

                        if (topics.contains(exSecondTopic)) {
                            topics.remove(exSecondTopic);
                            topics.add(topics.indexOf(topic2) + 1, exSecondTopic);
                        }
                    }
                    break;
                case "Exercise":

                    String exerciseName = topic + "-Exercise";

                    if (topics.contains(topic)) {

                        int indexTopic = topics.indexOf(topic);

                        if (indexTopic == topics.size() - 1) {

                            topics.add(exerciseName);

                        }

                        else if (!topics.get(indexTopic + 1).equals(exerciseName)) {

                            topics.add(indexTopic + 1, exerciseName);
                        }
                    } else {

                        topics.add(topic);
                        topics.add(exerciseName);
                    }

                    break;

            }

            command = scanner.nextLine();
        }

        int number = 1;
        for (String topic : topics) {
            System.out.println(number + "." + topic);
            number++;
        }
    }
}