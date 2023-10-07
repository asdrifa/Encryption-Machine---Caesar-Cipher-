/**
 * The EncryptionMachine class implements an encryption algorithm - Caesar Cipher.
 *
 *
 * @author [Sabrina Sanjida Rifa]
 */
import java.util.Scanner;

public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the CSCI717 Encryption Machine Construction!");
        System.out.println("The program lets you encrypt a message with a key for your recipient to decrypt");
        System.out.println(); // Print a blank line
        System.out.print("Enter key: ");
        String firstWord = scanner.next();
        String encryptedFirstWord = encryptWord(firstWord, SHIFT);
        System.out.println("\"" + firstWord + "\" has been encrypted to: " + encryptedFirstWord);
        System.out.println(); // Print a blank line
        System.out.print("\nHow many words is your message? ");
        int numWords = scanner.nextInt();
        System.out.println(); // Print a blank line
        
        for (int i = 1; i < numWords; i++) {
            System.out.print("Next word: ");
            String word = scanner.next();
            String encryptedWord = encryptWord(word, SHIFT);
            System.out.println("\"" + word + "\" has been encrypted to: " + encryptedWord);
            System.out.println(); // Print a blank line
        }
        
        System.out.println("\nMessage fully encrypted. Happy secret messaging!");

        scanner.close();
    }

    /**
     * Encrypts a single letter using a custom encryption technique.
     *
     * @param letter The letter to be encrypted
     * @param shift  The shift value for encryption
     * @return The encrypted letter
     */
    public static char encryptLetter(char letter, int shift) {
        int index = ALPHABET.indexOf(letter);
        int encryptedIndex = (index + shift) % ALPHABET.length();
        return ALPHABET.charAt(encryptedIndex);
    }

    /**
     * Encrypts a word using a custom encryption technique.
     *
     * @param word  The word to be encrypted
     * @param shift The shift value for encryption
     * @return The encrypted word
     */
    public static String encryptWord(String word, int shift) {
        StringBuilder encryptedWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            char encryptedLetter = encryptLetter(letter, shift);
            encryptedWord.append(encryptedLetter);
        }
        return encryptedWord.toString();
    }
}
