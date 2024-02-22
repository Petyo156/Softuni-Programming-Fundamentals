import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> students = new LinkedHashMap<>();

        int numOfStudents = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i<numOfStudents; i++){
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if(students.containsKey(name)){
                double gradeToPut = (students.get(name)+grade)/2;
                students.put(name, gradeToPut);
            } else {
                students.put(name, grade);
            }
        }
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            if(entry.getValue()>=4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
