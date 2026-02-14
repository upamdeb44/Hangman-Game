import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//      String word = "subway";
        String[] words = {"subway","coffee","chainsmokers","cinderella"};
        Random rand = new Random();
        String word = words[rand.nextInt(words.length)];
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;
        boolean gameRunning = true;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("welcome to HangMan....bitches\n");

        while (gameRunning) {
            // display hangman + word
            System.out.println(getHangmanArt(wrongGuesses));

            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            boolean correctGuess = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    wordState.set(i, guess);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                wrongGuesses++;
            }

            // win condition
            if (!wordState.contains('_')) {
                System.out.println("You win! 🎉");
                gameRunning = false;
            }

            // lose condition
            if (wrongGuesses >= 6) {
                System.out.println(getHangmanArt(wrongGuesses));
                System.out.println("You lost 💀 The word was: " + word);
                gameRunning = false;
            }
        }

        sc.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                      
                      
                      
                      """;
            case 1 -> """
                       o
                      
                      
                      """;
            case 2 -> """
                       o
                       |
                      
                      """;
            case 3 -> """
                       o
                      /|
                    
                      """;
            case 4 -> """
                       o
                      /|\\
                    
                      """;
            case 5 -> """
                       o
                      /|\\
                      /
                      """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;
            default -> "";
        };
    }
}
