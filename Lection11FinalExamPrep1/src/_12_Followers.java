import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _12_Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> likesFollower = new LinkedHashMap<>();
        Map<String, Integer> commentsFollower = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Log out")){
            String[] arr = command.split(": ");
            String mainCommand = arr[0];
            String username = arr[1];

            if(mainCommand.equals("New follower")){
                if(!likesFollower.containsKey(username)) {
                    likesFollower.put(username, 0);
                    commentsFollower.put(username, 0);
                }
            }
            else if(mainCommand.equals("Like")){
                int count = Integer.parseInt(arr[2]);

                if(!likesFollower.containsKey(username)){
                    likesFollower.put(username, count);
                    commentsFollower.put(username, 0);
                } else {
                    likesFollower.put(username, likesFollower.get(username)+count);
                }
            }
            else if(mainCommand.equals("Comment")){
                if(!likesFollower.containsKey(username)){
                    commentsFollower.put(username, 1);
                    likesFollower.put(username, 0);
                } else {
                    commentsFollower.put(username, commentsFollower.get(username)+1);
                }
            }
            else if(mainCommand.equals("Blocked")){
                if(!likesFollower.containsKey(username)){
                    System.out.printf("%s doesn't exist.%n",username);
                } else {
                    commentsFollower.remove(username);
                    likesFollower.remove(username);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(likesFollower.size()+ " followers");
        for (String follower: likesFollower.keySet()) {
            int likesAndComments =likesFollower.get(follower)+commentsFollower.get(follower);
            System.out.println(follower + ": " + likesAndComments);
        }
    }
}
