import java.util.Scanner;

public class _4_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder encription = new StringBuilder(input);


        while(!input.equals("Reveal")){
            String[] arr = input.split(":\\|:");
            String command = arr[0];

            if(command.equals("InsertSpace")){
                int index = Integer.parseInt(arr[1]);
                encription.insert(index, " ");

                System.out.println(encription);
            }
            else if(command.equals("Reverse")){
                String substring = arr[1];
                if(encription.toString().contains(substring)){
                    int indexOfSubstring = encription.indexOf(substring);
                    encription.delete(indexOfSubstring, indexOfSubstring+substring.length()+1);

                    String textToAdd = new StringBuilder(substring).reverse().toString();

                    encription.append(textToAdd);

                    System.out.println(encription);
                } else {
                    System.out.println("error");
                }
            }
            else if(command.equals("ChangeAll"))
            {
                String substring = arr[1];
                String replacement = arr[2];

                encription  = new StringBuilder(encription.toString().replaceAll(substring,replacement));
                System.out.println(encription);
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + encription);
    }
}

//On the first line of the input, you will receive the concealed message. After that, until the "Reveal"
// command is given, you will receive strings with instructions for different operations that need to be performed
// upon the concealed message to interpret it and reveal its actual content. There are several types of instructions,
// split by ":|:"
//
//· "InsertSpace:|:{index}":
//
//o Inserts a single space at the given index.
// The given index will always be valid.
//
//· "Reverse:|:{substring}":
//
//o If the message contains the given substring, cut it out,
// reverse it and add it at the end of the message.
//
//o If not, print "error".
//
//o This operation should replace only the first occurrence of the given substring
// if there are two or more occurrences.
//
//· "ChangeAll:|:{substring}:|:{replacement}":
//
//o Changes all occurrences of the given substring with the replacement text