package oi.github.darci.palindromo.application;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import oi.github.darci.palindromo.dagger.DaggerPalindromeComponent;
import oi.github.darci.palindromo.dagger.PalindromeComponent;

public class PalindromeApplication extends Application {
    private static PalindromeComponent palindromeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initDagger();

    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().name("palindrome.realm").deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }

    private void initDagger() {
        palindromeComponent = DaggerPalindromeComponent.builder().build();
    }

    public static PalindromeComponent getPalindromeComponent() {
        return palindromeComponent;
    }
}
