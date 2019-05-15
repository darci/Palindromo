package oi.github.darci.palindromo.view.palindrome.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import oi.github.darci.palindromo.R;
import oi.github.darci.palindromo.application.PalindromeApplication;
import oi.github.darci.palindromo.data.model.Palindrome;

import javax.inject.Inject;
import java.util.List;

public class ListPalindromeActivity extends AppCompatActivity implements ListPalindromeContract.View {

    @Inject
    ListPalindromeContract.Presenter presenter;

    @BindView(R.id.palindromes_recycler_view)
    RecyclerView palindromesRecyclerView;


    @BindView(R.id.without_palindrome_text)
    TextView withoutPalindromeTextView;

    @BindView(R.id.menu_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PalindromeApplication.getPalindromeComponent().inject(this);
        presenter.attach(this);
        setupRecycler();
    }

    private void setupRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        palindromesRecyclerView.setLayoutManager(layoutManager);
        palindromesRecyclerView.setAdapter(new PalindromeAdapter(this, presenter));
        palindromesRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void update(List<Palindrome> palindromes) {
        withoutPalindromeTextView.setVisibility(palindromes.isEmpty() ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void setPresenter(ListPalindromeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
