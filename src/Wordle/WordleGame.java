package Wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The WordleGame class simulates a word-guessing game similar to Wordle.
 * It manages game state, user input, and feedback on guesses, tracking the
 * player's attempts to guess a secret word within a maximum number of tries.
 */
public class WordleGame {
    // 2D Array to represent the guess grid, initialized with empty strings
    private final String[][] grid;
    private Scanner scanner;
    Scanner keyboard = new Scanner(System.in);

    // Constants and fields related to game mechanisms
    protected final byte MAX_ATTEMPTS = 6; // Maximum number of attempts allowed
    protected String secretWord; // The word to be guessed
    private boolean isGameOver; // Indicates if the game has ended
    private byte currentAttempt; // Tracks the current attempt index
    private int attempts; // Number of attempts made by the player
    private Player player; // The current player using the game
    private int gameScore; // The score of the current game session

    /**
     * Constructs a new WordleGame session with a specific player and secret word.
     *
     * @param player The player participating in this game session.
     * @param secretWord The word to be guessed, upon which the game relies.
     */
    public WordleGame(Player player, String secretWord) {
        setPlayer(player);
        setSecretWord(secretWord);
        setCurrentAttempt((byte) 0);
        setAttempts(0);
        setGameScore(0);
        setIsGameOver(false);
        this.grid = new String[MAX_ATTEMPTS][secretWord.length()];
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            for (int j = 0; j < secretWord.length(); j++) {
                grid[i][j] = " "; // Initialize grid as empty
            }
        }
    }

    // Getter and setter methods for various game attributes

    public byte getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public byte getCurrentAttempt() {
        return currentAttempt;
    }

    public void setCurrentAttempt(byte currentAttempt) {
        this.currentAttempt = currentAttempt;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    /**
     * Initializes a new game session, resetting the grid and necessary fields,
     * and prints the initial empty grid layout.
     */
    public void startGame() {
        setIsGameOver(false);
        setCurrentAttempt((byte) 0);
        setGameScore(0);
        printGrid();
    }

    /**
     * Submits a player's guess, providing feedback on the guess's validity
     * and correctness, and updates game state accordingly.
     *
     * @param guess The word guessed by the player.
     * @return A boolean representing whether the guess was valid and accepted.
     */
    public boolean submitGuess(String guess) {
        if (isGameOver) {
            System.out.println("Game over");
            return false;
        }

        if (guess.length() != 5 || guess.contains(" ")) {
            System.out.println("Invalid guess. Write a 5 letter word without spaces.");
            return false;
        }

        if (guess.equals(secretWord)) {
            System.out.println("Congratulations! You've guessed the word correctly.");
            isGameOver = true;
        } else if (attempts >= MAX_ATTEMPTS - 1) {
            System.out.println("Out of attempts! The secret word was: " + secretWord);
            isGameOver = true;
        }

        return true;
    }

    /**
     * Ends the current game session, marking the game as complete.
     */
    public void endSession() {
        setIsGameOver(true);
        System.out.println("Game session ended");
    }

    /**
     * Prints the current state of the game grid, displaying all previous guesses
     * and the feedback they're matched with.
     */
    public void printGrid() {
        System.out.println("┌───┬───┬───┬───┬───┐");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("│");
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    // Ensure each cell has exactly 3 printable spaces
                    String cell = grid[i][j].replaceAll("\033\\[[;\\d]*m", ""); // Remove ANSI codes for length
                    int padding = 3 - cell.length(); // Calculate padding
                    System.out.print(" ".repeat(padding / 2) + grid[i][j] + " ".repeat((padding + 1) / 2) + "│");
                } else {
                    System.out.print("   │"); // Empty space for unused cells
                }
            }
            System.out.println();
            if (i < grid.length - 1) {
                System.out.println("├───┼───┼───┼───┼───┤");
            }
        }
        System.out.println("└───┴───┴───┴───┴───┘");
    }

    /**
     * Fills the game grid with a player's guess and updates feedback.
     * Clears the console and reprints the grid layout after each guess.
     *
     * @param guess The word the player has guessed.
     */
    public void fillGrid(String guess) {
        if (submitGuess(guess)) {
            Attempt attempt = new Attempt(guess, secretWord);
            String[] feedback = attempt.generateFeedback(guess, secretWord); // Get color-coded feedback

            // Populate the grid row for the current attempt
            for (int i = 0; i < feedback.length; i++) {
                grid[attempts][i] = feedback[i]; // Directly assign each feedback element
            }

            attempts++; // Increment attempts
            System.out.print("\033[H\033[2J"); // Clear console
            System.out.flush();
            printGrid(); // Print the updated grid
        }
    }
}