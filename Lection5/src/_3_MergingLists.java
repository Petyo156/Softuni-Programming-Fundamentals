import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstSeq = scanner.nextLine().split(" ");
        String[] secondSeq = scanner.nextLine().split(" ");

        List<String> result = new ArrayList<>();

        int firstSeqIdx = 0;
        int secondSeqIdx = 0;
        boolean isFirstSeqTurn = true;

        while (firstSeqIdx>=0 && firstSeqIdx<firstSeq.length && secondSeqIdx>=0 && secondSeqIdx<secondSeq.length){
            if(isFirstSeqTurn){
                result.add(firstSeq[firstSeqIdx]);
                firstSeqIdx++;
                isFirstSeqTurn=false;
            }
            else{
                result.add(secondSeq[secondSeqIdx]);
                secondSeqIdx++;
                isFirstSeqTurn=true;
            }
        }

        for (int i = firstSeqIdx; i<firstSeq.length; i++){
            result.add(firstSeq[i]);
        }
        for (int i = secondSeqIdx; i<secondSeq.length; i++){
            result.add(secondSeq[i]);
        }

        for (String element : result){
            System.out.printf(element+" ");
        }
    }
}
