package oi.github.darci.palindromo.data.palindrome.insert;


import io.realm.Realm;
import oi.github.darci.palindromo.data.model.Palindrome;
import oi.github.darci.palindromo.data.palindrome.count.PalindromeCount;

public class PalindromeInsertImpl implements PalindromeInsert {

    private PalindromeCount palindromeCount;

    public PalindromeInsertImpl(PalindromeCount palindromeCount) {
        this.palindromeCount = palindromeCount;
    }

    public void insert(Palindrome palindrome) {
        palindrome.setIdKey(palindromeCount.count() + 1);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(palindrome);
        realm.commitTransaction();
    }
}
