package oi.github.darci.palindromo.dagger;

import dagger.Component;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromeActivity;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromeContract;


@Component(modules = {PalindromeModule.class, PalindromeContractModule.class})
public interface PalindromeComponent {
    void inject(InsertPalindromeActivity activity);
    void inject(InsertPalindromeContract.Presenter presenter);
}
