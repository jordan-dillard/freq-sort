import java.util.ArrayList;
import java.util.Scanner;

public class TestDriver {

    public static void main(String[] args){
        ArrayList<String> input = parseInput();
        FreqSorter freqSorter = new FreqSorter(input);
        freqSorter.printByDescendingOrder();
    }

    public static ArrayList<String> parseInput(){
        ArrayList<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) input.add(scanner.nextLine());
        return input;
    }
}
