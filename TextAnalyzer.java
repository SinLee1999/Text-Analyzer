package com.sinlee.textanalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * A simple text analysis program that reads a file, counts total and unique words and letters,
 * calculates word frequencies, finds the longest word, and displays the most frequent words.
 */
public class TextAnalyzer {
	public static void main(String[] args) {
		Scanner scan = null;

		try {
			File f = new File("data.txt");//user can change the file as long as they update their name of the file here
			scan = new Scanner(f);

			Map<String, Integer> map = new HashMap<>();
			
			int totalCount = countWords(scan, map);

			String longestWord = findLongestWord(map);

			printTopFrequentWords(map, 4);

			System.out.println("Total words = " + totalCount);
			System.out.println("Unique words = " + map.size());
			System.out.println("Longest word = " + longestWord);
			countLetters(map);

		} catch (FileNotFoundException e) {//Handle the error when file is not found
			System.err.println("File not found");
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
	}

	/**
	 *The map gets updated and change remains
	 *
	 * @param scan Scanner that's reading the input text
	 * @param map Storing word frequencies. (key/value, word/count)
	 * @return total count of words
	 */
	public static int countWords(Scanner scan, Map<String, Integer> map) {
		int totalCount = 0;

		while (scan.hasNext()) {//next token exist
			String word = scan.next().toLowerCase().replaceAll("[^a-z]", "");//remove any special characters (that are not letters)

			if(!word.isEmpty()) {//skip if it only contains special cases
			totalCount++;//count the words
			map.put(word, map.getOrDefault(word, 0) + 1);//Count the frequencies of the words
			}
		}
		return totalCount;
	}
	
	/**
	 * Finds and returns the longest word from the given word frequency map.
	 * @param map 
	 * @return the longest word found from the map
	 */
	public static String findLongestWord(Map<String, Integer> map) {
		String longestWord = "";  
		int longest = 0;

		for (String word : map.keySet()) {
			if (word.length() > longest) {//If the length of current word is longer
				longest = word.length(); //Update longest to current word
				longestWord = word; // Update the longest word
			}
		}
		return longestWord;
	}
	
	/**
	 * This method sorts in descending order 
	 * @param map
	 * @param n - top frequent n'th
	 */
	public static void printTopFrequentWords(Map<String, Integer> map, int n) {
	
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		list.sort((a, b) -> b.getValue() - a.getValue());

		System.out.printf("Top %d most frequent words \n", n);
		for (int i = 0; i < Math.min(n, list.size()); i++) {//Just in case n is less than the list
			Map.Entry<String, Integer> entry = list.get(i);
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
		System.out.println();
	}
	
	public static void countLetters(Map<String, Integer> map) {
		Map<Character, Integer> letterMap = new HashMap<>();
		for(Entry <String, Integer> c : map.entrySet()){
			
			for(int i = 0; i < c.getKey().length(); i++) {
				letterMap.put(c.getKey().charAt(i), letterMap.getOrDefault(c.getKey().charAt(i), 0) + 1);
			}
		}
		
		System.out.println("\nCounting Letters");
		for(Entry <Character, Integer> c : letterMap.entrySet()) {
			System.out.printf("%c => %d ", c.getKey(), c.getValue());
		}
	}
}
