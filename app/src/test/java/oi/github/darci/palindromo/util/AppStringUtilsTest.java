package oi.github.darci.palindromo.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppStringUtilsTest {
    @Test
    public void onlyLettersShouldReturnEmptyWhenStringIsNull() {
        // Given
        String str = null;

        // When
        String result = AppStringUtils.onlyLetters(str);

        // Then
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void onlyLettersShouldReturnEmptyWhenStringIsEmpty() {
        // Given
        String str = StringUtils.SPACE;

        // When
        String result = AppStringUtils.onlyLetters(str);

        // Then
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void onlyLettersShouldReturnOnlyLetterWhenStringContainsSpaces() {
        // Given
        String str = "Ola mundo";

        // When
        String result = AppStringUtils.onlyLetters(str);
        String expected = "Olamundo";

        // Then
        assertEquals(expected, result);
    }

    @Test
    public void onlyLettersShouldReturnOnlyLetterWhenStringContainsSpecialCharacters() {
        // Given
        String str = "Olá, mundo!";

        // When
        String result = AppStringUtils.onlyLetters(str);
        String expected = "Olamundo";

        // Then
        assertEquals(expected, result);
    }


}
