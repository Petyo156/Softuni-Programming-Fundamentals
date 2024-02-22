import java.util.*;

public class _5_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> courses = new LinkedHashMap<>();
        Map<String, List<String>> students = new LinkedHashMap<>();

        String command = scanner.nextLine();
        //"{courseName} : {studentName}"
        while(!command.equals("end")){
            String courseName = command.split(" : ")[0];
            String studentName = command.split(" : ")[1];

            if(courses.containsKey(courseName)) {
                int num = courses.get(courseName);
                courses.put(courseName, num+1);
            }
            else {
                courses.put(courseName, 1);
            }

            if (!students.containsKey(courseName)) {
                students.put(courseName, new ArrayList<>()); // Инициализирайте списъка, ако все още не съществува
            }
            students.get(courseName).add(studentName);

            command = scanner.nextLine();
        }

        courses.entrySet().forEach(entry ->{
            System.out.println(entry.getKey()+": "+entry.getValue());
            students.get(entry.getKey()).forEach(student -> System.out.println("-- " + student));
        });
    }
}
