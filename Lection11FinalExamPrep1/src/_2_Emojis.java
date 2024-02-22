import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_Emojis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Pattern coolThresholdpattern = Pattern.compile("[0-9]");
        Matcher coolThresholdmatcher = coolThresholdpattern.matcher(input);

        long coolThreshold = 1;
        while(coolThresholdmatcher.find()){
            String digit = coolThresholdmatcher.group();
            coolThreshold*=Integer.parseInt(digit);
        }

        System.out.printf("Cool threshold: %d",coolThreshold);



        Pattern patternEmoji = Pattern.compile("(::|\\*\\*)([A-Z][a-z]{2,})\\1");
        Matcher matcherEmoji = patternEmoji.matcher(input);

        List<String> emojis= new ArrayList<>();
        while(matcherEmoji.find()) {
            String emoji = matcherEmoji.group();
            emojis.add(emoji);
        }

        System.out.printf("%n%d emojis found in the text. The cool ones are:%n",emojis.size());

        for (String emoji: emojis) {
            char[] chars = emoji.toCharArray();

            int coolness = 0;

            for (int i=2; i<chars.length-2; i++) {
                coolness+=chars[i];
            }
            if(coolThreshold<coolness) {
                System.out.println(emoji); //+ " - " + coolness);
            }
        }
    }
}
