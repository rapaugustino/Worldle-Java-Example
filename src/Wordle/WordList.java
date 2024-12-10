package Wordle;

import java.util.*;

/**
 * The WordList class is responsible for managing a collection of words
 * and providing functionality to randomly select a word from the list.
 */
public class WordList {
    // Set to store unique words
    private Set<String> words;
    // Random object for generating random numbers
    private Random random;

    /**
     * Constructs a new WordList with the provided list of words.
     * Initializes the words in a Set to ensure uniqueness and
     * sets up a Random object for selecting random words.
     *
     * @param words List of words to be included in the WordList.
     */
    public WordList(List<String> words) {
        // Initializing the set of words from the provided list
        this.words = new HashSet<>(words);
        // Initializing the Random object
        this.random = new Random();
    }

    /**
     * Returns a random word from the list of words.
     * The word is selected using a Random object to ensure
     * unbiased randomness from the set of words.
     *
     * @return A randomly selected word from the WordList.
     */
    public String getRandomWord(){
        // Convert Set to List for random access
        List<String> wordsList = new ArrayList<>(words);
        // Return a random word from the list
        return wordsList.get(random.nextInt(wordsList.size()));
    }
}
