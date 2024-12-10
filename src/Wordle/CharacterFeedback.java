package Wordle;

/**
 * The CharacterFeedback class is responsible for encapsulating feedback
 * information related to a specific character in a Wordle guess. It indicates
 * whether the character is in the correct position or present in the word,
 * and provides methods to retrieve and display this information in a formatted way.
 */
public class CharacterFeedback {
    // Fields to store character information and feedback
    private String character; // The character from the guess
    private boolean isCorrectPosition; // Indicates if the character is in the correct position
    private boolean isPresentInWord; // Indicates if the character is present in the word

    /**
     * Constructs a CharacterFeedback object with specified character and feedback attributes.
     *
     * @param character The character being evaluated.
     * @param isCorrectPosition True if the character is in the correct position, false otherwise.
     * @param isPresentInWord True if the character is present in the word but in the wrong position.
     */
    public CharacterFeedback(char character, boolean isCorrectPosition, boolean isPresentInWord) {
        setCharacter(character);
        setIsCorrectPosition(isCorrectPosition);
        setIsPresentInWord(isPresentInWord);
    }

    /**
     * Sets the character being evaluated.
     *
     * @param character The character to set.
     */
    public void setCharacter(char character) {
        this.character = String.valueOf(character);
    }

    /**
     * Returns the character being evaluated.
     *
     * @return The current character.
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Sets whether the character is in the correct position.
     *
     * @param isCorrectPosition A boolean indicating if the character is correctly positioned.
     */
    public void setIsCorrectPosition(boolean isCorrectPosition) {
        this.isCorrectPosition = isCorrectPosition;
    }

    /**
     * Returns whether the character is in the correct position.
     *
     * @return True if the character is in the correct position, false otherwise.
     */
    public boolean getCorrectPosition() {
        return isCorrectPosition;
    }

    /**
     * Sets whether the character is present in the word but not in the correct position.
     *
     * @param isPresentInWord A boolean indicating if the character is present in the word.
     */
    public void setIsPresentInWord(boolean isPresentInWord) {
        this.isPresentInWord = isPresentInWord;
    }

    /**
     * Returns whether the character is present in the word.
     *
     * @return True if the character is present in the word, false otherwise.
     */
    public boolean getPresentInWord() {
        return isPresentInWord;
    }

    /**
     * Applies color formatting to the character based on its feedback status.
     * The character is colored green if it is in the correct position,
     * and yellow if it is present in the word but in an incorrect position.
     */
    public void color() {
        if (isCorrectPosition) {
            character = "\033[32m" + character + "\033[0m"; // Green for correct position
        } else if (isPresentInWord) {
            character = "\033[93m" + character + "\033[0m"; // Yellow for present but incorrect position
        }
    }
}