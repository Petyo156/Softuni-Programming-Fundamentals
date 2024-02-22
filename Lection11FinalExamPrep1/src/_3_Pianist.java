import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _3_Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> composerByPiece= new LinkedHashMap<>();
        Map<String, String> keyByPiece = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n; i++){
            //"{piece}|{composer}|{key}".
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            composerByPiece.put(composer,key);
            keyByPiece.put(piece, key);
        }
        String input = scanner.nextLine();
        while(!input.equals("Stop")){
            String[] commandArgs = input.split("\\|");
            String command = commandArgs[0];
            switch (command){
                case "Add":
                    String newPiece = commandArgs[1];
                    String newComposer = commandArgs[2];
                    String newKey = commandArgs[3];

                    if (keyByPiece.containsKey(newPiece)) {
                        System.out.printf("%n%s is already in the collection!", newPiece);
                    } else {
                        keyByPiece.put(newPiece, newKey);
                        composerByPiece.put(newPiece, newComposer);
                        System.out.printf("%n%s by %s in %s added to the collection!", newPiece, newComposer, newKey);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = commandArgs[1];

                    if (keyByPiece.containsKey(pieceToRemove)) {
                        keyByPiece.remove(pieceToRemove);
                        composerByPiece.remove(pieceToRemove);
                        System.out.printf("%nSuccessfully removed %s!", pieceToRemove);
                    } else {
                        System.out.printf("%nInvalid operation! %s does not exist in the collection.", pieceToRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceToChange = commandArgs[1];
                    String newKeyy = commandArgs[2];

                    if (keyByPiece.containsKey(pieceToChange)) {
                        String oldComposer = composerByPiece.get(pieceToChange);
                        keyByPiece.put(pieceToChange, newKeyy);
                        composerByPiece.put(pieceToChange, oldComposer);
                        System.out.printf("%nChanged the key of %s to %s!", pieceToChange, newKeyy);
                    } else {
                        System.out.printf("%nInvalid operation! %s does not exist in the collection.", pieceToChange);
                    }
                    break;
            }
            input=scanner.nextLine();
        }
        //"{Piece} -> Composer: {composer}, Key: {key}"
        //for(int i = 0; i<keyByPiece.size(); i++){
         //   keyByPiece.get()
        //}
        for(String piece : composerByPiece.keySet()){
            String compose = composerByPiece.get(piece);
            String key = keyByPiece.get(piece);

            System.out.printf("%n%s -> Composer: %s, Key: %s",piece,compose,key);
        }
    }
}
