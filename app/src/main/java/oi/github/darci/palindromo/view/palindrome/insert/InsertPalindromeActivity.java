package oi.github.darci.palindromo.view.palindrome.insert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import oi.github.darci.palindromo.R;
import oi.github.darci.palindromo.application.PalindromeApplication;
import oi.github.darci.palindromo.data.model.Palindrome;

import static oi.github.darci.palindromo.util.PalindromeUtils.isPalindrome;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class InsertPalindromeActivity extends AppCompatActivity
        implements InsertPalindromeContract.View {

    @Inject
    InsertPalindromeContract.Presenter presenter;

    @BindView(R.id.palindrome_edit_text)
    EditText palindromeEditText;

    @BindView(R.id.text_result_text_view)
    TextView resultTextView;

    @BindView(R.id.add_button)
    Button addPalindromeButton;

    @BindView(R.id.menu_toolbar)
    Toolbar toolbar;

    private String lastPalindrome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_insert);
        ButterKnife.bind(this);
        PalindromeApplication.getPalindromeComponent().inject(this);
        presenter.attach(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorites:
                Toast.makeText(this, "TODO", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    public void verifyBtbClick(View view) {
        String palindromeText = palindromeEditText.getText().toString();
        if (isBlank(palindromeText)) {
            return;
        }
        if (isPalindrome(palindromeText)) {
            showPalindrome(palindromeText);
            return;
        }
        showNotPalindrome(palindromeText);
    }

    public void addBtbClick(View view) {
        presenter.insertPalindrome(new Palindrome(null, lastPalindrome));
    }

    private void showPalindrome(String palindromeText) {
        lastPalindrome = palindromeText;
        addPalindromeButton.setVisibility(View.VISIBLE);
        resultTextView.setText(getText(R.string.is_palindrome).toString()
                .replace("{{palindrome}}", palindromeText));
    }

    private void showNotPalindrome(String palindromeText) {
        addPalindromeButton.setVisibility(View.GONE);
        resultTextView.setText(getText(R.string.is_not_palindrome).toString()
                .replace("{{palindrome}}", palindromeText));
    }

    @Override
    public void inserted() {
        lastPalindrome = null;
        palindromeEditText.setText(StringUtils.EMPTY);
        addPalindromeButton.setVisibility(View.GONE);
        resultTextView.setText(getText(R.string.waiting_text).toString());
        Toast.makeText(this, getText(R.string.palindrome_inserted), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(InsertPalindromeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
