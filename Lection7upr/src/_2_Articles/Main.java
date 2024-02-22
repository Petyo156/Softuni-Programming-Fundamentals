package _2_Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split(", ");

        String title = arr[0];
        String content = arr[1];
        String author = arr[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<n; i++){
            String[] command = scanner.nextLine().split(": ");
            switch (command[0]){
                case "Edit":
                    article.setContent(command[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(command[1]);
                    break;
                case "Rename":
                    article.setTitle(command[1]);
                    break;
            }
        }
        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}