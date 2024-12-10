package Wordle;

import java.util.Arrays;
import java.util.List;

/**
 * The Attempt class represents a single guess attempt in the Wordle game.
 * It manages the user's guess, provides utilities for checking correctness,
 * and generates feedback indicating which characters are correctly placed, present
 * in the word, or incorrect.
 */
public class Attempt {
    // Fields related to the guess and feedback
    protected String guess; // The player's current guess
    private final StringBuilder[] guessFeedback = new StringBuilder[5]; // Feedback for each guess position
    private List<CharacterFeedback> feedback; // Feedback objects for detailed analysis

    /**
     * Constructs an Attempt with a specified guess and the secret word to be matched against.
     *
     * @param guess The player's guess word.
     * @param secretWord The secret word to evaluate the guess against.
     */
    public Attempt(String guess, String secretWord) {
        setGuess(guess);
    }

    /**
     * Checks if the guess is identical to the secret word, indicating a correct guess.
     *
     * @param secretWord The secret word that the guess is being compared to.
     * @return True if the guess matches the secret word perfectly, false otherwise.
     */
    public boolean isCorrect(String secretWord) {
        return guess.equals(secretWord);
    }

    /**
     * Sets the player's guess.
     *
     * @param guess The guess word set by the player.
     */
    public void setGuess(String guess) {
        this.guess = guess;
    }

    /**
     * Returns the current guess being evaluated.
     *
     * @return The current guess as a string.
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Generates visual feedback for the player's guess against the secret word.
     * Characters in the correct position are colored green, those present in the word
     * but mispositioned are colored yellow, and incorrect characters are left uncolored.
     *
     * @param guess The player's guess to evaluate.
     * @param secretWord The correct word to compare against.
     * @return An array of strings representing the feedback for each character in the guess.
     */
    public String[] generateFeedback(String guess, String secretWord) {
        String[] feedback = new String[5];
        boolean[] used = new boolean[5]; // Tracks letters in the secret word already matched

        String green = "\033[32m"; // ANSI code for green text
        String yellow = "\033[93m"; // ANSI code for yellow text
        String reset = "\033[0m";   // ANSI code to reset text color

        // First pass: Identify characters with correct positions
        for (int i = 0; i < 5; i++) {
            char currentChar = guess.charAt(i);
            if (currentChar == secretWord.charAt(i)) {
                feedback[i] = green + currentChar + reset;
                used[i] = true; // Mark character in the secret word as used
            }
        }

        // Second pass: Identify characters that are present but mispositioned
        for (int i = 0; i < 5; i++) {
            if (feedback[i] != null) continue; // Skip characters already correctly matched

            char currentChar = guess.charAt(i);
            boolean matched = false;

            for (int j = 0; j < 5; j++) {
                if (!used[j] && secretWord.charAt(j) == currentChar) {
                    matched = true;
                    used[j] = true; // Mark character in the secret word as used
                    break;
                }
            }

            if (matched) {
                feedback[i] = yellow + currentChar + reset;
            } else {
                feedback[i] = String.valueOf(currentChar); // Leave uncolored if incorrect
            }
        }

        return feedback;
    }
}