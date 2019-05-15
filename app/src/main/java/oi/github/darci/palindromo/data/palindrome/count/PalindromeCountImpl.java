package oi.github.darci.palindromo.data.palindrome.count;

import io.realm.Realm;
import oi.github.darci.palindromo.data.model.Palindrome;


public class PalindromeCountImpl implements PalindromeCount {

    public long count() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.beginTransaction();
        long count = realm.where(Palindrome.class).count();
        realm.close();
        return count;

    }
}
