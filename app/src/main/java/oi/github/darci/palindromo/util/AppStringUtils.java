package oi.github.darci.palindromo.util;


import static org.apache.commons.lang3.StringUtils.isBlank;

public final class AppStringUtils {
    private AppStringUtils() {
    }

    public static String onlyLetters(String str) {
        if (isBlank(str)) {
            return org.apache.commons.lang3.StringUtils.EMPTY;
        }
        return org.apache.commons.lang3.StringUtils.stripAccents(str).replaceAll("\\P{L}+", "");
    }

}
