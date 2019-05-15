package oi.github.darci.palindromo.dagger;

import dagger.Module;
import dagger.Provides;
import oi.github.darci.palindromo.data.palindrome.delete.PalindromeDelete;
import oi.github.darci.palindromo.data.palindrome.insert.PalindromeInsert;
import oi.github.darci.palindromo.data.palindrome.list.PalindromeList;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromeContract;
import oi.github.darci.palindromo.view.palindrome.insert.InsertPalindromePresenter;
import oi.github.darci.palindromo.view.palindrome.list.ListPalindromeContract;
import oi.github.darci.palindromo.view.palindrome.list.ListPalindromePresenter;

@Module
public class PalindromeContractModule {
    @Provides
    InsertPalindromeContract.Presenter provideInsertPresenter(PalindromeInsert palindromeInsert) {
        return new InsertPalindromePresenter(palindromeInsert);
    }

    @Provides
    ListPalindromeContract.Presenter provideListPresenter(PalindromeList palindromeList, PalindromeDelete palindromeDelete) {
        return new ListPalindromePresenter(palindromeList, palindromeDelete);
    }

}
