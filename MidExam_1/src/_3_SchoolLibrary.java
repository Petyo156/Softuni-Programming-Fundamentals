import java.util.List;
import java.util.Scanner;

public class _3_SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shelf = scanner.nextLine();
        List<String> bookshelf = new java.util.ArrayList<>(List.of(shelf.split("&")));

        String commandForBooks = scanner.nextLine();
        while(!commandForBooks.equals("Done")){
            String[] arr = commandForBooks.split("\\s\\|\\s");
            String action = arr[0];
            String book = arr[1];
            switch (action){
                case "Add Book":
                    if(!bookshelf.contains(book)){
                        bookshelf.add(0,book);
                    }
                    break;
                case "Take Book":
                    bookshelf.remove(book);
                    break;
                case "Swap Books":
                    String bookSecond = arr[2];
                    if(bookshelf.contains(book)&&bookshelf.contains(bookSecond)){
                        int bookOneIndex = bookshelf.indexOf(book);
                        int bookTwoIndex = bookshelf.indexOf(bookSecond);
                        bookshelf.set(bookOneIndex, bookSecond);
                        bookshelf.set(bookTwoIndex, book);
                    }
                    break;
                case "Insert Book":
                    if(!bookshelf.contains(book)){
                        bookshelf.add(book);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(book);
                    int sizeOfBookshelf = bookshelf.size();
                    if (index >= 0 && index < sizeOfBookshelf) {
                        System.out.println(bookshelf.get(index));
                    }
                    break;
                }

            commandForBooks = scanner.nextLine();
        }
        for (int i = 0; i < bookshelf.size(); i++) {
            if(i==bookshelf.size()-1){

                System.out.print(bookshelf.get(i));
            }
            else {
                System.out.print(bookshelf.get(i)+", ");
            }
        }
    }
}
