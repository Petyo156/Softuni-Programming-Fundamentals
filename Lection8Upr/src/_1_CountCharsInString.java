import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _1_CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character,Integer> symbolsCount = new LinkedHashMap<>();
        for (char sym : input.toCharArray()) {
            if(sym==' '){
                continue;
            }
            else if(!symbolsCount.containsKey(sym)){
                symbolsCount.put(sym, 1);
            }
            else {
                int countInMap = symbolsCount.get(sym);
                symbolsCount.put(sym, countInMap+1);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        //symbolsCount.forEach((key, value) -> System.out.println(value + " -> " + key));
    }
}
