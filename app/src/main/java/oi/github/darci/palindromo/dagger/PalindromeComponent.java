package oi.github.darci.palindromo.dagger;

import dagger.Component;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromeActivity;


@Component(modules = {PalindromeModule.class})
public interface PalindromeComponent {
    void inject(InsertPalindromeActivity activity);
}
