package Wordle;

/**
 * The PlayerStats class tracks and manages the statistics of a player,
 * such as the number of games won, games played, and the player's score.
 * This class provides methods to update and retrieve these statistics,
 * ensuring a comprehensive view of a player's performance over time.
 */
public class PlayerStats {
    // Fields representing the player's statistics
    private int totalGamesWon; // Total number of games the player has won
    private int totalGamesPlayed; // Total number of games the player has played
    private int playerScore; // Cumulative score of the player

    /**
     * Constructs a new PlayerStats object with specified values for the total
     * games won, total games played, and the player's score.
     *
     * @param totalGamesWon The total number of games the player has won.
     * @param totalGamesPlayed The total number of games the player has played.
     * @param playerScore The cumulative score of the player.
     */
    public PlayerStats(int totalGamesWon, int totalGamesPlayed, int playerScore) {
        setTotalGamesWon(totalGamesWon);
        setTotalGamesPlayed(totalGamesPlayed);
        setPlayerScore(playerScore);
    }

    /**
     * Sets the total number of games the player has won.
     *
     * @param totalGamesWon The new total games won by the player.
     */
    public void setTotalGamesWon(int totalGamesWon) {
        this.totalGamesWon = totalGamesWon;
    }

    /**
     * Returns the total number of games the player has won.
     *
     * @return The total games won by the player.
     */
    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    /**
     * Sets the total number of games the player has played.
     *
     * @param totalGamesPlayed The new total games played by the player.
     */
    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    /**
     * Returns the total number of games the player has played.
     *
     * @return The total games played by the player.
     */
    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    /**
     * Sets the player's cumulative score.
     *
     * @param playerScore The new score of the player.
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    /**
     * Returns the player's cumulative score.
     *
     * @return The score of the player.
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Prints a summary of the player's statistics, including total games won,
     * total games played, and the player's score. This method can be expanded
     * to format and display more detailed statistics if necessary.
     */
    public void getStatsSummary() {
        // Implementation placeholder for generating and printing player's statistics summary
    }
}