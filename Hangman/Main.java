package dev.m3s.programming2.homework4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordList wordList = new WordList("words.txt");
        Hangman hangman = new Hangman(wordList, 8);
        
        System.out.println("Welcome to Hangman!");
        
        while (!hangman.theEnd()) {
            System.out.println("Guesses left: " + hangman.guessesLeft());
            System.out.println("Guessed letters: " + hangman.guesses());
            
            String maskedWord = "";
            for (int i = 0; i < hangman.word().length(); i++) {
                char letter = hangman.word().charAt(i);
                if (hangman.guesses().contains(letter)) {
                    maskedWord += letter;
                }
                else {
                    maskedWord += "*";
                }
            }
            System.out.println("The hidden word...");
            System.out.println(maskedWord);
            
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine();
            while (true) {
            	if (input.length() != 1) {
            		System.out.println("Please enter only one letter!");
                	System.out.println("Guess a letter: ");
                	input = scanner.nextLine();
            	}
                if (hangman.guesses().contains(input.charAt(0))) {
                	System.out.println("You have already guessed that letter!");
                	System.out.println("Guess a letter: ");
                	input = scanner.nextLine();
                	}
                else {
                	break;
                	}
            	}
            	char guess = input.charAt(0);
            hangman.guess(guess);
        }
        
        if (hangman.guessesLeft() > 0) {
            System.out.println("Congratulations! You won!!!");
            System.out.println("The hidden word was: " + hangman.word());
        }
        else {
        	System.out.println("Sorry, you lost!");
            System.out.println("The hidden word was:" + hangman.word());
        }
        scanner.close();
    }
}
