import java.lang.reflect.Array;
import java.util.*;

public class _8_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companiesInfo = new LinkedHashMap<>();
        String companyNameAndID = scanner.nextLine();
        while(!companyNameAndID.equals("End")){
            String[] arr = companyNameAndID.split(" -> ");
            String companyName = arr[0]; String ID = arr[1];

            if(companiesInfo.containsKey(companyName)){
                List<String> currentList = companiesInfo.get(companyName);
                if(!currentList.contains(ID)){
                    companiesInfo.get(companyName).add(ID);
                }
            } else {
                companiesInfo.put(companyName, new ArrayList<>());
                companiesInfo.get(companyName).add(ID);
            }
            companyNameAndID = scanner.nextLine();
        }
        companiesInfo.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(employee -> System.out.println("-- "+employee));
        });
    }
}
