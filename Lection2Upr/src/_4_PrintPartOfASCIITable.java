import java.util.Scanner;

public class _4_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        for(int i=n;i<=m;i++)
        {
            System.out.print((char) i+" ");
        }
    }
}
