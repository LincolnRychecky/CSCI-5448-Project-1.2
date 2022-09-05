import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    public void readAnalyze(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter real numbers one at a time. When done press enter with an empty input: ");
        String inputValue = input.nextLine();
        ArrayList<Double> inputNumbers = new ArrayList<>(); // Create an ArrayList object to store input
        while(!inputValue.equals("")){
            inputNumbers.add(Double.parseDouble(inputValue));
            System.out.println("Enter another real number: ");
            inputValue = input.nextLine();
        }
        System.out.println("Input complete. Null value entered");
        Analyzer a = new Analyzer();
        a.analyze(inputNumbers);
    }
}
