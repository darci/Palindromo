package oi.github.darci.palindromo.util;


import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.isBlank;

public final class PalindromeUtils {
    private PalindromeUtils() {
    }

    public static boolean isPalindrome(String palindromeText) {
        palindromeText = AppStringUtils
                .onlyLetters(palindromeText)
                .toLowerCase(Locale.getDefault());
        if (isBlank(palindromeText)) {
            return false;
        }
        return isPalindrome(palindromeText.toCharArray());
    }

    private static boolean isPalindrome(char[] palindromeText) {
        int textSize = palindromeText.length;
        for (int i = 0; i < (textSize / 2); ++i) {
            if (palindromeText[i] != palindromeText[textSize - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
