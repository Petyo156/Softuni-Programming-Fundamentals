import java.util.Scanner;

public class _11_Rage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());

        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countHeadset = 0; //бр. слушалки
        int countMouse = 0; //бр. мишки
        int countKeyboard = 0; //бр. калвиатури
        int countDisplay = 0; //бр. монитори

        for (int i = 1; i <= lostGames; i++)
        {
            if (i % 2 == 0)
            {
                countHeadset++;
            }
            if (i % 3 == 0) {
                countMouse++;
            }
            if (i % 6 == 0) {
                countKeyboard++;
            }
            if (i % 12 == 0) {
                countDisplay++;
            }
        }
        double totalPrice = (countHeadset * headsetPrice)
                + (countMouse * mousePrice)
                + (countKeyboard * keyboardPrice)
                + (countDisplay * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}
