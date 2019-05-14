package oi.github.darci.palindromo.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PalindromeUtilsTest {
    @Test
    public void shouldReturnFalseWhenPalindromeStringIsNull() {
        // Given
        String palindromeString = null;

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenPalindromeStringIsEmpty() {
        // Given
        String palindromeString = "";

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenPalindromeStringHasOneLetter() {
        // Given
        String palindromeString = "A";

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenPalindromeStringOddSized() {
        // Given
        String palindromeString = "SATOR AREPO TENET OPERA ROTAS";

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenPalindromeStringEvenSized() {
        // Given
        String palindromeString = "Roma me tem amor";

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenPalindromeStringContainsSpecialCharacters() {
        // Given
        String palindromeString = "Olé! Maracujá, caju, caramelo.";

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenPalindromeStringIsNotPalindrome() {
        // Given
        String palindromeString = "Olé! Maracujá.";

        // When
        boolean result = PalindromeUtils.isPalindrome(palindromeString);

        // Then
        assertFalse(result);
    }
}
