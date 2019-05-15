package oi.github.darci.palindromo.view;


public interface BasePresenter<V> {
    void attach(V view);

    void detach();
}
