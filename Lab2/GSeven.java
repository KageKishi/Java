import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class GSeven {
    public static void main(String args[]) {
        int spaces = 0;
        int consonants = 0;
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a Sentence: ");
        text = sc.nextLine();
        sc.close();
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        for (char c : text.toLowerCase().toCharArray()) {
            if (vowels.containsKey(c)) {
                vowels.put(c, vowels.get(c) + 1);
            } else if (c == ' ') {
                spaces++;
            } else {
                consonants++;
            }
        }
        System.out.println("Vowel counts: " + vowels);
        System.out.println("Space count: " + spaces);
        System.out.println("Consonant count: " + consonants);
    }
}
