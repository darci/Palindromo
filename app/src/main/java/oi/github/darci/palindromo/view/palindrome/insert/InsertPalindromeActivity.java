package oi.github.darci.palindromo.view.palindrome.insert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import oi.github.darci.palindromo.R;
import oi.github.darci.palindromo.application.PalindromeApplication;
import oi.github.darci.palindromo.data.palindrome.insert.PalindromeInsert;
import oi.github.darci.palindromo.data.palindrome.list.PalindromeList;

import static oi.github.darci.palindromo.util.PalindromeUtils.isPalindrome;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class InsertPalindromeActivity extends AppCompatActivity {
    @Inject
    PalindromeInsert palindromeInsert;

    @Inject
    PalindromeList palindromeList;

    private EditText palindromeEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_insert);
        bindView();
        PalindromeApplication.getPalindromeComponent().inject(this);
    }

    private void bindView() {
        palindromeEditText = findViewById(R.id.palindrome_edit_text);
        resultTextView = findViewById(R.id.text_result_text_view);
    }

    public void verifyBtbClick(View view) {
        String palindromeText = palindromeEditText.getText().toString();
        if (isBlank(palindromeText)) {
            return;
        }
        if (isPalindrome(palindromeText)) {
            resultTextView.setText(getText(R.string.is_palindrome).toString()
                    .replace("{{palindrome}}", palindromeText));
            return;
        }
        resultTextView.setText(getText(R.string.is_not_palindrome).toString()
                .replace("{{palindrome}}", palindromeText));
    }
}
