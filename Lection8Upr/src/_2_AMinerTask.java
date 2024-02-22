import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _2_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Long> resources = new LinkedHashMap<>();

        String resource = scanner.nextLine();
        while (!resource.equals("stop")){
            long quantity = Long.parseLong(scanner.nextLine());
            if(!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            }
            else{
                resources.put(resource, resources.get(resource) + quantity);
            }
            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
