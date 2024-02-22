import java.util.Scanner;

public class _10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int N_OriginalValue = N;
        int count = 0;
        while(N>=M)
        {
            N-=M;
            count++;
            if(N==N_OriginalValue/2){
                if(Y!=0){
                    N=N/Y;
                }
            }
        }
        System.out.printf("%d%n%d",N,count);
    }
}
