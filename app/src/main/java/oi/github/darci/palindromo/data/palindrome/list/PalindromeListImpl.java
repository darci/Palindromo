package oi.github.darci.palindromo.data.palindrome.list;

import java.util.List;

import io.realm.Realm;
import oi.github.darci.palindromo.data.model.Palindrome;


public class PalindromeListImpl implements PalindromeList {

    public List<Palindrome> list() {
        Realm realm = Realm.getDefaultInstance();
        List<Palindrome> palindromes= realm.copyFromRealm(realm.where(Palindrome.class).findAll());
        realm.close();
        return palindromes;
    }
}
