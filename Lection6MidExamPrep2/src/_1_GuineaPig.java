import java.util.Scanner;

public class _1_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        for(int i=1; i<=30; i++)
        {
            food-=0.3;
            if(i%2==0){
                hay-=0.05*food;
            }
            if(i%3==0){
                cover-=weight*(1.0/3);
            }
            if(food<0||hay<0||cover<0){
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",food,hay,cover);
    }
}
