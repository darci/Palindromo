package oi.github.darci.palindromo.view.palindrome.list;

import oi.github.darci.palindromo.data.model.Palindrome;
import oi.github.darci.palindromo.data.palindrome.delete.PalindromeDelete;
import oi.github.darci.palindromo.data.palindrome.list.PalindromeList;

public class ListPalindromePresenter implements ListPalindromeContract.Presenter {
    private PalindromeList palindromeList;
    private PalindromeDelete palindromeDelete;

    private ListPalindromeContract.View view;

    public ListPalindromePresenter(PalindromeList palindromeList, PalindromeDelete palindromeDelete) {
        this.palindromeList = palindromeList;
        this.palindromeDelete = palindromeDelete;
    }


    @Override
    public void attach(ListPalindromeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void delete(Palindrome palindrome) {
        palindromeDelete.delete(palindrome);
        list();
    }

    @Override
    public void list() {
        view.update(palindromeList.list());
    }
}
