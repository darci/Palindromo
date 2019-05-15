package oi.github.darci.palindromo.view.palindrome.insert;

import oi.github.darci.palindromo.data.model.Palindrome;
import oi.github.darci.palindromo.data.palindrome.insert.PalindromeInsert;

public class InsertPalindromePresenter implements InsertPalindromeContract.Presenter {
    private PalindromeInsert palindromeInsert;

    private InsertPalindromeContract.View view;

    public InsertPalindromePresenter(PalindromeInsert palindromeInsert) {
        this.palindromeInsert = palindromeInsert;
    }

    @Override
    public void insertPalindrome(Palindrome palindrome) {
        palindromeInsert.insert(palindrome);
        view.inserted();
    }

    @Override
    public void attach(InsertPalindromeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void detach() {
        this.view= null;
    }
}
