package oi.github.darci.palindromo.data.palindrome.insert;


import io.realm.Realm;
import oi.github.darci.palindromo.data.model.Palindrome;

public class PalindromeInsertImpl implements PalindromeInsert {

    public void insert(Palindrome palindrome) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Number currentIdNum = realm.where(Palindrome.class).max(Palindrome.ID_KEY);
        long idKey = currentIdNum == null ? 1 : currentIdNum.intValue() + 1;
        palindrome.setIdKey(idKey);
        realm.copyToRealm(palindrome);
        realm.commitTransaction();
    }
}
