import java.util.Scanner;
import java.util.Random;

public class _1_AdMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] phrases = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};
        String[] events = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};
        String[] authors = {"Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"};
        String[] cities = {"Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"};

        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n; i++){
            Random random = new Random();
            int randomPhrase = random.nextInt(5);
            String phrase = phrases[randomPhrase];

            int randomEvent = random.nextInt(5);
            String event = events[randomEvent];

            int randomAuthor = random.nextInt(7);
            String author = authors[randomAuthor];

            int randomCity = random.nextInt(4);
            String city = cities[randomCity];

            System.out.printf("%s %s %s – %s%n",phrase,event,author,city);
        }

    }
}
