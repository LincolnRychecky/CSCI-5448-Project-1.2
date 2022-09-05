import java.util.Scanner;
import java.util.Arrays;

public class Processor {
    private String inputWord;

    public void Read(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string of valid alphabet characters. Enter empty string to confirm: ");
        String inputValue = input.nextLine();
        System.out.println("Input complete.");
        if(!inputValue.equals("")){
            System.out.println(Palindrome(inputValue));
        } else{
            System.out.println("Exit program. Empty string input.");
        }
    }

    // converts all letters of input string to upper case and removes all spaces from input string
    public String Clean(String input){
        return input.toUpperCase().replaceAll("\\s", "");
    }

    // sorts the letters of the string into alphabetical order
    // sort strategy borrowed from: https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
    public String Sort(String input){
        // convert the input into a char array so that java natural sort can be used. From there
        // we convert the array of chars to a string and return the value.
        char temp[] = input.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    // take an input string, clean it, sort it, and then create a palindrome from the letters
    public String Palindrome(String input){
        String letters = Clean(input);
        letters = Sort(letters);
        // take the first character to initialize the palindrome string.
        // from here, each of the remaining letters will be appended to the beginning and end of the
        // palindrome string.
        String palindrome = Character.toString(letters.charAt(0));
        for(int i = 1; i < letters.length(); i++){
            palindrome = letters.charAt(i) + palindrome + letters.charAt(i);
        }
        return palindrome;
    }



}
