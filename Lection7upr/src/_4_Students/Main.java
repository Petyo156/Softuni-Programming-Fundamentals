package _4_Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();
        for(int i=0;i<n;i++){
            String command = scanner.nextLine();
            String firstName = command.split(" ")[0];
            String secondName = command.split(" ")[1];
            double grade = Double.parseDouble(command.split(" ")[2]);
            Student student = new Student(firstName,secondName,grade);
            studentList.add(student);
        }
        Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student student:studentList) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getSecondName(), student.getGrade());
        }
    }
}
