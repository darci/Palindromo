package oi.github.darci.palindromo.view.palindrome.list;


import java.util.List;

import oi.github.darci.palindromo.data.model.Palindrome;
import oi.github.darci.palindromo.view.BasePresenter;
import oi.github.darci.palindromo.view.BaseView;

public interface ListPalindromeContract {
    interface View extends BaseView<Presenter> {
        void update(List<Palindrome> palindromes);
    }

    interface Presenter extends BasePresenter<View> {
        void delete(Palindrome palindrome);

        void list();
    }
}
