package oi.github.darci.palindromo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static oi.github.darci.palindromo.util.PalindromeUtils.isPalindrome;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class MainActivity extends AppCompatActivity {
    private EditText palindromeEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
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
