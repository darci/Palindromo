package oi.github.darci.palindromo.view.palindrome.insert;


import oi.github.darci.palindromo.data.model.Palindrome;
import oi.github.darci.palindromo.view.BasePresenter;
import oi.github.darci.palindromo.view.BaseView;

public interface InsertPalindromeContract {
    interface View extends BaseView<Presenter> {
        void inserted();
    }

    interface Presenter extends BasePresenter<View> {
        void insertPalindrome(Palindrome palindrome);
    }
}
