package oi.github.darci.palindromo.dagger;

import dagger.Module;
import dagger.Provides;
import oi.github.darci.palindromo.data.palindrome.insert.PalindromeInsert;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromeContract;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromePresenter;

@Module
public class PalindromeContractModule {
    @Provides
    InsertPalindromeContract.Presenter provideInsertPresenter(PalindromeInsert palindromeInsert) {
        return new InsertPalindromePresenter(palindromeInsert);
    }

}
