package Wordle;

/**
 * The Player class represents a participant in the Wordle game.
 * It holds basic information about the player, including an ID and a name.
 */
public class Player {
    // Fields representing the player's ID and name
    private int playerId; // Unique identifier for the player
    private String playerName; // Name of the player

    /**
     * Constructs a new Player object with a specified ID and name.
     *
     * @param playerId A unique identifier for the player.
     * @param playerName The name of the player.
     */
    public Player(int playerId, String playerName) {
        setPlayerId(playerId);
        setPlayerName(playerName);
    }

    /**
     * Sets the player's unique identifier.
     *
     * @param playerId The new ID for the player.
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Returns the player's unique identifier.
     *
     * @return The player's ID.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Sets the player's name.
     *
     * @param playerName The new name for the player.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Returns the player's name.
     *
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    // Potential method for obtaining the player's statistics
    // public PlayerStats getStats() {
    //     // Implementation placeholder for retrieving player's statistics
    // }
}