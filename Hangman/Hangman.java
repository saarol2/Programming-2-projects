package dev.m3s.programming2.homework4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
	private WordList wordList;
	private String word;
	private int guessesLeft;
	private List<Character> guesses;
	
	public Hangman(WordList wordList, int maxGuesses) {
        this.wordList = wordList;
        this.guessesLeft = maxGuesses;
        this.guesses = new ArrayList<>();
        this.word = selectWord();
    }
	
	private String selectWord() {
        Random random = new Random();
        List<String> words = wordList.giveWords();
        int n = random.nextInt(words.size());
        return words.get(n);
    }

	
	public boolean guess(Character c) {
		c = Character.toLowerCase(c);
		boolean isCorrect = false;
		for (int i = 0; i < word.length(); i++) {
			if (Character.toLowerCase(word.charAt(i)) == c) {
				isCorrect = true;
			}
		}
		guesses.add(c);
		if (!isCorrect) {
			guessesLeft--;
		}
		return isCorrect;
	}
	
	public List<Character> guesses() {
		List<Character> onlyGuesses = new ArrayList<>();
        for (Character c : guesses) {
            if (!onlyGuesses.contains(c)) {
            	onlyGuesses.add(c);
            }
        }
        return onlyGuesses;
    }
	
	public int guessesLeft() {
		return guessesLeft;
	}
	public String word() {
		return word;
	}
	public boolean theEnd() {
		for (int i = 0; i < word.length(); i++) {
            if (!guesses.contains(word.charAt(i)) && guessesLeft > 0) {
                return false;
            }
        }
        return true;
    }
}
