package oi.github.darci.palindromo.view.palindrome.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import oi.github.darci.palindromo.R;

/**
 * Created by darci on 15/05/19.
 */
public class PalindromeViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton deleteButton;

    public PalindromeViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.main_line_title);
        deleteButton = (ImageButton) itemView.findViewById(R.id.main_line_delete);
    }
}