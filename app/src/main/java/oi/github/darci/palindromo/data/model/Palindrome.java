package oi.github.darci.palindromo.data.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Palindrome extends RealmObject {
    @PrimaryKey
    private Long idKey;

    private String text;

    @Ignore
    public static final String ID_KEY = "idKey";

    public Palindrome() {
        //https://stackoverflow.com/questions/46929342/custom-constructor-error-with-realm-model-class
    }

    public Palindrome(Long idKey, String text) {
        this.idKey = idKey;
        this.text = text;
    }

    public long getIdKey() {
        return idKey;
    }

    public void setIdKey(long idKey) {
        this.idKey = idKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
