package dev.m3s.programming2.homework4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordList {
	private List<String> words = new ArrayList<>();
		
	public WordList(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				words.add(word.toLowerCase());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
		}
	}
	
	public List<String> giveWords(){
		return words;
	}
}
