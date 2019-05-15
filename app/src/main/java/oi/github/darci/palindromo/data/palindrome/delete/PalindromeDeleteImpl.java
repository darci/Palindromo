package oi.github.darci.palindromo.data.palindrome.delete;

import io.realm.Realm;
import oi.github.darci.palindromo.data.model.Palindrome;


public class PalindromeDeleteImpl implements PalindromeDelete {

    public void delete(Palindrome palindrome) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Palindrome parentdb = realm.where(Palindrome.class).equalTo(Palindrome.ID_KEY, palindrome.getIdKey()).findFirst();
        if (parentdb != null) {
            parentdb.deleteFromRealm();
        }
        realm.commitTransaction();
        realm.close();
    }
}
