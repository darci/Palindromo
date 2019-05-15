package oi.github.darci.palindromo.dagger;

import dagger.Module;
import dagger.Provides;
import oi.github.darci.palindromo.data.palindrome.count.PalindromeCount;
import oi.github.darci.palindromo.data.palindrome.count.PalindromeCountImpl;
import oi.github.darci.palindromo.data.palindrome.delete.PalindromeDelete;
import oi.github.darci.palindromo.data.palindrome.delete.PalindromeDeleteImpl;
import oi.github.darci.palindromo.data.palindrome.insert.PalindromeInsert;
import oi.github.darci.palindromo.data.palindrome.insert.PalindromeInsertImpl;
import oi.github.darci.palindromo.data.palindrome.list.PalindromeList;
import oi.github.darci.palindromo.data.palindrome.list.PalindromeListImpl;

@Module
public class PalindromeModule {

    @Provides
    PalindromeInsert providePalindromeInsert() {
        return new PalindromeInsertImpl();
    }

    @Provides
    PalindromeCount providePalindromeCount() {
        return new PalindromeCountImpl();
    }

    @Provides
    PalindromeList providePalindromeList() {
        return new PalindromeListImpl();
    }

    @Provides
    PalindromeDelete providePalindromeDelete() {
        return new PalindromeDeleteImpl();
    }
}
