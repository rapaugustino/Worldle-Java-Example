package Wordle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the Wordle game application.
 * It handles user interaction, initializes game components, and manages
 * the main game loop where players can play the game, view a leaderboard,
 * or exit the application.
 */
public class Main {

    /**
     * The main method starts the Wordle game, presenting options to the user to
     * start a game, view the leaderboard, or exit. It handles user inputs and runs
     * the game loop until the user decides to quit.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // List of possible secret words
        List<String> initialWords = Arrays.asList(
                "APPLE", "ALERT", "BEACH", "BROAD", "CHEAP", "DAILY", "BROKE", "CHECK",
                "DANCE", "BROWN", "CHAIR", "CRISP", "EARTH", "FAITH", "FIELD", "FLAIR",
                "FRESH", "GIANT", "GRACE", "HAPPY", "HEART", "HOUSE", "INDEX", "JUICE",
                "LIGHT", "LUNCH", "MONEY", "NIGHT", "OCEAN", "PEACH", "PLANE", "PRIZE",
                "QUIET", "RIVER", "SLEEP", "SMILE", "STORM", "SUGAR", "TABLE", "THINK",
                "TRAIN", "TRUTH", "UNION", "VALUE", "VOICE", "WATCH", "WORLD", "WORTH",
                "YOUTH", "AGILE", "ALIVE", "BLEND", "BLOOM", "BLAST", "BRAVE", "BRICK",
                "CHILL", "CIVIC", "CLEAN", "CLOSE", "CLOUD", "COAST", "CRANE", "CRAFT",
                "DAIRY", "DELAY", "DEPTH", "DRIVE", "ELITE", "ENTER", "EQUAL", "EVERY",
                "FLUID", "FOCUS", "FORCE", "FRAME", "FRUIT", "GLORY", "GRIND", "GROVE",
                "HUMOR", "HONEY", "IDEAL", "IMAGE", "KNOCK", "LEMON", "LOGIC", "MAGIC",
                "MIGHT", "MOUNT", "MUSIC", "NOVEL", "POWER", "PRIME", "QUIRK", "RAISE",
                "RIGHT", "SHARE", "SHINE", "SPACE", "SOLAR", "SOUND", "STAGE", "TREND", "UNITY"
        );

        while (true) {
            // Display menu options to the user
            System.out.println("Welcome to Wordle!");
            System.out.println("1. Start Game");
            System.out.println("2. Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = keyboard.nextInt();
            keyboard.nextLine(); // Consume newline

            if (choice == 1) {
                // Start a new game session
                Player player1 = new Player(0, "MKH");
                WordList wordList = new WordList(initialWords);
                WordleGame gameSession = new WordleGame(player1, wordList.getRandomWord());
                Attempt attempt = new Attempt("", gameSession.getSecretWord());
                gameSession.startGame();
                System.out.println("Secret word for testing: " + gameSession.getSecretWord()); // Debugging aid

                while (!gameSession.getIsGameOver()) {
                    String guess = keyboard.nextLine();
                    if (gameSession.submitGuess(guess)) {
                        attempt.generateFeedback(guess.toUpperCase(), gameSession.getSecretWord());
                        gameSession.fillGrid(guess.toUpperCase());
                    }
                }
            } else if (choice == 2) {
                // Display the leaderboard
                System.out.println("Hello World"); // Placeholder for leaderboard functionality
            } else if (choice == 3) {
                // Exit the application
                System.out.println("Goodbye!");
                break;
            } else {
                // Handle invalid menu selection
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
}